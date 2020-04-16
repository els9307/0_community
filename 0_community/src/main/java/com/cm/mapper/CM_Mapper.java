package com.cm.mapper;

import org.springframework.stereotype.Repository;

import com.cm.vo.CM_USERINFO;

@Repository("cm_mapper")
public interface CM_Mapper {
		
	public int idChk(CM_USERINFO userinfo);
	
	public int UserJoin(CM_USERINFO userinfo);

	public CM_USERINFO UserLogin(CM_USERINFO userinfo);
	
	public void UserUpdate(CM_USERINFO userinfo);
}
