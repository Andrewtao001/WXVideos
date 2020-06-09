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

import io.renren.modules.generator.entity.IdentityUsersEntity;
import io.renren.modules.generator.service.IdentityUsersService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户身份核对表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@RestController
@RequestMapping("generator/identityusers")
public class IdentityUsersController {
    @Autowired
    private IdentityUsersService identityUsersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:identityusers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = identityUsersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:identityusers:info")
    public R info(@PathVariable("id") String id){
		IdentityUsersEntity identityUsers = identityUsersService.getById(id);

        return R.ok().put("identityUsers", identityUsers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:identityusers:save")
    public R save(@RequestBody IdentityUsersEntity identityUsers){
		identityUsersService.save(identityUsers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:identityusers:update")
    public R update(@RequestBody IdentityUsersEntity identityUsers){
		identityUsersService.updateById(identityUsers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:identityusers:delete")
    public R delete(@RequestBody String[] ids){
		identityUsersService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
