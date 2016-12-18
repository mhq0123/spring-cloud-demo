package com.mhq0123.service.external.config;

import com.alibaba.fastjson.JSONObject;
import com.mhq0123.service.external.config.bean.System;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mhq0123 on 2016/12/18.
 */
@RestController
public class ExternalConfigController {

    private final static Logger logger = LoggerFactory.getLogger(ExternalConfigController.class);

    @Autowired
    private System system;

    @RequestMapping(value = "/system", method = RequestMethod.GET)
    public String system() {
        logger.info(">>>>>>>>>system:{}", JSONObject.toJSONString(system, true));

        return JSONObject.toJSONString(system, true);
    }
}
