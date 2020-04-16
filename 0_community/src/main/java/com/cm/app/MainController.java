package com.cm.app;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cm.service.CM_Service;
import com.cm.util.UploadFileUtils;
import com.cm.vo.CM_USERINFO;

@Controller
public class MainController {
	
	@Autowired
	private CM_Service cm_service;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@PostMapping("idChk")
	@ResponseBody
	public int idChk(CM_USERINFO userinfo) {
		logger.info("POST  -  아이디 중복확인 ");
		int result = cm_service.idChk(userinfo);
		return result;
	}
	//로그인시 실행
	@PostMapping("LoginMenu")
	public String LoginMent(CM_USERINFO userinfo,Model model) {
		logger.info("POST  -  LoginMenu 콜백");
		logger.info("접속 아이디 = "+userinfo.getUser_id());
		CM_USERINFO user = cm_service.UserLogin(userinfo);
		model.addAttribute("user",user);
		return "CallBackPage/LoginMenu";
	}
	
	//회원가입
	@PostMapping("User_Join")
	public String User_Join(CM_USERINFO userinfo) {
		logger.info("POST  -  회원가입");
		int result = cm_service.idChk(userinfo);
		if(result == 1) {
			return "C_Login.s";
		}else if(result == 0) {
			String inputPass = userinfo.getUser_pwd();
			System.out.println(inputPass);
			String pwd = pwdEncoder.encode(inputPass);
			System.out.println(pwd);
			userinfo.setUser_pwd(pwd);
			cm_service.UserJoin(userinfo);
		}
		return "CM_Login.s";
	}

	//로그인
	@PostMapping("User_Login")
	public String User_Login(CM_USERINFO userinfo, HttpSession session) {
		CM_USERINFO login = cm_service.UserLogin(userinfo);
		boolean pwdMatch = pwdEncoder.matches(userinfo.getUser_pwd(), login.getUser_pwd());
		if(login != null && pwdMatch == true) {
			session.setAttribute("session_id", userinfo.getUser_id());
			
			return "index.c";
			
		}
		return "C_Login.s";
	}
	@GetMapping("Logout")
	public String UserLogout(HttpSession session) {
		logger.info("GET  -  로그아웃");
		session.invalidate();
		return "index.c";
	}
	@PostMapping("CM_MyPage")
	public String mypage(CM_USERINFO userinfo,Model model) {
		logger.info("POST  -  마이페이지 실행");
		CM_USERINFO user = cm_service.UserLogin(userinfo);
		model.addAttribute("user",user);
		return "CM_MyPage.c";
	}
	
	@PostMapping("UserUpdate")
	public String UserUpdate(CM_USERINFO userinfo,HttpSession session,MultipartFile file,HttpServletRequest req) throws IOException, Exception {
		String inputPass = userinfo.getUser_pwd();
		String pwd = pwdEncoder.encode(inputPass);
		userinfo.setUser_pwd(pwd);
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			new File(uploadPath + req.getParameter("user_img")).delete();
			new File(uploadPath + req.getParameter("user_thumbimg")).delete();

			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
			userinfo.setUser_img(File.separator + "imgUpload" + ymdPath + File.separator + ymdPath);
			userinfo.setUser_thumbimg(File.separator + "imgUpload" +ymdPath + File.separator + "s" + File.separator + "s_" +fileName);
		}else {
			userinfo.setUser_img(req.getParameter("user_img"));
			userinfo.setUser_thumbimg(req.getParameter("user_thumbimg"));
		}
		cm_service.UserUpdate(userinfo);
		session.invalidate();
		return "redirect:/";
	}
}
