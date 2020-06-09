package com.lnsfwx.mapper;

import com.lnsfwx.pojo.Users;
import com.lnsfwx.pojo.UsersExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UsersMapper {
    int countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(String id);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    /**
     * 用户喜欢累加
     * @param id
     */
    @Update("update users set receive_like_counts=receive_like_counts+1 where id = #{id}")
    public void addReceiveLikeCount(@Param("id") String id);
    /**
     * * 用户喜欢累减
     * @param id
     */
    @Update("update users set receive_like_counts=receive_like_counts-1 where id = #{id} and receive_like_counts>=1")
    public void subReceiveLikeCount(@Param("id") String id);

    /**
     * 增加粉丝数量
     */
    @Update("update users set fans_counts=fans_counts+1 where id = #{userId} ")
    public void addFansCount(@Param("userId") String userId);
    /**
     * 减少粉丝数量
     */
    @Update("update users set fans_counts=fans_counts+1 where id = #{userId} ")
    public void subFansCount(@Param("userId") String userId);
    /**
     * 增加关注数量
     */
    @Update("update users set follow_counts=follow_counts+1 where id = #{userId}")
    public void addFollowCounts(@Param("userId") String userId);
    /**
     * 减少关注数量
     *
     */
    @Update("update users set follow_counts=follow_counts-1 where id = #{userId} and follow_counts>0 ")
    public void subFollowCounts(@Param("userId") String userId);
}