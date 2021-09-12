package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.domain.SysClass;

/**
 * 测试学生Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
public interface SysStudentMapper {
    /**
     * 查询测试学生
     * 
     * @param id 测试学生ID
     * @return 测试学生
     */
    public SysStudent selectSysStudentById(Long id);

    /**
     * 查询测试学生列表
     * 
     * @param sysStudent 测试学生
     * @return 测试学生集合
     */
    public List<SysStudent> selectSysStudentList(SysStudent sysStudent);

    /**
     * 新增测试学生
     * 
     * @param sysStudent 测试学生
     * @return 结果
     */
    public int insertSysStudent(SysStudent sysStudent);

    /**
     * 修改测试学生
     * 
     * @param sysStudent 测试学生
     * @return 结果
     */
    public int updateSysStudent(SysStudent sysStudent);

    /**
     * 删除测试学生
     * 
     * @param id 测试学生ID
     * @return 结果
     */
    public int deleteSysStudentById(Long id);

    /**
     * 批量删除测试学生
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysStudentByIds(Long[] ids);

    /**
     * 批量删除测试班级管理
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysClassByIds(Long[] ids);
    
    /**
     * 批量新增测试班级管理
     * 
     * @param sysClassList 测试班级管理列表
     * @return 结果
     */
    public int batchSysClass(List<SysClass> sysClassList);
    

    /**
     * 通过测试学生ID删除测试班级管理信息
     * 
     * @param id 测试学生ID
     * @return 结果
     */
    public int deleteSysClassById(Long id);
}
