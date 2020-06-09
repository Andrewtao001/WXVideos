package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.VideosDao;
import io.renren.modules.generator.entity.VideosEntity;
import io.renren.modules.generator.service.VideosService;


@Service("videosService")
public class VideosServiceImpl extends ServiceImpl<VideosDao, VideosEntity> implements VideosService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<VideosEntity> page = this.page(
                new Query<VideosEntity>().getPage(params),
                new QueryWrapper<VideosEntity>().like("id",(String)params.get("key"))
                        .or().like("user_id", (String)params.get("key")).or().like("audio_id", (String)params.get("key"))
                        .or().like("video_desc", (String)params.get("key"))  .or().like("video_seconds", (String)params.get("key")).or().like("video_width", (String)params.get("key"))
                        .or().like("video_height", (String)params.get("key")).or().like("like_counts", (String)params.get("key")));

        return new PageUtils(page);
    }

}