package com.lnsfwx.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 
 * @Description: 获取视频的信息
 */
public class FetchVideoCover {
	// 视频路径
	private String ffmpegVideos;

	public int getCover(String videoInputPath, String coverOutputPath) throws IOException, InterruptedException {
//		ffmpeg.exe -ss 00:00:01 -i spring.mp4 -vframes 1 bb.jpg
		List<String> command = new java.util.ArrayList<String>();
		command.add(ffmpegVideos);
		
		// 指定截取第1秒
		command.add("-ss");
		command.add("00:00:01");
		command.add("-y");
		command.add("-i");
		command.add(videoInputPath);
		command.add("-vframes");
		command.add("1");
		command.add(coverOutputPath);
		for (String c : command) {
			System.out.print(c + " ");
		}
		
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
/*
		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
	String line = "";
		while ( (line = br.readLine()) != null ) {
		}
		if(br1 !=null){
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

	public String getFfmpegEXE() {
		return ffmpegVideos;
	}

	public void setFfmpegEXE(String ffmpegVideos) {
		this.ffmpegVideos = ffmpegVideos;
	}

	public FetchVideoCover() {
		super();
	}

	public FetchVideoCover(String ffmpegVideos) {
		this.ffmpegVideos = ffmpegVideos;
	}
	
	public static void main(String[] args) {
		// 获取视频信息。
		FetchVideoCover videoInfo = new FetchVideoCover("c:\\ffmpeg\\bin\\ffmpeg.exe");
		try {
			videoInfo.getCover("c:\\北京北京.avi","c:\\北京.jpg");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}