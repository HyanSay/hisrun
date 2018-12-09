package com.hisrun.demo.underwriting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hisrun.demo.underwriting.dao.NtPrpCmain;
import com.hisrun.demo.underwriting.service.NtPrpCmainService;

@Component
public class NtPrpCmainServiceImpl implements NtPrpCmainService{

 @Autowired
 NtPrpCmain NtPrpCmain;

	public void geta() {
	 NtPrpCmain.CallFuntionGetRikamangeLimitCount();
	}
}
