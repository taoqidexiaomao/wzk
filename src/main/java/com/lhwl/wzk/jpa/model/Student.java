package com.lhwl.wzk.jpa.model;

import lombok.Data;
import lombok.experimental.Accessors;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "student")
@Accessors(chain = true)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "SIdKeyGenerator")
    @GenericGenerator(name = "SIdKeyGenerator", strategy = "uuid")
    @Column(name = "SId", nullable = false)
    private String SId;

    @Column(name = "Sname")
    private String sname;

    @Column(name = "Sage")
    private Date sage;

    @Column(name = "Ssex")
    private String ssex;

    @Basic
    @Column(name = "school_name", nullable = true, length = 80)
    private String schoolName;
    /**
     * 多对一设置
     */
    @ManyToOne
    @JoinColumn(name = "school_name", referencedColumnName = "school_name", insertable = false, updatable = false)
    private WzkCoureseEntity wzkCoureseEntity;
}
