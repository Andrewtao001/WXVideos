package com.lnsfwx.mapper;

import com.lnsfwx.pojo.PunishUsers;
import com.lnsfwx.pojo.PunishUsersExample;
import java.util.List;

import com.lnsfwx.pojo.vo.VideosVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PunishUsersMapper {
    int countByExample(PunishUsersExample example);

    int deleteByExample(PunishUsersExample example);

    int deleteByPrimaryKey(String id);

    int insert(PunishUsers record);

    int insertSelective(PunishUsers record);

    List<PunishUsers> selectByExample(PunishUsersExample example);

    PunishUsers selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PunishUsers record, @Param("example") PunishUsersExample example);

    int updateByExample(@Param("record") PunishUsers record, @Param("example") PunishUsersExample example);

    int updateByPrimaryKeySelective(PunishUsers record);

    int updateByPrimaryKey(PunishUsers record);

/*    select a.id,a.user_id,a.violation,a.start_time

    from punish_users as a,

(select max(user_id) as user_id, max(start_time) as start_time from punish_users as b group by user_id ) as b

    where a.user_id=1 and a.start_time = b.start_time*/
@Select("<script>" +
        " select a.id,a.user_id,a.violation,a.start_time   from punish_users as a, " +
        "(select max(user_id) as user_id, max(start_time) as start_time from punish_users as b group by user_id ) as b "+
        "  where a.user_id=#{userId} and a.start_time = b.start_time "+
        "</script>")
@Results({
        @Result(property = "userId", column = "user_id"),
        @Result(property = "id", column = "id"),
        @Result(property = "violation", column = "violation"),
        @Result(property = "startTime", column = "start_time"),
})
public PunishUsers  selectMyLikeVideos(@Param("userId") String userId );

}