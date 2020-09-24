package com.ruoyi.project.cms.type.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.service.ICMSTypeAddService;
import com.ruoyi.project.cms.type.service.ICMSTypeEditService;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: liuxw
 * @Date: 2020-09-23
 * @Description: com.ruoyi.project.cms.type.controller
 * @version: 1.0
 */
@Controller
@RequestMapping(CMSTypeConst.PATH_PREFIX)
public class CMSTypeEditController extends BaseController {

    @Autowired
    private ICMSTypeEditService typeEditService;

    @Autowired
    private ICMSTypeAddService typeAddService;

    //根据主键查询公告类型
    @GetMapping("/edit/{typeId}")
    public String toEdit(@PathVariable("typeId") Long typeId, Model model){
        CMSType type = typeEditService.selectTypeById(typeId);
        model.addAttribute("type", type);
        return CMSTypeConst.PERFIX + "/edit";
    }
    //保存修改后的公告类型
    @RequiresPermissions("cms:type:edit")
    @Log(title = "公告系统管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated CMSType type)
    {
        if (CMSTypeConst.TYPE_NAME_NOT_UNIQUE.equals(typeAddService.checkTypeNameUnique(type)))
        {
            return error("新增公告类型'" + type.getTypeName() + "'失败，公告类型名称已存在");
        }
        else if (CMSTypeConst.TYPE_NAME_NOT_UNIQUE.equals(typeAddService.checkTypeNameUnique(type)))
        {
            return error("新增公告类型'" + type.getTypeName() + "'失败，公告类型名称已存在");
        }
        //新增服务到数据库
        return toAjax(typeEditService.updateCMSType(type));
    }

}
