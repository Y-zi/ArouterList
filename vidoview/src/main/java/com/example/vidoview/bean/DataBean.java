package com.example.vidoview.bean;


import java.util.List;

/**
 * Auto-generated: 2019-01-03 15:59:19
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class DataBean {

    /**
     * desc :
     * avatar : //ali2.a.yximgs.com/uhead/AB/2018/07/20/22/BMjAxODA3MjAyMjI3MTJfNTk0MDQwNjQyXzJfaGQ2ODFfNTkx_s.jpg
     * video_url : //ydmov.a.yximgs.com/upic/2018/08/11/10/:131:125:183:171:210:181:145:149:141:125:162:137:185:128:145:179:118:126:161:180:192:180:161:191:137:125:146:149:184:129:183:187:186:136:199:205:139:179:199:187:209:127:162:175:114:129:161:172:167:125:185:162:212:197:181:184:140:143:144:117:121:152:134:208:118:147:129:157:140:159:131:137:140:99:130:120:167:101:128:208:162:100:132:157:140:151:134:141:188:101:133.mp4
     * unique_id : null
     * nickname : （雄霸）厨郎
     * short_id : :118:105:129:154:142:150:131:136:139
     * share_url : null
     * video_img : //yd.a.yximgs.com/upic/2018/08/11/10/BMjAxODA4MTExMDI5NTJfNTk0MDQwNjQyXzc1MzgxOTk1NTBfMl8z_low_B8f1ad0a5fa761611ce03c5e58a542546.webp
     * statistics : {"zan":1094,"comment":222,"share":0,"play":154065}
     * comments : []
     * tb_link : null
     */

    private String desc;
    private String avatar;//头像路径
    private String video_url;
    private Object unique_id;
    private String nickname;//用户名
    private String short_id;
    private Object share_url;
    private String video_img;//大图路径
    private StatisticsBean statistics;
    private Object tb_link;
    private List<Object> comments;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public Object getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(Object unique_id) {
        this.unique_id = unique_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getShort_id() {
        return short_id;
    }

    public void setShort_id(String short_id) {
        this.short_id = short_id;
    }

    public Object getShare_url() {
        return share_url;
    }

    public void setShare_url(Object share_url) {
        this.share_url = share_url;
    }

    public String getVideo_img() {
        return video_img;
    }

    public void setVideo_img(String video_img) {
        this.video_img = video_img;
    }

    public StatisticsBean getStatistics() {
        return statistics;
    }

    public void setStatistics(StatisticsBean statistics) {
        this.statistics = statistics;
    }

    public Object getTb_link() {
        return tb_link;
    }

    public void setTb_link(Object tb_link) {
        this.tb_link = tb_link;
    }

    public List<?> getComments() {
        return comments;
    }

    public void setComments(List<Object> comments) {
        this.comments = comments;
    }


    public class StatisticsBean {//赞次数，分享次数，评论条目，播放次数，

        /**
         * zan : 1094
         * comment : 222
         * share : 0
         * play : 154065
         */

        private int zan;
        private int comment;
        private int share;
        private int play;

        public int getZan() {
            return zan;
        }

        public void setZan(int zan) {
            this.zan = zan;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }
    }

}
