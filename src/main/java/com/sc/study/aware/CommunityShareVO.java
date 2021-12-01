package com.sc.study.aware;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yingqi
 * @version 1.0
 * @date 2020-11-16 10:23
 * @desc 社区分享Vo
 */
@Data
@Accessors(chain = true)
public class CommunityShareVO implements Serializable {
    private static final long serialVersionUID = 1698653454514852037L;

    /**
     * 分享图片
     */
    private String shareImage;

    /**
     * 分享海报图片
     */
    private String shareBigImage;

    /**
     * 分享图片标题
     */
    private String shareTitle;

    /**
     * 分享内容
     */
    private String shareContent;

    /**
     * 分享跳转链接
     */
    private String shareUrl;

    public static void main(String[] args) {
        CommunityShareVO result = new CommunityShareVO();
        result.setShareImage("https://cdn.wanwudezhi.com/static/web-static/image/783b7d49f8438e180d22541bbf643e18_600x480.jpg")
                .setShareBigImage("https://cdn.wanwudezhi.com/static/web-static/image/b2d290d3a77e3d39935ec2ad7e0c0c6d_900x900.jpg")
                .setShareTitle("玩物闲置回血专区")
                .setShareContent("扫码立即来玩物闲置回血吧")
                .setShareUrl("https://m.wanwudezhi.com/page/7592a5e3-18a0-4055-a2e6-5fb620023cdf/1605519414621");
        System.out.println(JSON.toJSONString(result));
    }


}
