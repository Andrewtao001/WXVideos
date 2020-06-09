package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.UsersFansEntity;

import java.util.Map;

/**
 * 用户粉丝表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
public interface UsersFansService extends IService<UsersFansEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

