package cn.nicecoder.longtblog.service.Impl;

import cn.hutool.crypto.SecureUtil;
import cn.nicecoder.longtblog.Dao.BlogUserDao;
import cn.nicecoder.longtblog.entity.BlogUser;
import cn.nicecoder.longtblog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: longt
 * @Date: 2019/3/29 15:50
 * @Description: 实现类
 */
@Service
public class BlogUserServiceImpl implements BlogUserService {
    @Autowired
    BlogUserDao blogUserDao;

    @Override
    public boolean login(String username, String password) {
        BlogUser user = blogUserDao.findByUsername(username);
        if(user != null && SecureUtil.md5(password).equals(user.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public BlogUser userInfo(Long id) {
        return blogUserDao.getOne(id);
    }
}
