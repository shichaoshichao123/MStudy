package com.sc.study;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-12-30 17:03
 * @desc 平台抽奖推送配置信息
 */
@Data
@Accessors(chain = true)
public class NotifyConfig implements Serializable {
    private static final long serialVersionUID = -7660593822226711074L;

    /**
     * 场景选项
     */
    private Integer option;

    /**
     * 场景名称
     */
    private String optionName;

    /**
     * appKey
     */
    private String appKey;

    /**
     * pushCode
     */
    private String pushCode;


    public static void main(String[] args) {
        NotifyConfig notifyConfig = new NotifyConfig();
        notifyConfig
                .setOption(0)
                .setOptionName("开奖时给参与用户的开奖提醒")
                .setAppKey("qwefcavw")
                .setPushCode("111222333444555666");
        NotifyConfig notifyConfig1 = new NotifyConfig();
        notifyConfig1
                .setOption(1)
                .setOptionName("开奖后给中奖者的消息提醒")
                .setAppKey("csavwsavs")
                .setPushCode("1234567890");
        NotifyConfig notifyConfig2 = new NotifyConfig();
        notifyConfig2
                .setOption(2)
                .setOptionName("开奖后给中奖者的短信提醒")
                .setAppKey("csavwsavs")
                .setPushCode("1234567890");
        NotifyConfig notifyConfig3 = new NotifyConfig();
        notifyConfig3
                .setOption(3)
                .setOptionName("通知用户去邀请助力")
                .setAppKey("csavwsavs")
                .setPushCode("1234567890");
        NotifyConfig notifyConfig4 = new NotifyConfig();
        notifyConfig4
                .setOption(4)
                .setOptionName("通知用户邀请助力成功")
                .setAppKey("csavwsavs")
                .setPushCode("1234567890");
        NotifyConfig notifyConfig5 = new NotifyConfig();
        notifyConfig5
                .setOption(5)
                .setOptionName("通知用户邀请用户下单助力成功")
                .setAppKey("csavwsavs")
                .setPushCode("1234567890");
        List<NotifyConfig> notifyConfigList = Arrays.asList(notifyConfig, notifyConfig1, notifyConfig2, notifyConfig3, notifyConfig4, notifyConfig5);
        System.out.println(JSON.toJSONString(notifyConfigList));
    }

}
