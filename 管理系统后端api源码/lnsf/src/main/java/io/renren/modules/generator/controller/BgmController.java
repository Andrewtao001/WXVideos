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

import io.renren.modules.generator.entity.BgmEntity;
import io.renren.modules.generator.service.BgmService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 背景音乐表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@RestController
@RequestMapping("generator/bgm")
public class BgmController {
    @Autowired
    private BgmService bgmService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:bgm:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bgmService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:bgm:info")
    public R info(@PathVariable("id") String id){
		BgmEntity bgm = bgmService.getById(id);

        return R.ok().put("bgm", bgm);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:bgm:save")
    public R save(@RequestBody BgmEntity bgm){
		bgmService.save(bgm);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:bgm:update")
    public R update(@RequestBody BgmEntity bgm){
		bgmService.updateById(bgm);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:bgm:delete")
    public R delete(@RequestBody String[] ids){
		bgmService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
