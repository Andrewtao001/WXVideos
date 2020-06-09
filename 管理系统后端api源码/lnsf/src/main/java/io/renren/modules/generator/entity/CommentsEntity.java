package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *  用户留言表
 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Data
@TableName("comments")
public class CommentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户留言表id
	 */
	@TableId
	private String id;
	/**
	 * 回复其他用户留言时其他用户留言表的id
	 */
	private String fatherCommentId;
	/**
	 * 留言的用户id
	 */
	private String toUserId;
	/**
	 * 留言的视频id
	 */
	private String videoId;
	/**
	 * 回复其他用户留言时其他用户的用户id
	 */
	private String fromUserId;
	/**
	 * 评论内容
	 */
	private String comment;
	/**
	 * 留言日期
	 */
	private Date createTime;

}
