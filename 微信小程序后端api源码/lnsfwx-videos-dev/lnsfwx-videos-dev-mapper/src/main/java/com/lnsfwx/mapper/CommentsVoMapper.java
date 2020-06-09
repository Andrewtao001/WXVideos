package com.lnsfwx.mapper;

import java.util.List;

import com.lnsfwx.pojo.Comments;
import com.lnsfwx.pojo.vo.CommentsVO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommentsVoMapper extends CommentsMapper {
	@Select("<script>" +
			"select c.*,u.face_image,u.nickname,tu.nickname as toNickName from comments c left join  users u  on c.from_user_id = u.id " +
			" left join users tu on c.to_user_id = tu.id "+
			"where 1=1 and c.video_id =#{videoId} order by c.create_time desc "+
			"</script>")
	@Results({
			@Result(property = "id", column = "id"),
			@Result(property = "videoId", column = "video_id"),
			@Result(property = "fromUserId", column = "from_user_id"),
			@Result(property = "createTime", column = "create_time"),
			@Result(property = "comment", column = "comment"),
			@Result(property = "faceImage", column = "face_image"),
			@Result(property = "nickname", column = "nickname"),
	})
	public List<CommentsVO> queryComments(@Param("videoId") String videoId);
}