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

import io.renren.modules.generator.entity.VideosEntity;
import io.renren.modules.generator.service.VideosService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 视频表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@RestController
@RequestMapping("generator/videos")
public class VideosController {
    @Autowired
    private VideosService videosService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:videos:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = videosService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:videos:info")
    public R info(@PathVariable("id") String id){
		VideosEntity videos = videosService.getById(id);

        return R.ok().put("videos", videos);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:videos:save")
    public R save(@RequestBody VideosEntity videos){
		videosService.save(videos);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:videos:update")
    public R update(@RequestBody VideosEntity videos){
		videosService.updateById(videos);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:videos:delete")
    public R delete(@RequestBody String[] ids){
		videosService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
