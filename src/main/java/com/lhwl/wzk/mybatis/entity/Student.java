package com.lhwl.wzk.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SId", type = IdType.AUTO)
    private Integer SId;

    @TableField("Sname")
    private String Sname;

    @TableField("Sage")
    private Integer Sage;

    @TableField("Ssex")
    private String Ssex;

    public Student() {
    }


    public Integer getSId() {
        return this.SId;
    }

    public String getSname() {
        return this.Sname;
    }

    public Integer getSage() {
        return this.Sage;
    }

    public String getSsex() {
        return this.Ssex;
    }

    public Student setSId(Integer SId) {
        this.SId = SId;
        return this;
    }

    public Student setSname(String Sname) {
        this.Sname = Sname;
        return this;
    }

    public Student setSage(Integer Sage) {
        this.Sage = Sage;
        return this;
    }

    public Student setSsex(String Ssex) {
        this.Ssex = Ssex;
        return this;
    }

    public String toString() {
        return "Student(SId=" + this.getSId() + ", Sname=" + this.getSname() + ", Sage=" + this.getSage() + ", Ssex=" + this.getSsex() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        final Student other = (Student) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$SId = this.getSId();
        final Object other$SId = other.getSId();
        if (this$SId == null ? other$SId != null : !this$SId.equals(other$SId)) return false;
        final Object this$Sname = this.getSname();
        final Object other$Sname = other.getSname();
        if (this$Sname == null ? other$Sname != null : !this$Sname.equals(other$Sname)) return false;
        final Object this$Sage = this.getSage();
        final Object other$Sage = other.getSage();
        if (this$Sage == null ? other$Sage != null : !this$Sage.equals(other$Sage)) return false;
        final Object this$Ssex = this.getSsex();
        final Object other$Ssex = other.getSsex();
        if (this$Ssex == null ? other$Ssex != null : !this$Ssex.equals(other$Ssex)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Student;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $SId = this.getSId();
        result = result * PRIME + ($SId == null ? 43 : $SId.hashCode());
        final Object $Sname = this.getSname();
        result = result * PRIME + ($Sname == null ? 43 : $Sname.hashCode());
        final Object $Sage = this.getSage();
        result = result * PRIME + ($Sage == null ? 43 : $Sage.hashCode());
        final Object $Ssex = this.getSsex();
        result = result * PRIME + ($Ssex == null ? 43 : $Ssex.hashCode());
        return result;
    }
}
