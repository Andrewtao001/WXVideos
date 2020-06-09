package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 视频表
 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Data
@TableName("videos")
public class VideosEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 视频表id
	 */
	@TableId
	private String id;
	/**
	 * 发布视频用户id
	 */
	private String userId;
	/**
	 * 音频id
	 */
	private String audioId;
	/**
	 * 用户输入的视频内容
	 */
	private String videoDesc;
	/**
	 * 视频上传路径
	 */
	private String videoPath;
	/**
	 * 视频播放秒数
	 */
	private Float videoSeconds;
	/**
	 * 视频的宽
	 */
	private Integer videoWidth;
	/**
	 * 视频的高
	 */
	private Integer videoHeight;
	/**
	 * 视频封面路径
	 */
	private String coverPath;
	/**
	 * 视频获得喜欢的数量
	 */
	private Long likeCounts;
	/**
	 * 视频状态
	 */
	private Integer status;
	/**
	 * 视频发布日期
	 */
	private Date createTime;

}
