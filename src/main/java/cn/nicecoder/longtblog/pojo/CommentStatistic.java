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
    String getContent();
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
        String[] chars = getContent().split(",");
        StringBuffer sbu = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        result.setContent(sbu.toString());
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
