package com.ruoyi.project.cms.type.mapper;

import com.ruoyi.project.cms.type.domain.CMSType;

import java.util.List;

/**
 * @Auther: liuxw
 * @Date: 2020-09-24
 * @Description: com.ruoyi.project.cms.type.mapper
 * @version: 1.0
 */
public interface CMSTypeMapper {

    /**
     * 查询公告类型数据集合
     * @param type
     * @return
     */
    List<CMSType> selectCMSTypeList(CMSType type);
}
