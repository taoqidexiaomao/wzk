package com.lhwl.wzk.jpa.model;

import com.lhwl.wzk.jpa.listener.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.One;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "wzk_courese", schema = "wzk_web", catalog = "")
@EntityListeners(AuditingEntityListener.class)
//防止n+1sql @NamedEntityGraph
@NamedEntityGraph(name = "wzkCoureseEntity.Graph", attributeNodes = {@NamedAttributeNode("students")})
public class WzkCoureseEntity extends BaseModel {
    @Id
    @Column(name = "major_id", nullable = false)
    @GeneratedValue(generator = "majorKeyGenerator")
    @GenericGenerator(name = "majorKeyGenerator", strategy = "identity")
    private int majorId;
    @Basic
    @Column(name = "course_name", nullable = true, length = 255)
    private String courseName;
    @Basic
    @Column(name = "school_name", nullable = true, length = 80)
    private String schoolName;
    /**
     * 一对多设置
     */
    @OneToMany(targetEntity = Student.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_name",referencedColumnName = "school_name")
    private Set<Student> students = new HashSet<>();
}
