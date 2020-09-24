package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.system.post.domain.Post;

/**
 * @Auther: liuxw
 * @Date: 2020-09-24
 * @Description: com.ruoyi.project.cms.type.service
 * @version: 1.0
 *
 * 处理新增
 */
public interface ICMSTypeAddService {
    String checkTypeNameUnique(CMSType type);

    /*新增公告类型到数据库*/
    int addCMSType(CMSType type);
}
