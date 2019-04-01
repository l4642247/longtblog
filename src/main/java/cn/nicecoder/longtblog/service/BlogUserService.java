package cn.nicecoder.longtblog.service;

import cn.nicecoder.longtblog.entity.BlogUser;

import java.util.List;

public interface BlogUserService {
    //用户登录
    boolean login(String username, String password);

    //查询用户详情
    BlogUser userInfo(Long id);

    //查询所有
    List<BlogUser> AllUserInfo();
}
