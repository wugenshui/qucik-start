package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 测试学生对象 sys_student
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
public class SysStudent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String name;

    /** 班级id */
    @Excel(name = "班级id")
    private Long classId;

    /** 学生手机号 */
    @Excel(name = "学生手机号")
    private String phone;

    /**
     * 测试班级管理信息
     */
    private List<SysClass> sysClassList;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getClassId() {
        return classId;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public List<SysClass> getSysClassList()
    {
        return sysClassList;
    }

    public void setSysClassList(List<SysClass> sysClassList)
    {
        this.sysClassList = sysClassList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("classId", getClassId())
            .append("phone", getPhone())
            .append("sysClassList", getSysClassList())
            .toString();
    }
}
