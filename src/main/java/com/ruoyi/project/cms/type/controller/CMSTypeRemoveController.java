package com.ruoyi.project.cms.type.controller;

import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.service.ICMSTypeRemoveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: liuxw
 * @Date: 2020-09-23
 * @Description: com.ruoyi.project.cms.type.controller
 * @version: 1.0
 */
@Controller
@RequestMapping(CMSTypeConst.PATH_PREFIX)
public class CMSTypeRemoveController extends BaseController {

    @Autowired
    private ICMSTypeRemoveService removeService;

    @RequiresPermissions("cms:type:remove")
    @Log(title = "公告系统管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(removeService.deleteTypeByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
