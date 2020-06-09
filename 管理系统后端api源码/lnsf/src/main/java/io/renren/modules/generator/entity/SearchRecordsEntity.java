package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 热搜表
 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Data
@TableName("search_records")
public class SearchRecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 热搜表的id
	 */
	@TableId
	private String id;
	/**
	 * 热搜的内容
	 */
	private String content;

}
