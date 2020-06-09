package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.generator.entity.UsersReportEntity;

import java.util.Map;

/**
 * 用户举报表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
public interface UsersReportService extends IService<UsersReportEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

