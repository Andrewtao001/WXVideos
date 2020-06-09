package com.lnsfwx.controller;

import com.lnsfwx.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

	@Autowired
	public RedisOperator redis;
	//redis文件夹的名称
	public static final String USER_REDIS_SESSION = "user_redis_session";
	//ffmpeg所在地址
	public static final String FFMPEG_VIDEOS = "C:\\ffmpeg\\bin\\ffmpeg.exe";
	//public static final String FFMPEG_VIDEOS = "ffmpeg";
	//文件上传地址
	public static final String FILE_DOWNLOAD_PATH = "C:\\lnsf_mod_dev";
	//public static final String FILE_DOWNLOAD_PATH = "/opt/lnsf_mod_dev";
	//每页分页记录数
	public static final Integer PAGE_SIZE = 5;

}
