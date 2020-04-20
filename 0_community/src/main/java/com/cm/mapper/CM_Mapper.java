package com.cm.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cm.vo.CM_BOARD;
import com.cm.vo.CM_COMMENT;
import com.cm.vo.CM_USERINFO;

@Repository("cm_mapper")
public interface CM_Mapper {
		
	public int idChk(CM_USERINFO userinfo);
	
	public int UserJoin(CM_USERINFO userinfo);

	public CM_USERINFO UserLogin(CM_USERINFO userinfo);
	
	public void UserUpdate(CM_USERINFO userinfo);
	
	public List<CM_BOARD> TableList(HashMap<String, Object> map);
	
	public int TableCount(HashMap<String, Object> map);
	
	public void up_PopularCount(String b_num);
	
	public void down_PopularCount(String b_num);
	
	public CM_BOARD TableDtailView(String b_num);
	
	public void Board_Insert(CM_BOARD board);
	
	public void Board_Update(CM_BOARD board);
	
	public void report_count(String b_num);
	
	public void Delete(String b_num);
	
	public List<CM_BOARD> Category(CM_BOARD board);
	
	public List<CM_BOARD> IndexList();
	
	public List<CM_BOARD> IndexImg();
	
	public void TableComment(CM_COMMENT comment);
	
	public List<CM_COMMENT> CommentList(String b_num);
}
