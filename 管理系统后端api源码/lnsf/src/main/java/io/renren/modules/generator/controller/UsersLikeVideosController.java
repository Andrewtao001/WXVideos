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

import io.renren.modules.generator.entity.UsersLikeVideosEntity;
import io.renren.modules.generator.service.UsersLikeVideosService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户视频关联表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@RestController
@RequestMapping("generator/userslikevideos")
public class UsersLikeVideosController {
    @Autowired
    private UsersLikeVideosService usersLikeVideosService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:userslikevideos:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usersLikeVideosService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:userslikevideos:info")
    public R info(@PathVariable("id") String id){
		UsersLikeVideosEntity usersLikeVideos = usersLikeVideosService.getById(id);

        return R.ok().put("usersLikeVideos", usersLikeVideos);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:userslikevideos:save")
    public R save(@RequestBody UsersLikeVideosEntity usersLikeVideos){
		usersLikeVideosService.save(usersLikeVideos);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:userslikevideos:update")
    public R update(@RequestBody UsersLikeVideosEntity usersLikeVideos){
		usersLikeVideosService.updateById(usersLikeVideos);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:userslikevideos:delete")
    public R delete(@RequestBody String[] ids){
		usersLikeVideosService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
