package com.devesh.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesh.repository.CustomerRepository;
import com.devesh.utils.Constants;
import com.devesh.utils.LanguageUtil;
import com.devesh.utils.WindowsTimeZoneAPI;

@Service
public class MySpringBootServiceImpl {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Map<String, String> getSystemTimezoneList() throws IOException, InterruptedException{
		return WindowsTimeZoneAPI.getTimeZoneMap(Constants.TIMEZONE_LIST_ALL_CMD);
	}
	
	public Map<String, String> getSystemInstalledLanguageList() throws IOException, InterruptedException {
		return LanguageUtil.getInstalledLanguageList((Constants.INSTALLED_LANGUAGE_LIST_PS));
	}

}
