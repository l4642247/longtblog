package cn.nicecoder.longtblog.service;

import cn.nicecoder.longtblog.entity.BlogUser;

public interface BlogUserService {
    //用户登录
    boolean login(String username, String password);

    //查询用户详情
    BlogUser userInfo(Long id);
}
