package com.ruoyi.project.cms.type.service;

import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: liuxw
 * @Date: 2020-09-24
 * @Description: com.ruoyi.project.cms.type.service
 * @version: 1.0
 */
@Service
public class ICMSTypeServiceImpl implements ICMSTypeService {

    @Autowired
    private CMSTypeMapper typeMapper;
    @Override
    public List<CMSType> selectCMSTypeList(CMSType type) {
        return typeMapper.selectCMSTypeList(type);
    }
}
