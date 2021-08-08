package com.example.multidb.auto.entity;

import java.util.Date;
import lombok.Data;



/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */

/**
 * 用户表
 */
@Data
public class MbUser {
    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 0-无效 1-有效
     */
    private Byte isDelete;
}