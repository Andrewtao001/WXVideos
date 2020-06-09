package com.lnsfwx.service;

import com.lnsfwx.pojo.Bgm;

import java.util.List;

public interface BgmService {
    /**
     * 查询背景音乐
     * @return
     */
    public List<Bgm> queryBgmList();

    public Bgm queryBgmId(String id);

}
