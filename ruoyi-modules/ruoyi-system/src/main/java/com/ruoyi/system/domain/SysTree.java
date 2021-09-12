package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.TreeEntity;

/**
 * 测试树列表对象 sys_tree
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
public class SysTree extends TreeEntity {
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 节点名称 */
    @Excel(name = "节点名称")
    private String name;

    /** 父id */
    @Excel(name = "父id")
    private Long pid;

    /** 机构管理员 */
    @Excel(name = "机构管理员")
    private String master;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private String sex;

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
    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getPid() {
        return pid;
    }
    public void setMaster(String master) {
        this.master = master;
    }

    public String getMaster() {
        return master;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("pid", getPid())
            .append("master", getMaster())
            .append("sex", getSex())
            .toString();
    }
}
