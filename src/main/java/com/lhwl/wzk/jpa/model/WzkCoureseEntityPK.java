package com.lhwl.wzk.jpa.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class WzkCoureseEntityPK implements Serializable {

    private int majorId;
    private String courseId;

    @Column(name = "major_id", nullable = false)
    @Id
    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    @Column(name = "course_id", nullable = false, length = 80)
    @Id
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WzkCoureseEntityPK that = (WzkCoureseEntityPK) o;
        return majorId == that.majorId &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(majorId, courseId);
    }
}
