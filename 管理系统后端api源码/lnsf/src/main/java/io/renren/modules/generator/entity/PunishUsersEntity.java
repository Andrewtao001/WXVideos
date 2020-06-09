package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户封禁表
 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Data
@TableName("punish_users")
public class PunishUsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户封禁表id
	 */
	@TableId
	private String id;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 封禁天数
	 */
	private Integer violation;
	/**
	 * 封禁开始时间
	 */
	private Date startTime;

}
