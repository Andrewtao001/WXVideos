package com.lnsfwx.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class MergeVideoBgm {

	private String ffmpegVideos;

	public MergeVideoBgm(String ffmpegVideos) {
		super();
		this.ffmpegVideos = ffmpegVideos;
	}

	public int convertor(String videoInputPath, String bgmInputPath,
			double seconds, String videoOutputPath) throws Exception {
//		ffmpeg.exe -i 苏州大裤衩.mp4 -i bgm.mp3 -t 7 -y 新的视频.mp4
		List<String> command = new ArrayList<>();
		command.add(ffmpegVideos);
		
		command.add("-i");
		command.add(videoInputPath);

		command.add("-i");
		command.add(bgmInputPath);
		
		command.add("-t");
		command.add(String.valueOf(seconds));
		
		command.add("-y");
		command.add(videoOutputPath);
		
		for (String c : command) {
			System.out.print(c + " ");
		}
		
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();

		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		
		String line = "";
		while ( (line = br.readLine()) != null ) {
		}
		
		if (br != null) {
			br.close();
		}
		if (inputStreamReader != null) {
			inputStreamReader.close();
		}
		if (errorStream != null) {
			errorStream.close();
		}
		return 1;
	}

	public static void main(String[] args) {
		MergeVideoBgm ffmpeg = new MergeVideoBgm("C:\\ffmpeg\\bin\\ffmpeg.exe");
		try {
			ffmpeg.convertor("C:\\苏州大裤衩.mp4", "C:\\music.mp3", 7.1, "C:\\这是通过java生产的视频.mp4");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
