package com.example.vidoview.bean; /**
 * Copyright 2019 bejson.com
 */

import java.util.List;

/**
 * Created by Y-zi on 2019/8/29
 * Github:https://github.com/Y-zi
 * QQ:992063180
 */
public class DataBean {

    private String desc;
    private String avatar;
    private String video_url;
    private String unique_id;
    private String nickname;
    private String short_id;
    private String share_url;
    private String video_img;
    private Statistics statistics;
    private List<Comment> comments;
    private String tb_link;


    public static class Comment{
        private String text;
        private String create_time;
        private String nickname;
        private String zan;
        private String avatar;
        private String short_id;
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getZan() {
            return zan;
        }

        public void setZan(String zan) {
            this.zan = zan;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getShort_id() {
            return short_id;
        }

        public void setShort_id(String short_id) {
            this.short_id = short_id;
        }
    }


    /**
     * Auto-generated: 2019-01-07 14:40:1
     *
     * @author bejson.com (i@bejson.com)
     * @website http://www.bejson.com/java2pojo/
     */
    public static class Statistics {

        private int zan;
        private int comment;
        private int share;
        private int play;
        public void setZan(int zan) {
            this.zan = zan;
        }
        public int getZan() {
            return zan;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }
        public int getComment() {
            return comment;
        }

        public void setShare(int share) {
            this.share = share;
        }
        public int getShare() {
            return share;
        }

        public void setPlay(int play) {
            this.play = play;
        }
        public int getPlay() {
            return play;
        }

    }



    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
    public String getVideo_url() {
        return video_url;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }
    public String getUnique_id() {
        return unique_id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setShort_id(String short_id) {
        this.short_id = short_id;
    }
    public String getShort_id() {
        return short_id;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }
    public String getShare_url() {
        return share_url;
    }

    public void setVideo_img(String video_img) {
        this.video_img = video_img;
    }
    public String getVideo_img() {
        return video_img;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
    public Statistics getStatistics() {
        return statistics;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public List<Comment> getComments() {
        return comments;
    }

    public void setTb_link(String tb_link) {
        this.tb_link = tb_link;
    }
    public String getTb_link() {
        return tb_link;
    }

}