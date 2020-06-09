package com.lnsfwx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lnsfwx.mapper.*;
import com.lnsfwx.pojo.*;
import com.lnsfwx.pojo.vo.CommentsVO;
import com.lnsfwx.pojo.vo.VideosVo;
import com.lnsfwx.service.BgmService;
import com.lnsfwx.service.VideosService;
import com.lnsfwx.utils.BadWordUtils;
import com.lnsfwx.utils.PagedResult;
import com.lnsfwx.utils.TimeAgoUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Auther 刘瑞涛
 * @Date 2020-03-11 23:28
 **/
@Transactional
@Service
public class VideosServiceImpl implements VideosService {


    @Resource
    private SearchRecordsMapper searchRecordsMapper;
    @Resource
    private VideosVoMapper videosVoMapper;
    @Resource
    private  UsersMapper usersMapper;
    @Resource
    private UsersLikeVideosMapper usersLikeVideosMapper;
    @Autowired
    private Sid sid;
    @Resource
    private VideosMapper videosMapper;
    @Resource
    private  CommentsMapper commentsMapper;
    @Resource
    private  CommentsVoMapper commentsVoMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String insertVideos(Videos videos) {
        String id = sid.nextShort();
        videos.setId(id);
        videosMapper.insertSelective(videos);
        return id;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public String updateVideos(String videoId, String coverPath) {

        Videos videos = new Videos();
        videos.setId(videoId);
        videos.setCoverPath(coverPath);
        videosMapper.updateByPrimaryKeySelective(videos);
        return null;
    }

    /**
     * 分页与查询视频列表
     * @param video
     * @param isSaveRecord 1为保存视频，0为不保存
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PagedResult getAllVideosAndUsers( Videos video,Integer isSaveRecord,Integer pageNum, Integer pageSize) {
        String desc = video.getVideoDesc();
        String userId = video.getUserId();
        //  保存热搜
        if(isSaveRecord != null && isSaveRecord ==1){
            SearchRecords records = new SearchRecords();
            String id =sid.nextShort();
            records.setId(id);
            records.setContent(desc);
            searchRecordsMapper.insert(records);
        }

        PageHelper.startPage(pageNum, pageSize);
     List<VideosVo>    videosVo =   videosVoMapper.selectVideosAndUsers(desc,userId);
        PageInfo<VideosVo> pageList = new PageInfo<>(videosVo);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(pageNum);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(videosVo);
        pagedResult.setRecords(pageList.getTotal());
        return pagedResult;
    }

    @Override
    public PagedResult selectMyLikeVideos(String userId, Integer pages, Integer pageSize) {
        PageHelper.startPage(pages, pageSize);
        List<VideosVo>    videosVo =   videosVoMapper.selectMyLikeVideos(userId);
        PageInfo<VideosVo> pageList = new PageInfo<>(videosVo);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(pages);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(videosVo);
        pagedResult.setRecords(pageList.getTotal());
        return pagedResult;
    }

    @Override
    public PagedResult selectFollowVideos(String userId, Integer pages, Integer pageSize) {
        PageHelper.startPage(pages, pageSize);
        List<VideosVo>    videosVo =   videosVoMapper.selectFollowVideos(userId);
        PageInfo<VideosVo> pageList = new PageInfo<>(videosVo);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(pages);
        pagedResult.setTotal(pageList.getPages());
        pagedResult.setRows(videosVo);
        pagedResult.setRecords(pageList.getTotal());
        return pagedResult;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<String> getHotselect() {

        return searchRecordsMapper.getHotselect();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void userLikeVideos(String userId, String videoId, String videoUserId) {
        System.out.println(1+userId);
        System.out.println(2+videoId);
        System.out.println(3+videoUserId);
        //保存用户和视频的喜欢点赞关联关系表
        String likeId =sid.nextShort();
        UsersLikeVideos usersLikeVideos =new UsersLikeVideos();
        usersLikeVideos.setId(likeId);
        usersLikeVideos.setUserId(userId);
        usersLikeVideos.setVideoId(videoId);
        usersLikeVideosMapper.insert(usersLikeVideos);

        //2.视频喜欢数量累加
        videosVoMapper.addVideoLikeCount(videoId);
        //3.用户受喜欢数量的累加
        usersMapper.addReceiveLikeCount(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void userDislikeVideos(String userId, String videoId, String videoUserId) {
        //删除用户和视频的喜欢点赞关联关系表
        UsersLikeVideosExample usersLikeVideosExample =new UsersLikeVideosExample();
        usersLikeVideosExample.createCriteria().andUserIdEqualTo(userId).andVideoIdEqualTo(videoId);
        usersLikeVideosMapper.deleteByExample(usersLikeVideosExample);
        //2.视频喜欢数量累减
        videosVoMapper.subVideoLikeCount(videoId);
        //3.用户受喜欢数量的累减
        usersMapper.subReceiveLikeCount(userId);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveComment(Comments comment) throws Exception {
        Set<String> sensitiveWordSet=BadWordUtils.readResource();
        //初始化敏感词库
        BadWordUtils.init(sensitiveWordSet);
        String filterStr = BadWordUtils.replaceSensitiveWord(comment.getComment(), '*');
        String id = sid.nextShort();
        comment.setId(id);
        comment.setComment(filterStr);
        comment.setCreateTime(new Date());
        commentsMapper.insert(comment);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)

    public PagedResult getAllComments(String videoId, Integer page, Integer pageSize) {

        PageHelper.startPage(page, pageSize);

        List<CommentsVO> list = commentsVoMapper.queryComments(videoId);

        for (CommentsVO c : list) {
            String timeAgo = TimeAgoUtils.format(c.getCreateTime());
            c.setTimeAgoStr(timeAgo);
        }

        PageInfo<CommentsVO> pageList = new PageInfo<>(list);

        PagedResult grid = new PagedResult();
        grid.setTotal(pageList.getPages());
        grid.setRows(list);
        grid.setPage(page);
        grid.setRecords(pageList.getTotal());

        return grid;
    }

}
