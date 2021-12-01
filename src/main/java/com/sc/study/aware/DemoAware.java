package com.sc.study.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-09-26 11:02
 * @desc
 */
@Component
public class DemoAware implements BeanNameAware {

//    @Autowired
//    private RtStatisticsUtil rtStatistizxcsUtil;
    @Override
    public void setBeanName(String name) {

//        System.out.println(rtStatisticsUtil);
        System.out.println("beanName:" + name);

    }
}
