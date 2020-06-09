package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.IdentityUsersDao;
import io.renren.modules.generator.entity.IdentityUsersEntity;
import io.renren.modules.generator.service.IdentityUsersService;


@Service("identityUsersService")
public class IdentityUsersServiceImpl extends ServiceImpl<IdentityUsersDao, IdentityUsersEntity> implements IdentityUsersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<IdentityUsersEntity> page = this.page(
                new Query<IdentityUsersEntity>().getPage(params),
                new QueryWrapper<IdentityUsersEntity>().like("id",(String)params.get("key"))
                        .or().like("user_id", (String)params.get("key")).or().like("question1", (String)params.get("key")).or().like("question2", (String)params.get("key")).or().like("question3", (String)params.get("key")).or().like("answer1", (String)params.get("key")).or().like("answer2", (String)params.get("key")).or().like("answer3", (String)params.get("key")));

        return new PageUtils(page);
    }

}