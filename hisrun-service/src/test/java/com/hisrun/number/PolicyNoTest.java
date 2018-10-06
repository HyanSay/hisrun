package com.hisrun.number;

import com.hisrun.utils.JsonUtils;
import com.hisrun.vo.PolicyNo;

import junit.framework.TestCase;

public class PolicyNoTest extends TestCase {

	public void testPolicy2326() throws Exception {

		PolicyNo policyNo = new PolicyNo();
		policyNo.setComCode("110000");
		policyNo.setCount("1");
		policyNo.setPolicyNo_1("3");
		policyNo.setRiskCode("2735");
		policyNo.setType("1");
		policyNo.setYear("2018");

		String reqJson = JsonUtils.obj2Json(policyNo);
		// 批量承保
		for (int i = 0; i < 1; i++) {}
	}
}
