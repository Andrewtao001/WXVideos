package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CommentsDao;
import io.renren.modules.generator.entity.CommentsEntity;
import io.renren.modules.generator.service.CommentsService;


@Service("commentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, CommentsEntity> implements CommentsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CommentsEntity> page = this.page(
                new Query<CommentsEntity>().getPage(params),
                new QueryWrapper<CommentsEntity>().like("id",(String)params.get("key")).or().like("from_user_id", (String)params.get("key")).or().like("to_user_id", (String)params.get("key")).or().like("comment", (String)params.get("key"))
                        .or().like("video_id", (String)params.get("key")).or().like("father_comment_id", (String)params.get("key")));

        return new PageUtils(page);
    }

}