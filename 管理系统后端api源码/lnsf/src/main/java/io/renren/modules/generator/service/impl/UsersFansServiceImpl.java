package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.UsersFansDao;
import io.renren.modules.generator.entity.UsersFansEntity;
import io.renren.modules.generator.service.UsersFansService;


@Service("usersFansService")
public class UsersFansServiceImpl extends ServiceImpl<UsersFansDao, UsersFansEntity> implements UsersFansService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsersFansEntity> page = this.page(
                new Query<UsersFansEntity>().getPage(params),
                new QueryWrapper<UsersFansEntity>().like("id",(String)params.get("key"))
                        .or().like("user_id", (String)params.get("key")).or().like("fan_id", (String)params.get("key")));


        return new PageUtils(page);
    }

}