package com.lhwl.wzk.mybatis.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author mrli
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WzkResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源名称
     */
    private String resourceName;

    /**
     * 简介
     */
    private String synopsis;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 所属专业
     */
    private String specialty;

    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 应用类型
     */
    private String useType;

    /**
     * 媒体类型
     */
    private String mediaType;

    /**
     * 专业id
     */
    private Integer majorId;

    /**
     * 跳转路劲
     */
    private String url;

    /**
     * 图片路径
     */
    private String imageUrl;

    /**
     * 删除标识
     */
    private Boolean delFlag;


}
