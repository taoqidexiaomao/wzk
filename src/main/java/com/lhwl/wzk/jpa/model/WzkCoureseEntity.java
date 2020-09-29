package com.lhwl.wzk.jpa.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "wzk_courese", schema = "wzk_web", catalog = "")
@IdClass(WzkCoureseEntityPK.class)
public class WzkCoureseEntity {
    private int majorId;
    private String courseName;
    private String schoolName;
    private String createName;
    private Timestamp createTime;
    private Integer applyNum;
    private Long commentNum;
    private Byte type;
    private String url;
    private String imageUrl;
    private String courseId;
    private String specialty;
    private Byte delFlag;

    @Id
    @Column(name = "major_id", nullable = false)
    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    @Basic
    @Column(name = "course_name", nullable = true, length = 255)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "school_name", nullable = true, length = 80)
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Basic
    @Column(name = "create_name", nullable = true, length = 5)
    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "apply_num", nullable = true)
    public Integer getApplyNum() {
        return applyNum;
    }

    public void setApplyNum(Integer applyNum) {
        this.applyNum = applyNum;
    }

    @Basic
    @Column(name = "comment_num", nullable = true)
    public Long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Long commentNum) {
        this.commentNum = commentNum;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "image_url", nullable = true, length = 255)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Id
    @Column(name = "course_id", nullable = false, length = 80)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "specialty", nullable = true, length = 255)
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Basic
    @Column(name = "del_flag", nullable = true)
    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WzkCoureseEntity that = (WzkCoureseEntity) o;
        return majorId == that.majorId &&
                Objects.equals(courseName, that.courseName) &&
                Objects.equals(schoolName, that.schoolName) &&
                Objects.equals(createName, that.createName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(applyNum, that.applyNum) &&
                Objects.equals(commentNum, that.commentNum) &&
                Objects.equals(type, that.type) &&
                Objects.equals(url, that.url) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(courseId, that.courseId) &&
                Objects.equals(specialty, that.specialty) &&
                Objects.equals(delFlag, that.delFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(majorId, courseName, schoolName, createName, createTime, applyNum, commentNum, type, url, imageUrl, courseId, specialty, delFlag);
    }
}
