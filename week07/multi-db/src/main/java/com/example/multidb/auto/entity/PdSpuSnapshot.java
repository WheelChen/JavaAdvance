package com.example.multidb.auto.entity;

import java.util.Date;
import lombok.Data;



/**
 *
 * @author Kelvin Chen
 * @date 2021-08-08 23:56:41
 */

/**
 * 商品spu快照表
 */
@Data
public class PdSpuSnapshot {
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
     * spu快照码
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