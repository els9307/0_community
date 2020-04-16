package com.cm.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cm.mapper.CM_Mapper;
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
		
	}
	
	public CM_USERINFO UserLogin(CM_USERINFO userinfo) {
		return cm_mapper.UserLogin(userinfo);
	}
	public void UserUpdate(CM_USERINFO userinfo) {
		cm_mapper.UserUpdate(userinfo);
	}
}
