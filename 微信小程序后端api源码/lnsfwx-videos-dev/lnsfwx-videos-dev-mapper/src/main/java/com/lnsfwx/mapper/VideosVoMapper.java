package com.lnsfwx.mapper;

import com.lnsfwx.pojo.Videos;
import com.lnsfwx.pojo.VideosExample;
import com.lnsfwx.pojo.vo.VideosVo;
import org.apache.ibatis.annotations.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import java.util.List;

@Mapper
public interface VideosVoMapper  {
  /*  @Select("select v.*,u.face_image,u.nickname from videos v left join  users u on u.id = v.user_id" +
            " where 1=1 and v.status =0 order by v.create_time desc")*/
  @Select("<script>" +
          "select v.*,u.face_image,u.nickname from videos v left join  users u on u.id = v.user_id " +
          "where 1=1 "+
          "<if test='videoDesc !=null and videoDesc !=\"\" '>" +
          "and v.video_desc like '%${videoDesc}%'"+
          "</if>"+
          "<if test='userId !=null and userId !=\"\" '>" +
          "and v.user_id  =  #{userId}"+
          "</if>"+
          " and v.status =1 and u.user_hidden = 0  order by v.create_time desc"+
          "</script>")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "audioId", column = "audio_id"),
            @Result(property = "videoDesc", column = "video_desc"),
            @Result(property = "videoPath", column = "video_path"),
            @Result(property = "videoSeconds", column = "video_seconds"),
            @Result(property = "videoWidth", column = "video_width"),
            @Result(property = "videoHeight", column = "video_height"),
            @Result(property = "coverPath", column = "cover_path"),
            @Result(property = "likeCounts", column = "like_counts"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "faceImage", column = "face_image"),
    })
    public List<VideosVo> selectVideosAndUsers(@Param("videoDesc") String videoDesc,@Param("userId") String userId );



  @Select("<script>" +
          "select v.*,u.face_image,u.nickname from videos v left join  users u on u.id = v.user_id " +
          "where 1=1 and v.id in (select l.video_id from users_like_videos l where l.user_id = #{userId} )"+
          " and v.status =1 and u.user_hidden = 0 order by v.create_time desc"+
          "</script>")
  @Results({
          @Result(property = "userId", column = "user_id"),
          @Result(property = "audioId", column = "audio_id"),
          @Result(property = "videoDesc", column = "video_desc"),
          @Result(property = "videoPath", column = "video_path"),
          @Result(property = "videoSeconds", column = "video_seconds"),
          @Result(property = "videoWidth", column = "video_width"),
          @Result(property = "videoHeight", column = "video_height"),
          @Result(property = "coverPath", column = "cover_path"),
          @Result(property = "likeCounts", column = "like_counts"),
          @Result(property = "createTime", column = "create_time"),
          @Result(property = "faceImage", column = "face_image"),
  })
  public List<VideosVo>  selectMyLikeVideos(@Param("userId") String userId );


  @Select("<script>" +
          "select v.*,u.face_image,u.nickname from videos v left join  users u on u.id = v.user_id " +
          "where 1=1 and v.user_id in (select l.user_id from users_fans l where l.fan_id = #{userId} )"+
          " and v.status =1 and u.user_hidden = 0  order by v.create_time desc"+
          "</script>")
  @Results({
          @Result(property = "userId", column = "user_id"),
          @Result(property = "audioId", column = "audio_id"),
          @Result(property = "videoDesc", column = "video_desc"),
          @Result(property = "videoPath", column = "video_path"),
          @Result(property = "videoSeconds", column = "video_seconds"),
          @Result(property = "videoWidth", column = "video_width"),
          @Result(property = "videoHeight", column = "video_height"),
          @Result(property = "coverPath", column = "cover_path"),
          @Result(property = "likeCounts", column = "like_counts"),
          @Result(property = "createTime", column = "create_time"),
          @Result(property = "faceImage", column = "face_image"),
  })
  public List<VideosVo> selectFollowVideos(@Param("userId") String userId );

  /**
   * 视频点赞累加
   * @param videoId
   */
  @Update("update videos set like_counts=like_counts+1 where id = #{videoId}")
  public void addVideoLikeCount(@Param("videoId") String videoId );
  /**
   * 视频点赞累减
   * @param videoId
   */
  @Update("update videos set like_counts=like_counts-1 where id = #{videoId} and like_counts >=1")
  public void subVideoLikeCount(@Param("videoId")String videoId );

}