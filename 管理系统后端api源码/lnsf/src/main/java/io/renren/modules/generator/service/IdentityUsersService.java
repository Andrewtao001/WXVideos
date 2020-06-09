package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.IdentityUsersEntity;

import java.util.Map;

/**
 * 用户身份核对表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
public interface IdentityUsersService extends IService<IdentityUsersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

