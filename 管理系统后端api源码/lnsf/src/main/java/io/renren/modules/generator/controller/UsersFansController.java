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

import io.renren.modules.generator.entity.UsersFansEntity;
import io.renren.modules.generator.service.UsersFansService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户粉丝表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@RestController
@RequestMapping("generator/usersfans")
public class UsersFansController {
    @Autowired
    private UsersFansService usersFansService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:usersfans:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usersFansService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:usersfans:info")
    public R info(@PathVariable("id") String id){
		UsersFansEntity usersFans = usersFansService.getById(id);

        return R.ok().put("usersFans", usersFans);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:usersfans:save")
    public R save(@RequestBody UsersFansEntity usersFans){
		usersFansService.save(usersFans);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:usersfans:update")
    public R update(@RequestBody UsersFansEntity usersFans){
		usersFansService.updateById(usersFans);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:usersfans:delete")
    public R delete(@RequestBody String[] ids){
		usersFansService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
