package com.ruoyi.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.ruoyi.system.domain.SysTree;
import com.ruoyi.system.service.ISysTreeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;

/**
 * 测试树列表Controller
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
@RestController
@RequestMapping("/tree")
public class SysTreeController extends BaseController {
    @Autowired
    private ISysTreeService sysTreeService;

    /**
     * 查询测试树列表列表
     */
    @PreAuthorize(hasPermi = "system:tree:list")
    @GetMapping("/list")
    public AjaxResult list(SysTree sysTree) {
        List<SysTree> list = sysTreeService.selectSysTreeList(sysTree);
        return AjaxResult.success(list);
    }

    /**
     * 导出测试树列表列表
     */
    @PreAuthorize(hasPermi = "system:tree:export")
    @Log(title = "测试树列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTree sysTree) throws IOException {
        List<SysTree> list = sysTreeService.selectSysTreeList(sysTree);
        ExcelUtil<SysTree> util = new ExcelUtil<SysTree>(SysTree.class);
        util.exportExcel(response, list, "测试树列表数据");
    }

    /**
     * 获取测试树列表详细信息
     */
    @PreAuthorize(hasPermi = "system:tree:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysTreeService.selectSysTreeById(id));
    }

    /**
     * 新增测试树列表
     */
    @PreAuthorize(hasPermi = "system:tree:add")
    @Log(title = "测试树列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTree sysTree) {
        return toAjax(sysTreeService.insertSysTree(sysTree));
    }

    /**
     * 修改测试树列表
     */
    @PreAuthorize(hasPermi = "system:tree:edit")
    @Log(title = "测试树列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTree sysTree) {
        return toAjax(sysTreeService.updateSysTree(sysTree));
    }

    /**
     * 删除测试树列表
     */
    @PreAuthorize(hasPermi = "system:tree:remove")
    @Log(title = "测试树列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysTreeService.deleteSysTreeByIds(ids));
    }
}
