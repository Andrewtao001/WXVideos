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

import io.renren.modules.generator.entity.UsersReportEntity;
import io.renren.modules.generator.service.UsersReportService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 用户举报表
 *
 * @author Liu RuiTao
 * @email 1044973286@qq.com
 * @date 2020-05-08 09:49:05
 */
@RestController
@RequestMapping("generator/usersreport")
public class UsersReportController {
    @Autowired
    private UsersReportService usersReportService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:usersreport:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usersReportService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:usersreport:info")
    public R info(@PathVariable("id") String id){
		UsersReportEntity usersReport = usersReportService.getById(id);

        return R.ok().put("usersReport", usersReport);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:usersreport:save")
    public R save(@RequestBody UsersReportEntity usersReport){
		usersReportService.save(usersReport);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:usersreport:update")
    public R update(@RequestBody UsersReportEntity usersReport){
		usersReportService.updateById(usersReport);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:usersreport:delete")
    public R delete(@RequestBody String[] ids){
		usersReportService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
