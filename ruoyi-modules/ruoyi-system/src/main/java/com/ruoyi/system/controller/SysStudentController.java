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
import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.service.ISysStudentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 测试学生Controller
 * 
 * @author ruoyi
 * @date 2021-09-12
 */
@RestController
@RequestMapping("/student")
public class SysStudentController extends BaseController {
    @Autowired
    private ISysStudentService sysStudentService;

    /**
     * 查询测试学生列表
     */
    @PreAuthorize(hasPermi = "system:student:list")
    @GetMapping("/list")
    public TableDataInfo list(SysStudent sysStudent) {
        startPage();
        List<SysStudent> list = sysStudentService.selectSysStudentList(sysStudent);
        return getDataTable(list);
    }

    /**
     * 导出测试学生列表
     */
    @PreAuthorize(hasPermi = "system:student:export")
    @Log(title = "测试学生", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysStudent sysStudent) throws IOException {
        List<SysStudent> list = sysStudentService.selectSysStudentList(sysStudent);
        ExcelUtil<SysStudent> util = new ExcelUtil<SysStudent>(SysStudent.class);
        util.exportExcel(response, list, "测试学生数据");
    }

    /**
     * 获取测试学生详细信息
     */
    @PreAuthorize(hasPermi = "system:student:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysStudentService.selectSysStudentById(id));
    }

    /**
     * 新增测试学生
     */
    @PreAuthorize(hasPermi = "system:student:add")
    @Log(title = "测试学生", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysStudent sysStudent) {
        return toAjax(sysStudentService.insertSysStudent(sysStudent));
    }

    /**
     * 修改测试学生
     */
    @PreAuthorize(hasPermi = "system:student:edit")
    @Log(title = "测试学生", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysStudent sysStudent) {
        return toAjax(sysStudentService.updateSysStudent(sysStudent));
    }

    /**
     * 删除测试学生
     */
    @PreAuthorize(hasPermi = "system:student:remove")
    @Log(title = "测试学生", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysStudentService.deleteSysStudentByIds(ids));
    }
}
