package com.hisrun.number.ctrl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hisrun.number.service.PoliyNoService;
import com.hisrun.redis.redisconfig.RedisClusterConfig;
import com.hisrun.utils.JsonUtils;
import com.hisrun.vo.PolicyNo;

@RestController
@Scope(value = ConfigurableListableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PolicyNoCtrl {

	private Logger logger = Logger.getLogger(PolicyNoCtrl.class);

	@Autowired
	private PoliyNoService poliyNoService;
	@Autowired
	private RedisClusterConfig redisClusterConfig;

	@RequestMapping(value = "/obtain1PolicyNo", method = RequestMethod.GET)
	public String obtain1PolicyNo() {
		// public String obtain1PolicyNo(HttpServletRequest request) {

		logger.info(redisClusterConfig);
		logger.info("获取保单号开始：");
		try {
			// BufferedReader reader = null;
			// StringWriter writer = null;
			// reader = request.getReader();
			// writer = new StringWriter();
			// char[] buffer = new char[1024];
			// int l;
			// while ((l = reader.read(buffer, 0, buffer.length)) > 0) {
			// writer.write(buffer, 0, l);
			// }

			PolicyNo policyNo = new PolicyNo();
			policyNo.setComCode("110000");
			policyNo.setCount("1");
			policyNo.setPolicyNo_1("3");
			policyNo.setRiskCode("2735");
			policyNo.setType("1");
			policyNo.setYear("2018");

			String reqJson = JsonUtils.obj2Json(policyNo);
			// String reqJson = writer.toString();
			logger.info("获取到的请求报文为：" + reqJson);
			String resJson = poliyNoService.policyNoList(reqJson);
			logger.info("获取到的返回报文为：" + resJson);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return "";
	}
}
