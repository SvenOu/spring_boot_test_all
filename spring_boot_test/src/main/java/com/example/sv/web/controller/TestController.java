/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sv.web.controller;

import com.example.sv.MySpringBootApplication;
import com.example.sv.configs.XmlBean;
import com.example.sv.mobile.service.impl.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(MySpringBootApplication.class);

    @Autowired
    private TestService testService;

    @Autowired
    @Qualifier("xmlBean2")
    private XmlBean xmlBean2;

    @Autowired
    @Qualifier("xmlBean")
    private XmlBean xmlBean;

    /**
     * use by {@link com.example.sv.configs.DefaultView}
     */
    @RequestMapping("/sommeBean")
    public String home() {
        return testService.getTestMessage();
    }

    @RequestMapping("/xmlBean1")
    public String xmlBean1() {
        logger.info("MySpringBootApplication start !");
        return xmlBean.getName() + "-----------" + xmlBean2.getName();
    }

}
