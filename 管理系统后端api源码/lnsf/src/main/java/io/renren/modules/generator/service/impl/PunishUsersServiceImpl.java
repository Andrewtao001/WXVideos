package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.PunishUsersDao;
import io.renren.modules.generator.entity.PunishUsersEntity;
import io.renren.modules.generator.service.PunishUsersService;


@Service("punishUsersService")
public class PunishUsersServiceImpl extends ServiceImpl<PunishUsersDao, PunishUsersEntity> implements PunishUsersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PunishUsersEntity> page = this.page(
                new Query<PunishUsersEntity>().getPage(params),
                new QueryWrapper<PunishUsersEntity>().like("id",(String)params.get("key"))
                        .or().like("user_id", (String)params.get("key")));

        return new PageUtils(page);
    }

}