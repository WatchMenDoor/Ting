package com.ruoyi.project.cms.type.mapper;

import com.ruoyi.project.cms.type.domain.CMSType;

/**
 * @Auther: liuxw
 * @Date: 2020-09-24
 * @Description: com.ruoyi.project.cms.type.mapper
 * @version: 1.0
 */
public interface CMSTypeAddMapper {

    CMSType checkTypeNameUnique(String typeName);


    //新增公告类型
    int insertCMSType(CMSType type);
}
