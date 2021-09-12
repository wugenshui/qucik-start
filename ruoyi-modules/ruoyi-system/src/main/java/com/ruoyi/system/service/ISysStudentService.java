package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.SysStudent;

/**
 * 测试学生Service接口
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
public interface ISysStudentService {
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
     * 批量删除测试学生
     * 
     * @param ids 需要删除的测试学生ID
     * @return 结果
     */
    public int deleteSysStudentByIds(Long[] ids);

    /**
     * 删除测试学生信息
     * 
     * @param id 测试学生ID
     * @return 结果
     */
    public int deleteSysStudentById(Long id);
}
