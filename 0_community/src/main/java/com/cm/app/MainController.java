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

import com.cm.mapper.CM_Mapper;
import com.cm.service.CM_Service;
import com.cm.util.UploadFileUtils;
import com.cm.util.pagingAction;
import com.cm.vo.CM_BOARD;
import com.cm.vo.CM_COMMENT;
import com.cm.vo.CM_USERINFO;

@Controller
public class MainController {
	
	@Autowired
	private CM_Service cm_service;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private pagingAction page;
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
			String pwd = pwdEncoder.encode(inputPass);
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
		System.out.println(file.getOriginalFilename());
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
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@GetMapping("CM_TableList")
	public String TableList() {
		logger.info("GET  -  게시판 VIEW 실행");
		return "CM_TableList.c";
	}
	
	@PostMapping("CM_TableList")
	public String TableList(Model model,String pageNum,String word) {
		logger.info("POST  -  게시판 리스트");
		word = word == null ? "" : word;
		String PageHtml;
		if(pageNum == null) pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		int count = cm_service.TableCount(word);
		int pageSize = 5;
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;
		if (endRow > count)
			endRow = count;
		int boardNum = ((currentPage - 1) * pageSize);
		PageHtml = page.paging(count, pageSize, currentPage, word);
		List<CM_BOARD> arr = cm_service.TableList(startRow,endRow,word);
		
		model.addAttribute("pageHtml",PageHtml);
		model.addAttribute("boardNum",boardNum);
		model.addAttribute("arr",arr);
		return "CallBackPage/TableListCallBack";
	}
	
	@PostMapping("CB_TableDetilView")
	public String DetailView_post(String b_num,Model model,String U_check) {
		logger.info("POST  -  게시글 상세보기 실행");
		System.out.println("게시물 넘버"+b_num);
		CM_BOARD board = cm_service.TableDtailView(b_num);
		System.out.println("CB_TableDetilView 체크값"+U_check);
		if(U_check.equals("2")) {
			logger.info("POST  -  UP_COUNT UPDATE 실행");
			cm_service.up_PopularCount(b_num);
		}else if(U_check.equals("3")){
			logger.info("POST  -  DOWN_COUNT UPDATE 실행");
			
			cm_service.down_PopularCount(b_num);
		}
		model.addAttribute("board",board);	
		return "CM_TableDetilView.c";
	}
	@PostMapping("CM_TableUpdate")
	public String UpdateView(String b_num,String U_check,Model model) {
		logger.info("POST  -  UpdateView 상세보기");
		CM_BOARD arr = cm_service.TableDtailView(b_num);
		model.addAttribute("arr",arr);
		return "CM_TableUpdate.c";
	}
	@PostMapping("fileUpload_post")
	public String board_Insert(CM_BOARD board,String check,MultipartFile file,HttpServletRequest req,Model model) throws IOException, Exception {
	
		if(check.equals("1")) {
			logger.info("POST  -  글쓰기");
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = null;
			if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
				fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
				board.setB_img(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
				board.setB_thumbimg(File.separator + "imgUpload" +ymdPath + File.separator + "s" + File.separator + "s_" +fileName);
			}else {
				fileName = "";
				board.setB_img(fileName);
				board.setB_thumbimg(fileName);
			}
			cm_service.Board_Insert(board);
		}
		if(check.equals("2")) {
			logger.info("POST  -  게시글 업데이트 실행");
			if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
				new File(uploadPath + req.getParameter("B_IMG")).delete();
				new File(uploadPath + req.getParameter("B_THUMBIMG")).delete();
				
				String imgUploadPath = uploadPath + File.separator + "imgUpload";
				String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
				String fileName = UploadFileUtils.fileUpload(imgUploadPath,file.getOriginalFilename(),file.getBytes(),ymdPath);
			
				board.setB_img(File.separator + "imgUpload" + ymdPath + File.separator + ymdPath);
				board.setB_thumbimg(File.separator + "imgUpload" +ymdPath + File.separator + "s" + File.separator + "s_" +fileName);
				
			}else {
				board.setB_img(req.getParameter("B_IMG"));
				board.setB_thumbimg(req.getParameter("B_THUMBIMG"));
			}
			cm_service.Board_Update(board);
		}
		if(check.equals("3")) {
			logger.info("POST  -  REPORT_COUNT");
			cm_service.report_count(board.getB_num());
		}
		return "CM_TableList.c";
	}

	@GetMapping("CM_TableInsert")
	public String CM_TableInser() {
		return "CM_TableInsert.c";
	}
	@PostMapping("tableDelete")
	public String Delete(String b_num) {
		System.out.println(b_num);
		cm_service.Delete(b_num);
		return "CM_TableList.c";
	}
	@PostMapping("Category")
	public String CategoryCallBack(CM_BOARD board,Model model) {
		System.out.println("CATEGORY =" + board.getB_category());
		List<CM_BOARD> arr = cm_service.Category(board);
		System.out.println(arr.size());
		model.addAttribute("arr",arr);
		return "CallBackPage/CategoryCallBack";
	}
	@PostMapping("IndexList")
	public String IndexList(String check,Model model) {
		if(check.equals("1")) {
			List<CM_BOARD> arr = cm_service.IndexList();
			model.addAttribute("arr",arr);
			return "CallBackPage/IndexCallBack";
		}
		if(check.equals("2")) {
			List<CM_BOARD> arr = cm_service.IndexImg();
			model.addAttribute("arr",arr);
			return "CallBackPage/IndexImg";
		}
		return "";
	}
	@PostMapping("TableComment")
	public String TableComment(CM_COMMENT comment ,Model model) {
		logger.info("POST  -  TableComment Insert");
		cm_service.TableComment(comment);
		List<CM_COMMENT> arr = cm_service.CommentList(comment.getB_num());
		System.out.println(arr.size());
		model.addAttribute("arr", arr);
		return "CallBackPage/TableCommentCallBack";
	}
	@PostMapping("CommentList")
	public String CommentList(String b_num,Model model) {
		System.out.println("COMMENTLIST"+b_num);
		List<CM_COMMENT> arr = cm_service.CommentList(b_num);
		model.addAttribute("arr", arr);
		return "CallBackPage/TableCommentCallBack";
	}
}
