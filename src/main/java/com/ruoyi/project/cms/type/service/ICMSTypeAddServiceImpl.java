package com.ruoyi.project.cms.type.service;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.cms.type.commons.CMSTypeConst;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeAddMapper;
import com.ruoyi.project.system.post.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuxw
 * @Date: 2020-09-24
 * @Description: com.ruoyi.project.cms.type.service
 * @version: 1.0
 */
@Service
public class ICMSTypeAddServiceImpl implements ICMSTypeAddService{

    @Autowired
    private CMSTypeAddMapper typeMapper;
    @Override
    public String checkTypeNameUnique(CMSType type) {
        //可能是在修改也可能是在新增公告类型
        Long typeId = StringUtils.isNull(type.getTypeId()) ? -1L : type.getTypeId();
        CMSType info = typeMapper.checkTypeNameUnique(type.getTypeName());
        if (StringUtils.isNotNull(info) && info.getTypeId().longValue() != typeId.longValue())
        {
            return CMSTypeConst.TYPE_NAME_NOT_UNIQUE;
        }
        return CMSTypeConst.TYPE_NAME_UNIQUE;
    }

    @Override
    public int addCMSType(CMSType type) {
        type.setCreateBy(ShiroUtils.getLoginName());
        return typeMapper.insertCMSType(type);
    }
}
