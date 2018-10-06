package com.hisrun.number.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hisrun.number.service.PoliyNoService;
import com.hisrun.redis.redisconfig.RedisClusterConfig;
import com.hisrun.utils.DateTimeUtils;
import com.hisrun.utils.JsonUtils;
import com.hisrun.utils.StringUtils;
import com.hisrun.vo.PolicyNo;
import com.hisrun.vo.ResPolicyNo;

import redis.clients.jedis.JedisCluster;

@Transactional
@Scope(value = "prototype")
@Service
public class PoliyNoServiceImpl implements PoliyNoService {

	private Logger logger = Logger.getLogger(PoliyNoServiceImpl.class);

	@Autowired
	private RedisClusterConfig redisClusterConfig;
	

	public String policyNoList(String policyNoJson) {
		PolicyNo policyNo = JsonUtils.json2Obj(policyNoJson, PolicyNo.class);
		JedisCluster jedisCluster = redisClusterConfig.redisCluster();
		String policyNoStr = null;
		List<ResPolicyNo> resPolicyNoList = null;

		// 规则校验
		String policyNo_1 = policyNo.getPolicyNo_1();
		String type = policyNo.getType();
		String comCode = policyNo.getComCode();
		String count = policyNo.getCount();
		String riskCode = policyNo.getRiskCode();
		String year = policyNo.getYear();

		if (!"".equals(comCode) && null != comCode) {
			comCode = comCode.substring(0, 6);
		} else {
			comCode = "000000";
		}
		if (!"".equals(count) && null != count) {

		} else {
			count = "1";
		}
		if (!"".equals(riskCode) && null != riskCode) {
		} else {
			riskCode = "0000";
		}
		if (!"".equals(year) && null != year) {
		} else {
			year = DateTimeUtils.dateToYearStr();
		}

		StringBuffer sb = new StringBuffer();
		if (!"".equals(type) && null != type) {
			if (type.equals("1")) {// 1 为小保险单号
				String subYear = year.substring(2, 4);
				sb.append(policyNo_1);
				sb.append(riskCode);
				sb.append(subYear);
				policyNoStr = sb.toString();

				// 先获取redis中是否存储了该值
				String key = type + riskCode + comCode;
				String resRedisValue = jedisCluster.get(key);
				ResPolicyNo resPolicyNo = new ResPolicyNo();
				if (null != resRedisValue && !"".equals(resRedisValue)) {
					String seqNo = StringUtils.autoGenericCode(resRedisValue, 9);
					String currentNo = policyNoStr + seqNo.substring(0, 2) + seqNo.substring(2, 9);
					System.out.println("当前的单号为：" + currentNo);
					resPolicyNo.setCurrentPolicyNo(currentNo);
					resPolicyNo.setStartPolicyNo(currentNo);

					// 计算结束单号序号，并存储到redis
					int endPolicyNoSeq = Integer.parseInt(resRedisValue) + Integer.parseInt(count);
					jedisCluster.set(key, (endPolicyNoSeq + 1) + "");

					// 拼接结尾单号
					String endPolicyNoStr = StringUtils.autoGenericCode(endPolicyNoSeq + "", 9);
					String endPolicyNo = policyNoStr + endPolicyNoStr.substring(0, 2) + endPolicyNoStr.substring(2, 9);
					System.out.println("结尾单号为：" + endPolicyNo);
					resPolicyNo.setEndPolicyNo(endPolicyNo);
					resPolicyNoList = new ArrayList<ResPolicyNo>();
					resPolicyNoList.add(resPolicyNo);
					String resJson = JsonUtils.obj2Json(resPolicyNoList);
					logger.info("计算后得到的保单号json报文：" + resJson);
					return resJson;

				} else {
					int intCount = Integer.parseInt(count);
					if (intCount > 1) {
						jedisCluster.set(key, (intCount + 1) + "");
					}
					jedisCluster.set(key, "1");
				}
			} else if (type.equals("2")) {// 2为大保险单号

			} else {
				return null;
			}
		}
		return null;
	}
}
