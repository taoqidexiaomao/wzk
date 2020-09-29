package com.lhwl.wzk.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mrli
 * @since 2020-08-25
 */
@Accessors(chain = true)
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("CId")
    private String CId;

    @TableField("Cname")
    private String Cname;

    @TableField("TId")
    private String TId;

    public Course() {
    }


    public String getCId() {
        return this.CId;
    }

    public String getCname() {
        return this.Cname;
    }

    public String getTId() {
        return this.TId;
    }

    public Course setCId(String CId) {
        this.CId = CId;
        return this;
    }

    public Course setCname(String Cname) {
        this.Cname = Cname;
        return this;
    }

    public Course setTId(String TId) {
        this.TId = TId;
        return this;
    }

    public String toString() {
        return "Course(CId=" + this.getCId() + ", Cname=" + this.getCname() + ", TId=" + this.getTId() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Course)) return false;
        final Course other = (Course) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$CId = this.getCId();
        final Object other$CId = other.getCId();
        if (this$CId == null ? other$CId != null : !this$CId.equals(other$CId)) return false;
        final Object this$Cname = this.getCname();
        final Object other$Cname = other.getCname();
        if (this$Cname == null ? other$Cname != null : !this$Cname.equals(other$Cname)) return false;
        final Object this$TId = this.getTId();
        final Object other$TId = other.getTId();
        if (this$TId == null ? other$TId != null : !this$TId.equals(other$TId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Course;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $CId = this.getCId();
        result = result * PRIME + ($CId == null ? 43 : $CId.hashCode());
        final Object $Cname = this.getCname();
        result = result * PRIME + ($Cname == null ? 43 : $Cname.hashCode());
        final Object $TId = this.getTId();
        result = result * PRIME + ($TId == null ? 43 : $TId.hashCode());
        return result;
    }
}
