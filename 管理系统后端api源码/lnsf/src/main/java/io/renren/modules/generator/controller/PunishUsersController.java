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

import io.renren.modules.generator.entity.PunishUsersEntity;
import io.renren.modules.generator.service.PunishUsersService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户封禁表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@RestController
@RequestMapping("generator/punishusers")
public class PunishUsersController {
    @Autowired
    private PunishUsersService punishUsersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:punishusers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = punishUsersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:punishusers:info")
    public R info(@PathVariable("id") String id){
		PunishUsersEntity punishUsers = punishUsersService.getById(id);

        return R.ok().put("punishUsers", punishUsers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:punishusers:save")
    public R save(@RequestBody PunishUsersEntity punishUsers){
		punishUsersService.save(punishUsers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:punishusers:update")
    public R update(@RequestBody PunishUsersEntity punishUsers){
		punishUsersService.updateById(punishUsers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:punishusers:delete")
    public R delete(@RequestBody String[] ids){
		punishUsersService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
