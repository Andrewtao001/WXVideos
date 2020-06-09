package com.lnsfwx.controller;

import com.lnsfwx.service.BgmService;
import com.lnsfwx.utils.LnsfwxJSONResult;
import io.swagger.annotations.Api;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@Api(value = "用户上传bgm有关业务的接口",tags ={"用户上传bgm业务controller"} )
@RequestMapping("/userbgm")
public class UserBgmController {
	@Autowired
	private BgmService bgmService;


	@PostMapping("/bgmlist")
	public LnsfwxJSONResult bgmlist() {
		return LnsfwxJSONResult.ok(bgmService.queryBgmList());
	}


	@RequestMapping("/uploadmp3")
	public LnsfwxJSONResult uploadMp3( MultipartFile[] file) throws Exception {
		System.out.println(3333333);
		//MP3上传路径
		String fileDownloadPath = "C:\\lnsf_mod_dev";
		//String fileDownloadPath = "/opt/lnsf_mod_dev";
		//图片保存路径
		String fileUploadPath ="/music";
		FileOutputStream fileOutputStream = null;
		InputStream inputStream = null;
		try {
			if(file !=null &&file.length>0){

				String imageName = file[0].getOriginalFilename();
				if(!imageName.isEmpty()){
					//图片上传最终路径
					String imageFinalLocal = fileDownloadPath + fileUploadPath + "/" + imageName;
					//图片最终	保存路径
					fileUploadPath += ("/" + imageName);
					File outImage = new File(imageFinalLocal);
					if(outImage.getParentFile()!=null ||!outImage.getParentFile().isDirectory()){
						//创建父文件
						outImage.getParentFile().mkdirs();
					}
					fileOutputStream = new FileOutputStream(outImage);
					inputStream = file[0].getInputStream();
					IOUtils.copy(inputStream, fileOutputStream);
				}
			}else {
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

		return LnsfwxJSONResult.ok();
	}
	
}
