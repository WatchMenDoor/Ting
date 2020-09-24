package com.ruoyi.project.cms.type.controller;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.service.ICMSTypeService;
import com.ruoyi.project.system.post.domain.Post;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liuxw
 * @Date: 2020-09-23
 * @Description: com.ruoyi.project.cms.type.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("/cms/type")
public class CMSTypeController extends BaseController {

    @Autowired
    private ICMSTypeService typeService;




    @RequiresPermissions("cms:type:view")
    @GetMapping
    public String view(){

        return CMSTypeConst.PERFIX +"/type";

    }
    @RequiresPermissions("cms:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CMSType type){
        //分页处理
        startPage();
        //通过服务代码，mapper调用
        List<CMSType> list = typeService.selectCMSTypeList(type);
        return getDataTable(list);

    }
}
