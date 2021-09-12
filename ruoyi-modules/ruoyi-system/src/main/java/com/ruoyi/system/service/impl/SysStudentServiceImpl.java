package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.core.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.SysClass;
import com.ruoyi.system.mapper.SysStudentMapper;
import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.service.ISysStudentService;

/**
 * 测试学生Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
@Service
public class SysStudentServiceImpl implements ISysStudentService {
    @Autowired
    private SysStudentMapper sysStudentMapper;

    /**
     * 查询测试学生
     * 
     * @param id 测试学生ID
     * @return 测试学生
     */
    @Override
    public SysStudent selectSysStudentById(Long id) {
        return sysStudentMapper.selectSysStudentById(id);
    }

    /**
     * 查询测试学生列表
     * 
     * @param sysStudent 测试学生
     * @return 测试学生
     */
    @Override
    public List<SysStudent> selectSysStudentList(SysStudent sysStudent) {
        return sysStudentMapper.selectSysStudentList(sysStudent);
    }

    /**
     * 新增测试学生
     * 
     * @param sysStudent 测试学生
     * @return 结果
     */
    @Transactional
    @Override
    public int insertSysStudent(SysStudent sysStudent) {
        int rows = sysStudentMapper.insertSysStudent(sysStudent);
        insertSysClass(sysStudent);
        return rows;
    }

    /**
     * 修改测试学生
     * 
     * @param sysStudent 测试学生
     * @return 结果
     */
    @Transactional
    @Override
    public int updateSysStudent(SysStudent sysStudent) {
        sysStudentMapper.deleteSysClassById(sysStudent.getId());
        insertSysClass(sysStudent);
        return sysStudentMapper.updateSysStudent(sysStudent);
    }

    /**
     * 批量删除测试学生
     * 
     * @param ids 需要删除的测试学生ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteSysStudentByIds(Long[] ids) {
        sysStudentMapper.deleteSysClassByIds(ids);
        return sysStudentMapper.deleteSysStudentByIds(ids);
    }

    /**
     * 删除测试学生信息
     * 
     * @param id 测试学生ID
     * @return 结果
     */
    @Override
    public int deleteSysStudentById(Long id) {
        sysStudentMapper.deleteSysClassById(id);
        return sysStudentMapper.deleteSysStudentById(id);
    }

    /**
     * 新增测试班级管理信息
     * 
     * @param sysStudent 测试学生对象
     */
    public void insertSysClass(SysStudent sysStudent) {
        List<SysClass> sysClassList = sysStudent.getSysClassList();
        Long id = sysStudent.getId();
        if (StringUtils.isNotNull(sysClassList))
        {
            List<SysClass> list = new ArrayList<SysClass>();
            for (SysClass sysClass : sysClassList)
            {
                sysClass.setId(id);
                list.add(sysClass);
            }
            if (list.size() > 0)
            {
                sysStudentMapper.batchSysClass(list);
            }
        }
    }
}
