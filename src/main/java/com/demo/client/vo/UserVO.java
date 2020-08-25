package com.demo.client.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 3330414798570536043L;

    /**
     * id
     */
    private Integer id;

    /**
     * 性别 0-未知 1-男 2-女
     */
    private Byte sex;

    /**
     * 中文名称
     */
    private String cnName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 头像地址
     */
    private String portrait;

    /**
     * 出生日期
     */
    private Date birDate;
}
