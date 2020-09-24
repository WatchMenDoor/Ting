package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.system.post.domain.Post;

import java.util.List;

/**
 * @Auther: liuxw
 * @Date: 2020-09-24
 * @Description: com.ruoyi.project.cms.type.service
 * @version: 1.0
 */
public interface ICMSTypeService {
    /**
     * 查询公告类型-分页查询
     * @param type
     * @return
     */
    public List<CMSType> selectCMSTypeList(CMSType type);
}
