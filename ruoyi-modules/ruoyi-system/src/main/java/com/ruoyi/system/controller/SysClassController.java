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
import com.ruoyi.system.domain.SysClass;
import com.ruoyi.system.service.ISysClassService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 测试班级管理Controller
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
@RestController
@RequestMapping("/class")
public class SysClassController extends BaseController {
    @Autowired
    private ISysClassService sysClassService;

    /**
     * 查询测试班级管理列表
     */
    @PreAuthorize(hasPermi = "system:class:list")
    @GetMapping("/list")
    public TableDataInfo list(SysClass sysClass) {
        startPage();
        List<SysClass> list = sysClassService.selectSysClassList(sysClass);
        return getDataTable(list);
    }

    /**
     * 导出测试班级管理列表
     */
    @PreAuthorize(hasPermi = "system:class:export")
    @Log(title = "测试班级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysClass sysClass) throws IOException {
        List<SysClass> list = sysClassService.selectSysClassList(sysClass);
        ExcelUtil<SysClass> util = new ExcelUtil<SysClass>(SysClass.class);
        util.exportExcel(response, list, "测试班级管理数据");
    }

    /**
     * 获取测试班级管理详细信息
     */
    @PreAuthorize(hasPermi = "system:class:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysClassService.selectSysClassById(id));
    }

    /**
     * 新增测试班级管理
     */
    @PreAuthorize(hasPermi = "system:class:add")
    @Log(title = "测试班级管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysClass sysClass) {
        return toAjax(sysClassService.insertSysClass(sysClass));
    }

    /**
     * 修改测试班级管理
     */
    @PreAuthorize(hasPermi = "system:class:edit")
    @Log(title = "测试班级管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysClass sysClass) {
        return toAjax(sysClassService.updateSysClass(sysClass));
    }

    /**
     * 删除测试班级管理
     */
    @PreAuthorize(hasPermi = "system:class:remove")
    @Log(title = "测试班级管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysClassService.deleteSysClassByIds(ids));
    }
}
