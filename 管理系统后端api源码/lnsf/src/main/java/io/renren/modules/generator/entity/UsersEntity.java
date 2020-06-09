package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表

 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Data
@TableName("users")
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@TableId
	private String id;
	/**
	 * 用户账号
	 */
	private String username;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 用户头像
	 */
	private String faceImage;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 粉丝人数
	 */
	private Integer fansCounts;
	/**
	 * 关注人数
	 */
	private Integer followCounts;
	/**
	 * 用户状态
	 */
	private Integer userStatus;
	/**
	 * 用户接受到的赞美的数量
	 */
	private Integer receiveLikeCounts;
	/**
	 * 用户隐私
	 */
	private Integer userHidden;
	/**
	 * 学生证照片
	 */
	private String userFaces;

}
