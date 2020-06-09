package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 背景音乐表
 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Data
@TableName("bgm")
public class BgmEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 背景音乐表的id
	 */
	@TableId
	private String id;
	/**
	 * 配乐的作者
	 */
	private String author;
	/**
	 * 配乐名字
	 */
	private String name;
	/**
	 * 配乐的路径
	 */
	private String path;

}
