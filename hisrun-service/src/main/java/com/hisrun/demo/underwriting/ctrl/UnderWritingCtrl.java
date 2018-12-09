package com.hisrun.demo.underwriting.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hisrun.demo.underwriting.service.NtPrpCmainService;

@RestController
public class UnderWritingCtrl {

	// log日志
	private Logger logger = LoggerFactory.getLogger(UnderWritingCtrl.class);
	@Autowired
	NtPrpCmainService NtPrpCmainService;

	@RequestMapping(value = "/remoteServer", method = RequestMethod.GET)
	public String savePolicy(HttpServletRequest request) {
		logger.info("sdfalsdf");
		NtPrpCmainService.geta();
		return null;

	}

}
