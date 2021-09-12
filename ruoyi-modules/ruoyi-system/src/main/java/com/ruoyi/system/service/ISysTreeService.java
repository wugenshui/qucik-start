package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.SysTree;

/**
 * 测试树列表Service接口
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
public interface ISysTreeService {
    /**
     * 查询测试树列表
     * 
     * @param id 测试树列表ID
     * @return 测试树列表
     */
    public SysTree selectSysTreeById(Long id);

    /**
     * 查询测试树列表列表
     * 
     * @param sysTree 测试树列表
     * @return 测试树列表集合
     */
    public List<SysTree> selectSysTreeList(SysTree sysTree);

    /**
     * 新增测试树列表
     * 
     * @param sysTree 测试树列表
     * @return 结果
     */
    public int insertSysTree(SysTree sysTree);

    /**
     * 修改测试树列表
     * 
     * @param sysTree 测试树列表
     * @return 结果
     */
    public int updateSysTree(SysTree sysTree);

    /**
     * 批量删除测试树列表
     * 
     * @param ids 需要删除的测试树列表ID
     * @return 结果
     */
    public int deleteSysTreeByIds(Long[] ids);

    /**
     * 删除测试树列表信息
     * 
     * @param id 测试树列表ID
     * @return 结果
     */
    public int deleteSysTreeById(Long id);
}
