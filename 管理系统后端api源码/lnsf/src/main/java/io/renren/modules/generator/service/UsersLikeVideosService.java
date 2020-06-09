package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.UsersLikeVideosEntity;

import java.util.Map;

/**
 * 用户视频关联表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
public interface UsersLikeVideosService extends IService<UsersLikeVideosEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

