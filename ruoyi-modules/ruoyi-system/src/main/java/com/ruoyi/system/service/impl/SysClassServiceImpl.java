package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysClassMapper;
import com.ruoyi.system.domain.SysClass;
import com.ruoyi.system.service.ISysClassService;

/**
 * 测试班级管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
@Service
public class SysClassServiceImpl implements ISysClassService {
    @Autowired
    private SysClassMapper sysClassMapper;

    /**
     * 查询测试班级管理
     * 
     * @param id 测试班级管理ID
     * @return 测试班级管理
     */
    @Override
    public SysClass selectSysClassById(Long id) {
        return sysClassMapper.selectSysClassById(id);
    }

    /**
     * 查询测试班级管理列表
     * 
     * @param sysClass 测试班级管理
     * @return 测试班级管理
     */
    @Override
    public List<SysClass> selectSysClassList(SysClass sysClass) {
        return sysClassMapper.selectSysClassList(sysClass);
    }

    /**
     * 新增测试班级管理
     * 
     * @param sysClass 测试班级管理
     * @return 结果
     */
    @Override
    public int insertSysClass(SysClass sysClass) {
        return sysClassMapper.insertSysClass(sysClass);
    }

    /**
     * 修改测试班级管理
     * 
     * @param sysClass 测试班级管理
     * @return 结果
     */
    @Override
    public int updateSysClass(SysClass sysClass) {
        return sysClassMapper.updateSysClass(sysClass);
    }

    /**
     * 批量删除测试班级管理
     * 
     * @param ids 需要删除的测试班级管理ID
     * @return 结果
     */
    @Override
    public int deleteSysClassByIds(Long[] ids) {
        return sysClassMapper.deleteSysClassByIds(ids);
    }

    /**
     * 删除测试班级管理信息
     * 
     * @param id 测试班级管理ID
     * @return 结果
     */
    @Override
    public int deleteSysClassById(Long id) {
        return sysClassMapper.deleteSysClassById(id);
    }
}
