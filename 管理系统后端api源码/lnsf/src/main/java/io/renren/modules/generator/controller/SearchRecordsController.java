package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.SearchRecordsEntity;
import io.renren.modules.generator.service.SearchRecordsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 热搜表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@RestController
@RequestMapping("generator/searchrecords")
public class SearchRecordsController {
    @Autowired
    private SearchRecordsService searchRecordsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:searchrecords:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = searchRecordsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:searchrecords:info")
    public R info(@PathVariable("id") String id){
		SearchRecordsEntity searchRecords = searchRecordsService.getById(id);

        return R.ok().put("searchRecords", searchRecords);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:searchrecords:save")
    public R save(@RequestBody SearchRecordsEntity searchRecords){
		searchRecordsService.save(searchRecords);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:searchrecords:update")
    public R update(@RequestBody SearchRecordsEntity searchRecords){
		searchRecordsService.updateById(searchRecords);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:searchrecords:delete")
    public R delete(@RequestBody String[] ids){
		searchRecordsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
