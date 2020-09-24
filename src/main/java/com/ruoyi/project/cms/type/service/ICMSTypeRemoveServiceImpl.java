package com.ruoyi.project.cms.type.service;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.text.Convert;
import com.ruoyi.project.cms.type.domain.CMSType;
import com.ruoyi.project.cms.type.mapper.CMSTypeEditMapper;
import com.ruoyi.project.cms.type.mapper.CMSTypeRemoveMapper;
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
public class ICMSTypeRemoveServiceImpl implements ICMSTypeRemoveService {
    @Autowired
    private CMSTypeEditMapper editMapper;

    @Autowired
    private CMSTypeRemoveMapper removeMapper;

    @Override
    public int deleteTypeByIds(String ids) {
        Long[] typeIds = Convert.toLongArray(ids);
        return removeMapper.deleteTypeByIds(typeIds);
    }
}
