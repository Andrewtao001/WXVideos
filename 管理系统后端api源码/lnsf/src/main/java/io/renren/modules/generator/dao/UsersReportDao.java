package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.UsersReportEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户举报表
 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Mapper
public interface UsersReportDao extends BaseMapper<UsersReportEntity> {
	
}
