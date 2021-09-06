package com.example.multidb.auto.entity;

import lombok.Data;


/**
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:40
 */
@Data
public class MbAddress {
    private Integer id;

    /**
     * 地址id
     */
    private Long addressId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 国家名称
     */
    private String countryName;

    /**
     * 国家简码
     */
    private Integer countryCode;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 省编码
     */
    private Integer provinceCode;

    /**
     * 市名称
     */
    private String cityName;

    /**
     * 市编码
     */
    private Integer cityCode;

    /**
     * 详细地址
     */
    private String detailAdress;
}