package cn.nicecoder.longtblog.pojo;

import java.util.Date;

/**
 * @Author: longt
 * @Date: 2019/5/15 10:13
 * @Description:
 */
public interface CommentStatistic {
    String getType();
    String getStatus();
    int getAgree();
    byte[] getContent();
    Date getCreateTime();
    Long getId();
    String getTouserid();
    String getUserid();
    String getName();
    String getPic();
    String getToname();
    String getTopic();

    default CommentResult toComment() {
        CommentResult result = new CommentResult();
        result.setType(getType());
        result.setStatus(getStatus());
        result.setAgree(getAgree());
        result.setContent(getContent());
        result.setCreateTime(getCreateTime());
        result.setId(getId());
        result.setTouserid(getTouserid());
        result.setUserid(getUserid());
        result.setName(getName());
        result.setPic(getPic());
        result.setToname(getToname());
        result.setTopic(getTopic());
        return result;
    }
}
