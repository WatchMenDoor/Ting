package com.ruoyi.project.cms.type.controller;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.service.ICMSTypeAddService;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.ruoyi.framework.web.domain.AjaxResult.error;

/**
 * 新增公告
 * @Auther: liuxw
 * @Date: 2020-09-23
 * @Description: com.ruoyi.project.cms.type.controller
 * @version: 1.0
 */
@Controller
@RequestMapping(CMSTypeConst.PATH_PREFIX)
public class CMSTypeAddController extends BaseController {

    @Autowired
    private ICMSTypeAddService typeAddService;

    /*
     * 新增公告类型到数据库，有权限才可以
     * */
    @RequiresPermissions("cms:type:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@Validated CMSType type){
        if (CMSTypeConst.TYPE_NAME_NOT_UNIQUE.equals(typeAddService.checkTypeNameUnique(type)))
        {
            return error("新增公告类型'" + type.getTypeName() + "'失败，公告类型名称已存在");
        }
        else if (CMSTypeConst.TYPE_NAME_NOT_UNIQUE.equals(typeAddService.checkTypeNameUnique(type)))
        {
            return error("新增公告类型'" + type.getTypeName() + "'失败，公告类型名称已存在");
        }
        //新增服务到数据库
        return toAjax(typeAddService.addCMSType(type));
    }
    /*
    * 新增公告类型页面调转
    * */
    @GetMapping("/add")
    public String add(){
        return CMSTypeConst.PERFIX+ "/add";
    }

    /**
     * 检查公告类型是否唯一
     * @param
     * @return
     */
    @PostMapping("/checkTypeNameUnique")
    @ResponseBody
    public String checkTypeNameUnique(CMSType type)
    {
        return typeAddService.checkTypeNameUnique(type);
    }
}
