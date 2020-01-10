package com.zhaoxl.redisdemo.pub.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class Status implements Serializable {
    private static final long serialVersionUID = -2014592760065018707L;

    public static final Status OK = new Status(0, "操作成功");
    public static final Status ERROR = new Status(1, "操作失败");
    public static final Status INTERNAL_ERROR = new Status(1000, "服务器内部错误");
    public static final Status PARAM_MISS = new Status(1001, "缺少参数");
    public static final Status PARAM_ERROR = new Status(1002, "参数格式错误");

    public static final Status DATADUPLICATION = new Status(1003, "数据重复");
    public static final Status PARAM_AMT_ILLEGAL = new Status(1004, "金额无效");
    public static final Status PARAM_VALUE_MISS = new Status(1005, "信息不完整");
    public static final Status WEAK_NET_WORK = new Status(-1, "服务器内部异常");
    public static final Status BAD_REQUEST = new Status(400, "请求无效 (Bad request)");
    public static final Status UNAUTHORIZED = new Status(401, "未授权");
    public static final Status FORBIDDEN = new Status(403, "拒绝访问");
    public static final Status NO_PAGE = new Status(404, "请求的网页不存在");
    public static final Status METHOD_NOT_ALLOWED = new Status(405, "方法不被允许");
    public static final Status INTERNAL_SERVER_ERROR = new Status(500, "服务器遇到错误，无法完成请求");
    public static final Status GATEWAY_TIMEOUT = new Status(504, "网关超时");
    public static final Status DATA_ERROR = new Status(1006, "数据不匹配");
    public static final Status REPETITIVE_OPERATION = new Status(1007, "重复操作");
    public static final Status MAX_MIN_ERROR = new Status(1008, "数据大小不符");
    public static final Status MESSAGE_TEMPLATE_NOT_EXIST = new Status(1009, "短信模板不存在");
    public static final Status MESSAGE_NOT_EXIST = new Status(1010, "没有可发送的短信");
    public static final Status STATUE_ERROR = new Status(1011, "状态错误");
    public static final Status BENEFITCODE_NOT_EXIST = new Status(1012, "受益权编码不存在");
    public static final Status BENEFITNAME_NOT_EXIST = new Status(1013, "受益权名称不存在");
    public static final Status NO_SUITABLE_CUSTOMER = new Status(1014, "没有匹配条件的客户");
    public static final Status TAG_NOT_EXIST = new Status(1015, "没有短信模板标签");
    public static final Status SCHEDULE_TIME_NOT_EXIST = new Status(1016, "时间计划不存在");
    public static final Status CUST_MOBILES_NOT_EXIST = new Status(1017, "客户手机号不存在");
    public static final Status CUST_MANAGER_NOT_EXIST = new Status(1018, "客户经理不存在");
    public static final Status PROD_NO_RECORD = new Status(1019, "产品未备案,没有相关的增益数据");
    public static final Status RATE_LIMIT = new Status(1020, "访问次数受限");
    public static final Status BENEFITCODE_NOT_PLAN = new Status(1021, "受益权编码没有归属计划");
    public static final Status UNKNOWN_ERROR = new Status(-1, "系统繁忙");
    public static final Status VALUE_DIFF = new Status(1015, "备案信息与复核信息有区别，请检查相关信息");
    public static final Status NOT_REGISTER_TA = new Status(1023, "该用户信息为空或未在TA开户");
    public static final Status BENEFITNAME_CHAR_NUMBER = new Status(1024,"产品概要已超出字数限制,标题100字之内,内容2000字之内");
    public static final Status BENEFITREMARK_CHAR_NUMBER = new Status(1025,"备注应限制在200字之内");
    public static final Status DATA_EMPTY = new Status(1026,"数据为空");
    public static final Status CUSTOMER_OVERLOAD = new Status(1027, "匹配的客户超限");


    public Status() {
    }

    public Status(int retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    @XmlElement
    private int retCode;

    @XmlElement
    private String retMsg;

    public int getRetCode() {
        return retCode;
    }

    @JsonProperty("retMsg")
    public String getRetMsg() {
        return retMsg;
    }

}
