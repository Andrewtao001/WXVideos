package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.VideosEntity;

import java.util.Map;

/**
 * 视频表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
public interface VideosService extends IService<VideosEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

