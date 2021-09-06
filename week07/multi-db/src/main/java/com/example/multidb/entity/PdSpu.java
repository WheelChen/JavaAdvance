package com.example.multidb.entity;

import java.util.Date;
import lombok.Data;



/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:40
 */

/**
 * 商品spu表
 */
@Data
public class PdSpu {
    private Integer id;

    private Long spuId;

    /**
     * 商品名
     */
    private String name;

    /**
     * 商品图片地址
     */
    private String pictureUrl;

    /**
     * 商品描述
     */
    private String description;

    /**
     * spu最新快照码
     */
    private String spuSnapCode;

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