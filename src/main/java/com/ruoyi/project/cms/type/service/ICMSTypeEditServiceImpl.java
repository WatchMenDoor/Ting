package com.ruoyi.project.cms.type.service;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeEditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuxw
 * @Date: 2020-09-24
 * @Description: com.ruoyi.project.cms.type.service
 * @version: 1.0
 */
@Service
public class ICMSTypeEditServiceImpl implements ICMSTypeEditService {

    @Autowired
    private CMSTypeEditMapper typeEditMapper;


    @Override
    public CMSType selectTypeById(Long typeId) {
        return typeEditMapper.selectTypeById(typeId);
    }

    //更新结果
    @Override
    public int updateCMSType(CMSType type) {
        type.setUpdateBy(ShiroUtils.getLoginName());

        return typeEditMapper.updateType(type);
    }
}
