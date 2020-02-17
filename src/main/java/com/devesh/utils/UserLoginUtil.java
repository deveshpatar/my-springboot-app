package com.devesh.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesh.aop.Loggable;
import com.devesh.entity.UserLogin;
import com.devesh.repository.LoginRepository;

@Service
public class UserLoginUtil {

	@Autowired
	private LoginRepository lr;

	@Loggable
	public boolean authenticate(UserLogin cl) {
		boolean flag = true;
		/*Object rs = null;

		rs = lr.findById(cl.getUsername());
		if (rs != null) {
			UserLogin cl2 = (UserLogin) rs;
			if (cl2.getPassword().equalsIgnoreCase(cl.getPassword())) {
				flag = false;
			}
		}*/

		return flag;
	}

}
