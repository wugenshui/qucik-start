package com.ruoyi.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTreeMapper;
import com.ruoyi.system.domain.SysTree;
import com.ruoyi.system.service.ISysTreeService;

/**
 * 测试树列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
@Service
public class SysTreeServiceImpl implements ISysTreeService {
    @Autowired
    private SysTreeMapper sysTreeMapper;

    /**
     * 查询测试树列表
     * 
     * @param id 测试树列表ID
     * @return 测试树列表
     */
    @Override
    public SysTree selectSysTreeById(Long id) {
        return sysTreeMapper.selectSysTreeById(id);
    }

    /**
     * 查询测试树列表列表
     * 
     * @param sysTree 测试树列表
     * @return 测试树列表
     */
    @Override
    public List<SysTree> selectSysTreeList(SysTree sysTree) {
        return sysTreeMapper.selectSysTreeList(sysTree);
    }

    /**
     * 新增测试树列表
     * 
     * @param sysTree 测试树列表
     * @return 结果
     */
    @Override
    public int insertSysTree(SysTree sysTree) {
        return sysTreeMapper.insertSysTree(sysTree);
    }

    /**
     * 修改测试树列表
     * 
     * @param sysTree 测试树列表
     * @return 结果
     */
    @Override
    public int updateSysTree(SysTree sysTree) {
        return sysTreeMapper.updateSysTree(sysTree);
    }

    /**
     * 批量删除测试树列表
     * 
     * @param ids 需要删除的测试树列表ID
     * @return 结果
     */
    @Override
    public int deleteSysTreeByIds(Long[] ids) {
        return sysTreeMapper.deleteSysTreeByIds(ids);
    }

    /**
     * 删除测试树列表信息
     * 
     * @param id 测试树列表ID
     * @return 结果
     */
    @Override
    public int deleteSysTreeById(Long id) {
        return sysTreeMapper.deleteSysTreeById(id);
    }
}
