package io.renren.modules.generator.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户身份核对表
 * 
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@Data
@TableName("identity_users")
public class IdentityUsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户身份核对表id
	 */
	@TableId
	private String id;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 问题一
	 */
	private String question1;
	/**
	 * 问题二
	 */
	private String question2;
	/**
	 * 问题三
	 */
	private String question3;
	/**
	 * 答案一
	 */
	private String answer1;
	/**
	 * 答案二
	 */
	private String answer2;
	/**
	 * 答案三
	 */
	private String answer3;

}
