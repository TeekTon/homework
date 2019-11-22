package cn.teek.wechat.model;

import java.util.List;

/**
 * 朋友圈推文对应实体类
 */
public class TweetBean {

    @Override
    public String toString() {
        return "TweetBean{" +
                "content='" + content + '\'' +
                ", sender=" + sender +
                ", images=" + images +
                ", comments=" + comments +
                '}';
    }

    /**
     * content : 沙发！
     * images : [{"url":"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRDy7HZaHxn15wWj6pXE4uMKAqHTC_uBgBlIzeeQSj2QaGgUzUmHg"},{"url":"https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTlJRALAf-76JPOLohBKzBg8Ab4Q5pWeQhF5igSfBflE_UYbqu7"},{"url":"http://i.ytimg.com/vi/rGWI7mjmnNk/hqdefault.jpg"}]
     * sender : {"username":"jport","nick":"Joe Portman","avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w"}
     * comments : [{"content":"Good.","sender":{"username":"outman","nick":"Super hero","avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w"}},{"content":"Like it too","sender":{"username":"inman","nick":"Doggy Over","avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w"}}]
     */

    //文字内容
    private String content;
    //发送人信息
    private SenderEntity sender;
    //图片内容
    private List<ImagesEntity> images;
    //评论
    private List<CommentsEntity> comments;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SenderEntity getSender() {
        return sender;
    }

    public void setSender(SenderEntity sender) {
        this.sender = sender;
    }

    public List<ImagesEntity> getImages() {
        return images;
    }

    public void setImages(List<ImagesEntity> images) {
        this.images = images;
    }

    public List<CommentsEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentsEntity> comments) {
        this.comments = comments;
    }

    public static class SenderEntity {
        /**
         * username : jport
         * nick : Joe Portman
         * avatar : https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w
         */

        //用户名
        private String username;
        //昵称
        private String nick;
        //头像
        private String avatar;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }

    public static class ImagesEntity {
        /**
         * url : https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRDy7HZaHxn15wWj6pXE4uMKAqHTC_uBgBlIzeeQSj2QaGgUzUmHg
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class CommentsEntity {
        /**
         * content : Good.
         * sender : {"username":"outman","nick":"Super hero","avatar":"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRJm8UXZ0mYtjv1a48RKkFkdyd4kOWLJB0o_l7GuTS8-q8VF64w"}
         */

        //评论内容
        private String content;
        //评论发起者信息
        private SenderEntity sender;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public SenderEntity getSender() {
            return sender;
        }

        public void setSender(SenderEntity sender) {
            this.sender = sender;
        }

    }
}
