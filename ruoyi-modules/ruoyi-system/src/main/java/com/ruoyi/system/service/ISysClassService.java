package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.SysClass;

/**
 * 测试班级管理Service接口
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
public interface ISysClassService {
    /**
     * 查询测试班级管理
     * 
     * @param id 测试班级管理ID
     * @return 测试班级管理
     */
    public SysClass selectSysClassById(Long id);

    /**
     * 查询测试班级管理列表
     * 
     * @param sysClass 测试班级管理
     * @return 测试班级管理集合
     */
    public List<SysClass> selectSysClassList(SysClass sysClass);

    /**
     * 新增测试班级管理
     * 
     * @param sysClass 测试班级管理
     * @return 结果
     */
    public int insertSysClass(SysClass sysClass);

    /**
     * 修改测试班级管理
     * 
     * @param sysClass 测试班级管理
     * @return 结果
     */
    public int updateSysClass(SysClass sysClass);

    /**
     * 批量删除测试班级管理
     * 
     * @param ids 需要删除的测试班级管理ID
     * @return 结果
     */
    public int deleteSysClassByIds(Long[] ids);

    /**
     * 删除测试班级管理信息
     * 
     * @param id 测试班级管理ID
     * @return 结果
     */
    public int deleteSysClassById(Long id);
}
