package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 测试班级管理对象 sys_class
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
public class SysClass extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 班级名称 */
    @Excel(name = "班级名称")
    private String name;

    /** 班主任 */
    @Excel(name = "班主任")
    private String master;

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
    public void setMaster(String master) {
        this.master = master;
    }

    public String getMaster() {
        return master;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("master", getMaster())
            .toString();
    }
}
