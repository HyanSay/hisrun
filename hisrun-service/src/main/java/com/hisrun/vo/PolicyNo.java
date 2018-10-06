package com.hisrun.vo;

public class PolicyNo {
	// 保单号第一位
	private String policyNo_1;
	// 机构代码
	private String comCode;
	// 个数
	private String count;
	// 年份
	private String year;
	// 险种代码
	private String riskCode;
	// 号码类型
	private String type;

	public String getPolicyNo_1() {
		return policyNo_1;
	}

	public void setPolicyNo_1(String policyNo_1) {
		this.policyNo_1 = policyNo_1;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
