package com.lhwl.wzk.jpa.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "wzk_resource", schema = "wzk_web", catalog = "")
public class WzkResourceEntity {
    private int id;
    private String resourceName;
    private String synopsis;
    private String createName;
    private Timestamp createTime;
    private String specialty;
    private String useType;
    private String mediaType;
    private Integer majorId;
    private String url;
    private String imageUrl;
    private Byte delFlag;

    public WzkResourceEntity() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "resource_name", nullable = true, length = 255)
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Basic
    @Column(name = "synopsis", nullable = true, length = 255)
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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
    @Column(name = "specialty", nullable = true, length = 255)
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Basic
    @Column(name = "use_type", nullable = true, length = 255)
    public String getUseType() {
        return useType;
    }

    public void setUseType(String useType) {
        this.useType = useType;
    }

    @Basic
    @Column(name = "media_type", nullable = true, length = 255)
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    @Basic
    @Column(name = "major_id", nullable = true)
    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
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
        WzkResourceEntity that = (WzkResourceEntity) o;
        return id == that.id &&
                Objects.equals(resourceName, that.resourceName) &&
                Objects.equals(synopsis, that.synopsis) &&
                Objects.equals(createName, that.createName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(specialty, that.specialty) &&
                Objects.equals(useType, that.useType) &&
                Objects.equals(mediaType, that.mediaType) &&
                Objects.equals(majorId, that.majorId) &&
                Objects.equals(url, that.url) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(delFlag, that.delFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resourceName, synopsis, createName, createTime, specialty, useType, mediaType, majorId, url, imageUrl, delFlag);
    }

    public String toString() {
        return "WzkResourceEntity(id=" + this.getId() + ", resourceName=" + this.getResourceName() + ", synopsis=" + this.getSynopsis() + ", createName=" + this.getCreateName() + ", createTime=" + this.getCreateTime() + ", specialty=" + this.getSpecialty() + ", useType=" + this.getUseType() + ", mediaType=" + this.getMediaType() + ", majorId=" + this.getMajorId() + ", url=" + this.getUrl() + ", imageUrl=" + this.getImageUrl() + ", delFlag=" + this.getDelFlag() + ")";
    }
}
