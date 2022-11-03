package com.lhwl.wzk.jpa.listener;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
* @author mrli
* @description @EntityListeners(AuditingEntityListener.class):声明实体监听器,用于实体修改时做处理 @MappedSuperclass:
 * 声明该类为实体父类,不会映射单独的表,而是把字段映射到子类表中 @MappedSuperclass:声明该类为实体父类,不会映射单独的表,而是把字段映射到子类表中
* @date 2022/11/2
**/
@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseModel implements Serializable {

    /**
     * 表示该字段为创建人，在这个实体被insert的时候，会自动为其赋值
     */
    @CreatedBy
    @Column(name = "created_by",updatable = false)
    private String createdBy;

    /**
     * 表示该字段为创建时间字段，在这个实体被insert的时候，会自动为其赋值
     */
    @CreatedDate
    @Column(name = "created_time",updatable = false)
    private LocalDateTime createdTime;


}
