package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.BgmDao;
import io.renren.modules.generator.entity.BgmEntity;
import io.renren.modules.generator.service.BgmService;


@Service("bgmService")
public class BgmServiceImpl extends ServiceImpl<BgmDao, BgmEntity> implements BgmService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BgmEntity> page = this.page(
                new Query<BgmEntity>().getPage(params),
                new QueryWrapper<BgmEntity>().like("id",(String)params.get("key"))
                        .or().like("author", (String)params.get("key")).or().like("name", (String)params.get("key")).or().like("path", (String)params.get("key")));

        return new PageUtils(page);
    }

}