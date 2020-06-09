package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户举报表
 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Data
@TableName("users_report")
public class UsersReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户举报表id
	 */
	@TableId
	private String id;
	/**
	 * 被举报的用户id
	 */
	private String dealUserId;
	/**
	 * 被举报的视频id
	 */
	private String dealVideoId;
	/**
	 * 举报标题
	 */
	private String title;
	/**
	 * 举报内容
	 */
	private String content;
	/**
	 * 举报者的id
	 */
	private String userid;
	/**
	 * 举报日期
	 */
	private Date createDate;

}
