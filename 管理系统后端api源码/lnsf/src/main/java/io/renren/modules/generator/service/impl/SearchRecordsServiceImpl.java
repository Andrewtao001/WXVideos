package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.SearchRecordsDao;
import io.renren.modules.generator.entity.SearchRecordsEntity;
import io.renren.modules.generator.service.SearchRecordsService;


@Service("searchRecordsService")
public class SearchRecordsServiceImpl extends ServiceImpl<SearchRecordsDao, SearchRecordsEntity> implements SearchRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SearchRecordsEntity> page = this.page(
                new Query<SearchRecordsEntity>().getPage(params),
                new QueryWrapper<SearchRecordsEntity>().like("id",(String)params.get("key"))
                        .or().like("content", (String)params.get("key")));
        return new PageUtils(page);
    }

}