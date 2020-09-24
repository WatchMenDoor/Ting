package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;

/**
 * @Auther: liuxw
 * @Date: 2020-09-24
 * @Description: com.ruoyi.project.cms.type.service
 * @version: 1.0
 */
//修改服务公告类型

public interface ICMSTypeEditService {
    CMSType selectTypeById(Long typeId);

    int updateCMSType(CMSType type);
}
