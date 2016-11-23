package com.king.entity;

import java.util.List;

/**
 * Jokes实体类
 * Created by Administrator on 2016/11/21.
 */

public class JokesEntity {

    /**
     *
     * total : 694
     * page : 1
     * refresh : 134
     */

    private int count;
    private HhBean hh;
    private int err;
    private int total;
    private int page;
    private int refresh;
    private List<ItemsBean> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HhBean getHh() {
        return hh;
    }

    public void setHh(HhBean hh) {
        this.hh = hh;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class HhBean {
        /**
         * content : 家有母金毛一只，每天都带出去遛弯，此为背景，，，最近打开大门，门口的地垫上总是有骨头，卫生巾，塑料袋啥的，尼玛恶心的要死，昨天在楼上开窗户时无意中发现几只小流浪狗不知道叼的啥往我家门口跑！我想问一下大神们它们这是要闹哪样，，，
         * countdown : 849699
         * illustration : http://pic.qiushibaike.com/hh/19.jpeg
         * hour : 19
         */

        private String content;
        private int countdown;
        private String illustration;
        private int hour;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getCountdown() {
            return countdown;
        }

        public void setCountdown(int countdown) {
            this.countdown = countdown;
        }

        public String getIllustration() {
            return illustration;
        }

        public void setIllustration(String illustration) {
            this.illustration = illustration;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }
    }

    public static class ItemsBean {
        /**
         * format : image
         * image : app118023132.jpg
         * published_at : 1479712502
         * tag :
         * user : {"avatar_updated_at":1417130003,"uid":15394039,"last_visited_at":1396827739,"created_at":1396827739,"state":"active","last_device":"android_2.6.3","role":"","login":"临泉单桥类","id":15394039,"icon":"20141128151324.jpg"}
         * image_size : {"s":[220,290,16679],"m":[427,563,79602]}
         * id : 118023132
         * votes : {"down":-12,"up":349}
         * created_at : 1479708162
         * content : 转个图。。
         * state : publish
         * comments_count : 7
         * allow_comment : true
         * share_count : 2
         * type : fresh
         */

        private String format;
        private String image;
        private int published_at;
        private String tag;
        private UserBean user;
        private ImageSizeBean image_size;
        private int id;
        private VotesBean votes;
        private int created_at;
        private String content;
        private String state;
        private int comments_count;
        private boolean allow_comment;
        private int share_count;
        private String type;

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getPublished_at() {
            return published_at;
        }

        public void setPublished_at(int published_at) {
            this.published_at = published_at;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public ImageSizeBean getImage_size() {
            return image_size;
        }

        public void setImage_size(ImageSizeBean image_size) {
            this.image_size = image_size;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public VotesBean getVotes() {
            return votes;
        }

        public void setVotes(VotesBean votes) {
            this.votes = votes;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public static class UserBean {
            /**
             * avatar_updated_at : 1417130003
             * uid : 15394039
             * last_visited_at : 1396827739
             * created_at : 1396827739
             * state : active
             * last_device : android_2.6.3
             * role :
             * login : 临泉单桥类
             * id : 15394039
             * icon : 20141128151324.jpg
             */

            private int avatar_updated_at;
            private int uid;
            private int last_visited_at;
            private int created_at;
            private String state;
            private String last_device;
            private String role;
            private String login;
            private int id;
            private String icon;

            public int getAvatar_updated_at() {
                return avatar_updated_at;
            }

            public void setAvatar_updated_at(int avatar_updated_at) {
                this.avatar_updated_at = avatar_updated_at;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getLast_device() {
                return last_device;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }

        public static class ImageSizeBean {
            private List<Integer> s;
            private List<Integer> m;

            public List<Integer> getS() {
                return s;
            }

            public void setS(List<Integer> s) {
                this.s = s;
            }

            public List<Integer> getM() {
                return m;
            }

            public void setM(List<Integer> m) {
                this.m = m;
            }
        }

        public static class VotesBean {
            /**
             * down : -12
             * up : 349
             */

            private int down;
            private int up;

            public int getDown() {
                return down;
            }

            public void setDown(int down) {
                this.down = down;
            }

            public int getUp() {
                return up;
            }

            public void setUp(int up) {
                this.up = up;
            }
        }
    }
}
