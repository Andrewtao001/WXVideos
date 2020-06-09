package com.lnsfwx.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 删除视频原有音频
 */
public class DelAudio {

	private String ffmpegVideos;

	public DelAudio(String ffmpegVideos) {
		super();
		this.ffmpegVideos = ffmpegVideos;
	}

	public int convertor(String videoInputPath, String videoOutputPath) throws Exception {
//		ffmpeg -i E:\lnsf_mod_dev\20030328Y46XC8DP\video\1.mp4 -vcodec copy -an  E:\lnsf_mod_dev\20030328Y46XC8DP\video\2.mp4
		List<String> command = new ArrayList<>();
		command.add(ffmpegVideos);
		
		command.add("-i");
		command.add(videoInputPath);

		command.add("-vcodec");
		command.add("copy");
		
		command.add("-an");
		command.add("-y");
		command.add(videoOutputPath);
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();
		// 启动单独的线程来清空process.getInputStream()的缓冲区
		try {
			//获取进程的标准输入流
			final InputStream is1 = process.getInputStream();
			//获取进城的错误流
			final InputStream is2 = process.getErrorStream();
			//启动两个线程，一个线程负责读标准输出流，另一个负责读标准错误流
			new Thread() {
				public void run() {
					BufferedReader br1 = new BufferedReader(new InputStreamReader(is1));
					try {
						String line1 = null;
						while ((line1 = br1.readLine()) != null) {
							if (line1 != null){}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					finally{
						try {
							is1.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();

			new Thread() {
				public void  run() {
					BufferedReader br2 = new  BufferedReader(new  InputStreamReader(is2));
					try {
						String line2 = null ;
						while ((line2 = br2.readLine()) !=  null ) {
							if (line2 != null){}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					finally{
						try {
							is2.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();

			//可能导致进程阻塞，甚至死锁
			int ret = process.waitFor();
			System.out.println("return value:"+ret);
			System.out.println(process.exitValue());
		}catch (Exception ex){
			ex.printStackTrace();
			try{
				process.getErrorStream().close();
				process.getInputStream().close();
				process.getOutputStream().close();
			}
			catch(Exception ee){}
		}
		/*for (String c : command) {
			System.out.println(c + " ");
		}
		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		
		String line = "";
		while ( (line = br.readLine()) != null ) {
		}
		if (br1 != null) {
			br1.close();
		}
		if (br != null) {
			br.close();
		}
		if (inputStreamReader != null) {
			inputStreamReader.close();
		}
		if (errorStream != null) {
			errorStream.close();
		}*/
		return 1;
	}

}
