package com.lnsfwx.controller;
import com.lnsfwx.pojo.Bgm;
import com.lnsfwx.pojo.Comments;
import com.lnsfwx.pojo.Users;
import com.lnsfwx.pojo.Videos;
import com.lnsfwx.service.BgmService;
import com.lnsfwx.service.UsersService;
import com.lnsfwx.service.VideosService;
import com.lnsfwx.utils.*;
import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import io.swagger.annotations.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "用户上传video有关业务的接口",tags ={"用户上传video业务controller"} )
@RequestMapping("/userVideo")
public class UserVideoController extends BasicController{

	@Autowired
	private VideosService videosService;
	@Autowired
	private UsersService usersService;

	@Autowired
	private BgmService bgmService;

	@ApiOperation(value = "用户上传视频",notes = "用户上传视频的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name="userId",value = "用户的id",required =true,dataType = "String",paramType = "form"),
			@ApiImplicitParam(name="bgmId",value = "配乐的id",required =false,dataType = "String",paramType = "form"),
			@ApiImplicitParam(name="videoSeconds",value = "视频时长",required =true,dataType = "double",paramType = "form"),
			@ApiImplicitParam(name="videoWidth",value = "视频宽度",required =true,dataType = "int",paramType = "form"),
			@ApiImplicitParam(name="videoHeight",value = "视频高度",required =true,dataType = "int",paramType = "form"),
			@ApiImplicitParam(name="desc",value = "视频描述",required =false,dataType = "String",paramType = "form")
	})
	@PostMapping(value = "/upLoadVideos",headers = "content-type=multipart/form-data")
	public LnsfwxJSONResult upLoadVideos(String userId,String bgmId,double videoSeconds ,int videoWidth,int videoHeight,String desc, @ApiParam(value = "视频",required =true ) MultipartFile video) throws Exception {
		if(StringUtils.isBlank(userId)){
			return LnsfwxJSONResult.errorMsg("用户id不能为空");
		}
		//视频上传路径
		//String fileDownloadPath = "E:\\lnsf_mod_dev";
		//视频保存路径

		String fileVideoPath ="/"+userId+"/video";
		String filecoverPath ="/"+userId+"/video";
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		String videosFinalLocal ="";
		String videosFinalLocal1 = "";

		String videosid = null;
		try {
			if(video !=null ){

				//String videoName = video.getOriginalFilename();
				String videoName =UUID.randomUUID().toString() + ".mp4";
				String videoName1 = UUID.randomUUID().toString() + ".mp4";
				//String coverNamePrefix = videoName.split("\\.")[0];
				String coverNamePrefix = UUID.randomUUID().toString();
				//String coverNamePrefix = videoName;
				if(StringUtils.isNotBlank(videoName)){
					//视频上传最终路径
					videosFinalLocal = FILE_DOWNLOAD_PATH + fileVideoPath + "/" + videoName;
					videosFinalLocal1= FILE_DOWNLOAD_PATH + fileVideoPath + "/" + videoName1;
					//视频片最终	保存路径
					fileVideoPath += ("/" + videoName);
					filecoverPath = filecoverPath + "/" + coverNamePrefix +".jpg";
					File outImage = new File(videosFinalLocal);
					if(outImage.getParentFile()!=null ||!outImage.getParentFile().isDirectory()){
						//创建父文件
						outImage.getParentFile().mkdirs();
					}
					fileOutputStream = new FileOutputStream(outImage);
					inputStream = video.getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}
			}else{
				return LnsfwxJSONResult.errorMsg("上传功能出错");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fileOutputStream !=null){
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}

		//判断bgm是否为空，不为空则合成视频
		if(StringUtils.isNotBlank(bgmId)){
			//删除原视频水印
			//18.12.02新版本创建方式
		/*	CommandManager manager=new CommandManagerImpl(1);
			String ids =manager.start("delleft", CommandBuidlerFactory.createBuidler()
					.add("ffmpeg").add("-i",videosFinalLocal)
					.add("-filter_complex","\"delogo=x=10:y=10:w=250:h=100:show=0\"")
					.add("-y",videosFinalLocal1));
			Thread.currentThread().sleep(15000);
			manager.stop("delleft");//停止*/


/*			int width =videoWidth-260;
			int height = videoHeight -110;
			manager.start("delright", CommandBuidlerFactory.createBuidler()
					.add("ffmpeg").add("-i",videosFinalLocal1)
					.add("-filter_complex","\"delogo=x=" + width + ":y=" + height + ":w=250:h=100:show=0\"")
					.add("-y",videosFinalLocal));
			Thread.currentThread().sleep(15000);
			manager.stop("delright");//停止*/

			//用于销毁保活线程等
			//manager.destory();


//			System.out.println("1"+videosFinalLocal1);
//			System.out.println("2"+videosFinalLocal2);
			//删除原视频水印
			DelWatermarkLeft delWatermarkLeft = new DelWatermarkLeft(FFMPEG_VIDEOS);
			DelWatermarkRight delWatermarkRight= new DelWatermarkRight(FFMPEG_VIDEOS,videoWidth,videoHeight);
			delWatermarkLeft.convertor(videosFinalLocal,videosFinalLocal1);
			delWatermarkRight.convertor(videosFinalLocal1,videosFinalLocal);
			String videoOutputName = UUID.randomUUID().toString() + ".mp4";
			fileVideoPath ="/"+userId+"/video"+"/"+videoOutputName;
			String finalVideosPath = FILE_DOWNLOAD_PATH + fileVideoPath;
			//音频分离重组
			DelAudio delAudio = new DelAudio(FFMPEG_VIDEOS);
			Bgm bgm = bgmService.queryBgmId(bgmId);
			String bgmInputPath = FILE_DOWNLOAD_PATH + bgm.getPath();
			MergeVideoBgm tools = new MergeVideoBgm(FFMPEG_VIDEOS);
			//String	fileVideoFinalPath =videosFinalLocal;
				delAudio.convertor(videosFinalLocal, videosFinalLocal1);
				tools.convertor(videosFinalLocal1,bgmInputPath,
						videoSeconds, finalVideosPath);
			System.out.println("videosFinalLocal"+videosFinalLocal);
			System.out.println("videosFinalLocal1"+videosFinalLocal1);
			System.out.println("finalVideosPath"+finalVideosPath);
			//视频截图工具
			FetchVideoCover videoCover = new FetchVideoCover(FFMPEG_VIDEOS);

				videoCover.getCover(finalVideosPath,FILE_DOWNLOAD_PATH+filecoverPath);
				//保存视频信息到mysql
				Videos videos = new Videos();
				videos.setAudioId(bgmId);
				videos.setUserId(userId);
				videos.setVideoSeconds((float) videoSeconds);
				videos.setVideoHeight(videoHeight);
				videos.setVideoWidth(videoWidth);
				videos.setVideoDesc(desc);
				videos.setVideoPath(fileVideoPath);
				videos.setCoverPath(filecoverPath);
				videos.setStatus(UserVideoStatusEnum.BAN.value);
				videos.setCreateTime(new Date());
				videosid = videosService.insertVideos(videos);
		}else {
			String videoOutputName = UUID.randomUUID().toString() + ".mp4";
			fileVideoPath ="/"+userId+"/video"+"/"+videoOutputName;
			String finalVideosPath = FILE_DOWNLOAD_PATH + fileVideoPath;
			//删除原视频水印
			DelWatermarkLeft delWatermarkLeft = new DelWatermarkLeft(FFMPEG_VIDEOS);
			DelWatermarkRight delWatermarkRight= new DelWatermarkRight(FFMPEG_VIDEOS,videoWidth,videoHeight);
			delWatermarkLeft.convertor(videosFinalLocal,videosFinalLocal1);
			delWatermarkRight.convertor(videosFinalLocal1,finalVideosPath);
			//18.12.02新版本创建方式
		/*	CommandManager manager=new CommandManagerImpl(1);
			manager.start("delleft", CommandBuidlerFactory.createBuidler()
					.add("ffmpeg").add("-i",videosFinalLocal)
					.add("-filter_complex","\"delogo=x=10:y=10:w=250:h=100:show=0\"")
					.add("-y",videosFinalLocal1));
			Thread.currentThread().sleep(15000);
			manager.stop("delleft");//停止*/

/*
			int width =videoWidth-260;
			int height = videoHeight -110;
			manager.start("delright", CommandBuidlerFactory.createBuidler()
					.add("ffmpeg").add("-i",videosFinalLocal1)
					.add("-filter_complex","\"delogo=x=" + width + ":y=" + height + ":w=250:h=100:show=0\"")
					.add("-y",finalVideosPath));
			Thread.currentThread().sleep(15000);
			manager.stop("delright");//停止

			//用于销毁保活线程等
			manager.destory();*/

			//视频截图工具
			FetchVideoCover videoCover = new FetchVideoCover(FFMPEG_VIDEOS);
				videoCover.getCover(finalVideosPath,FILE_DOWNLOAD_PATH+filecoverPath);
				//保存视频信息到mysql
				Videos videos = new Videos();
				videos.setAudioId(bgmId);
				videos.setUserId(userId);
				videos.setVideoSeconds((float) videoSeconds);
				videos.setVideoHeight(videoHeight);
				videos.setVideoWidth(videoWidth);
				videos.setVideoDesc(desc);
				videos.setVideoPath(fileVideoPath);
				videos.setCoverPath(filecoverPath);
				videos.setStatus(UserVideoStatusEnum.BAN.value);
				videos.setCreateTime(new Date());
				videosid = videosService.insertVideos(videos);
			}

		return LnsfwxJSONResult.ok(videosid);
	}



	@ApiOperation(value = "用户上传封面",notes = "用户上传封面的接口")
	@ApiImplicitParams({
			@ApiImplicitParam(name="videoId",value = "视频的id",required =true,dataType = "String",paramType = "form"),
			@ApiImplicitParam(name="userId",value = "用户的id",required =true,dataType = "String",paramType = "form"),
	})
	@PostMapping(value = "/upLoadCover",headers = "content-type=multipart/form-data")
	public LnsfwxJSONResult upLoadCover(String videoId ,String userId, @ApiParam(value = "视频封面",required =true ) MultipartFile cover) throws Exception {
		if(StringUtils.isBlank(videoId) ||StringUtils.isBlank(userId) ){
			return LnsfwxJSONResult.errorMsg("视频的id和用户id不能为空");
		}
		//视频上传路径
		//String fileDownloadPath = "E:\\lnsf_mod_dev";
		//视频保存路径
		String fileCoverPath ="/"+userId+"/video";
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		String coverFinalLocal ="";
		String videosid = null;
		try {
			if(cover !=null ){

				String videoName = cover.getOriginalFilename();
				if(StringUtils.isNotBlank(videoName)){
					//视频上传最终路径
					coverFinalLocal = FILE_DOWNLOAD_PATH + fileCoverPath + "/" + videoName;
					//视频片最终	保存路径
					fileCoverPath += ("/" + videoName);
					File outImage = new File(coverFinalLocal);
					if(outImage.getParentFile()!=null ||!outImage.getParentFile().isDirectory()){
						//创建父文件
						outImage.getParentFile().mkdirs();
					}
					fileOutputStream = new FileOutputStream(outImage);
					inputStream = cover.getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}
			}else{
				return LnsfwxJSONResult.errorMsg("上传功能出错");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fileOutputStream !=null){
				fileOutputStream.flush();
				fileOutputStream.close();
			}
		}


		videosService.updateVideos(videoId, coverFinalLocal);
		return LnsfwxJSONResult.ok();
	}

	@PostMapping(value = "/showAllVideos")
	public LnsfwxJSONResult showAllVideos(@RequestBody Videos video,Integer isSaveRecord, Integer pages,Integer pageSize) {
		if (pages == null) {
			pages =1;
		}
		if (pageSize == null) {
			pageSize =PAGE_SIZE;
		}
		PagedResult	 pagedResult =videosService.getAllVideosAndUsers(video,isSaveRecord,pages, pageSize);
		return LnsfwxJSONResult.ok(pagedResult);

	}

	@PostMapping(value = "/showLikeVideos")
	public LnsfwxJSONResult showLikeVideos(String userId, Integer pages,Integer pageSize) {
		if (pages == null) {
			pages =1;
		}
		if (pageSize == null) {
			pageSize =PAGE_SIZE;
		}
		PagedResult	 pagedResult =videosService.selectMyLikeVideos(userId,pages,pageSize);
		return LnsfwxJSONResult.ok(pagedResult);

	}

	@PostMapping(value = "/showFollowVideos")
	public LnsfwxJSONResult showFollowVideos(String userId, Integer pages,Integer pageSize) {
		if (pages == null) {
			pages =1;
		}
		if (pageSize == null) {
			pageSize =PAGE_SIZE;
		}
		PagedResult	 pagedResult =videosService.selectFollowVideos(userId,pages,pageSize);
		return LnsfwxJSONResult.ok(pagedResult);

	}


	@PostMapping(value = "/hotselect")
	public LnsfwxJSONResult hotselect() {

		return LnsfwxJSONResult.ok(videosService.getHotselect());

	}
	@PostMapping(value = "/userLike")
	public LnsfwxJSONResult userLike(String userId,String videoId,String videoUserId) {
		videosService.userLikeVideos(userId,videoId,videoUserId);
		return LnsfwxJSONResult.ok();

	}
	@PostMapping(value = "/userDisLike")
	public LnsfwxJSONResult userDisLike(String userId,String videoId,String videoUserId) {
		videosService.userDislikeVideos(userId,videoId,videoUserId);
		return LnsfwxJSONResult.ok();

	}
	@PostMapping("/saveComment")
	public LnsfwxJSONResult saveComment(@RequestBody Comments comment,
									   String fatherCommentId, String toUserId) throws Exception {

		comment.setFatherCommentId(fatherCommentId);
		comment.setToUserId(toUserId);
		videosService.saveComment(comment);
		return LnsfwxJSONResult.ok();
	}

	@PostMapping("/getVideoComments")
	public LnsfwxJSONResult getVideoComments(String videoId, Integer page, Integer pageSize) throws Exception {

		if (StringUtils.isBlank(videoId)) {
			return LnsfwxJSONResult.ok();
		}

		// 分页查询视频列表，时间顺序倒序排序
		if (page == null) {
			page = 1;
		}

		if (pageSize == null) {
			pageSize = 10;
		}

		PagedResult list = videosService.getAllComments(videoId, page, pageSize);

		return LnsfwxJSONResult.ok(list);
	}


	@PostMapping("/hiddenVideos")
	public LnsfwxJSONResult hiddenVideos(String userId, Boolean isChecked) throws Exception {

		if (StringUtils.isBlank(userId)) {
			return LnsfwxJSONResult.errorMsg("程序运行失败");
		}
		usersService.updateUserHidden(userId,isChecked);


		return LnsfwxJSONResult.ok();
	}
	
}
