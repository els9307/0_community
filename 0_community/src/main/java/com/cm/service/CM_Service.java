package com.cm.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cm.mapper.CM_Mapper;
import com.cm.vo.CM_BOARD;
import com.cm.vo.CM_COMMENT;
import com.cm.vo.CM_USERINFO;

@Service("cm_service")
public class CM_Service {
	
	@Resource(name="cm_mapper")
	private CM_Mapper cm_mapper;
	
	
	public int idChk(CM_USERINFO userinfo) {
		int result = cm_mapper.idChk(userinfo);
		return result;
	}
	
	public void UserJoin(CM_USERINFO userinfo) {
		cm_mapper.UserJoin(userinfo);
	}
	
	public CM_USERINFO UserLogin(CM_USERINFO userinfo) {
		return cm_mapper.UserLogin(userinfo);
	}
	public void UserUpdate(CM_USERINFO userinfo) {
		cm_mapper.UserUpdate(userinfo);
	}
	public int TableCount(String word) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("word",word);
		int count = cm_mapper.TableCount(map);
		return count;
	}
	public List<CM_BOARD> TableList(int startRow,int endRow,String word){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startRow",startRow);
		map.put("endRow",endRow);
		map.put("word",word);
		return cm_mapper.TableList(map);
	}
	public void up_PopularCount(String b_num) {
		cm_mapper.up_PopularCount(b_num);
	}
	public void down_PopularCount(String b_num) {
		cm_mapper.down_PopularCount(b_num);
	}
	public CM_BOARD TableDtailView(String b_num) {
		return cm_mapper.TableDtailView(b_num);
	}
	public void Board_Insert(CM_BOARD board) {
		cm_mapper.Board_Insert(board);
	}
	public void Board_Update(CM_BOARD board) {
		cm_mapper.Board_Update(board);
	}
	public void report_count(String b_num) {
		cm_mapper.report_count(b_num);
	}
	public void Delete(String b_num) {
		cm_mapper.Delete(b_num);
	}
	public List<CM_BOARD> Category(CM_BOARD board){
		return cm_mapper.Category(board);
	}
	public List<CM_BOARD> IndexList(){
		return cm_mapper.IndexList();
	}
	public List<CM_BOARD> IndexImg(){
		return cm_mapper.IndexImg();
	}
	public void TableComment(CM_COMMENT comment) {
		cm_mapper.TableComment(comment);
	}
	public List<CM_COMMENT> CommentList(String b_num){
		return cm_mapper.CommentList(b_num);
	}
}
