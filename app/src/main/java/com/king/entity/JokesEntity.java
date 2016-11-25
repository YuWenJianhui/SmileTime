package com.king.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Jokes实体类
 * Created by Administrator on 2016/11/21.
 */

public class JokesEntity implements Serializable {

    /**
     * count : 30
     * err : 0
     * items :
     * total : 1000
     * page : 1
     * refresh : 166
     */

    private int count;
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

    public static class ItemsBean {


        private String high_url;
        private String format;
        private Object image;
        private int published_at;
        private String tag;
        private UserBean user;
        private ImageSizeBean image_size;
        private int id;
        private VotesBean votes;
        private int created_at;
        private String pic_url;
        private String content;
        private String state;



        private int comments_count;
        private String low_url;
        private boolean allow_comment;
        private int share_count;
        private String type;
        private int loop;
        private HotCommentBean hot_comment;
        private List<Integer> pic_size;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ItemsBean itemsBean = (ItemsBean) o;

            return content != null ? content.equals(itemsBean.content) : itemsBean.content == null;

        }

        @Override
        public int hashCode() {
            return content != null ? content.hashCode() : 0;
        }

        public String getHigh_url() {
            return high_url;
        }

        public void setHigh_url(String high_url) {
            this.high_url = high_url;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
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

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
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

        public String getLow_url() {
            return low_url;
        }

        public void setLow_url(String low_url) {
            this.low_url = low_url;
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

        public int getLoop() {
            return loop;
        }

        public void setLoop(int loop) {
            this.loop = loop;
        }

        public HotCommentBean getHot_comment() {
            return hot_comment;
        }

        public void setHot_comment(HotCommentBean hot_comment) {
            this.hot_comment = hot_comment;
        }

        public List<Integer> getPic_size() {
            return pic_size;
        }

        public void setPic_size(List<Integer> pic_size) {
            this.pic_size = pic_size;
        }

        public static class UserBean {
            /**
             * avatar_updated_at : 1479220674
             * uid : 32973881
             * last_visited_at : 1479220673
             * created_at : 1479220673
             * state : active
             * last_device : ios_10.5.7
             * role :
             * login : 大表哥DBG886
             * id : 32973881
             * icon : 2016111522375395.JPEG
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
             * down : -71
             * up : 2080
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

        public static class HotCommentBean {
            /**
             * status : publish
             * user_id : 14212763
             * score : null
             * floor : 7
             * ip : 113.115.144.167
             * created_at : 2016-11-13 13:33:43
             * comment_id : 368152836
             * pos : 0
             * content : 请告诉我她的联系方式，如果她未嫁我就娶了她。
             * source : android
             * like_count : 945
             * parent_id : 0
             * anonymous : 0
             * neg : 0
             * article_id : 117966413
             * user : {"avatar_updated_at":1479229506,"uid":14212763,"last_visited_at":1392596128,"created_at":1392596128,"state":"active","last_device":"android_2.7","role":"","login":"我稀里糊涂的活着","id":14212763,"icon":"2016111601050649.JPEG"}
             */

            private String status;
            private int user_id;
            private Object score;
            private int floor;
            private String ip;
            private String created_at;
            private int comment_id;
            private int pos;
            private String content;
            private String source;
            private int like_count;
            private int parent_id;
            private int anonymous;
            private int neg;
            private int article_id;
            private UserBeanX user;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public Object getScore() {
                return score;
            }

            public void setScore(Object score) {
                this.score = score;
            }

            public int getFloor() {
                return floor;
            }

            public void setFloor(int floor) {
                this.floor = floor;
            }

            public String getIp() {
                return ip;
            }

            public void setIp(String ip) {
                this.ip = ip;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public int getComment_id() {
                return comment_id;
            }

            public void setComment_id(int comment_id) {
                this.comment_id = comment_id;
            }

            public int getPos() {
                return pos;
            }

            public void setPos(int pos) {
                this.pos = pos;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public int getAnonymous() {
                return anonymous;
            }

            public void setAnonymous(int anonymous) {
                this.anonymous = anonymous;
            }

            public int getNeg() {
                return neg;
            }

            public void setNeg(int neg) {
                this.neg = neg;
            }

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public UserBeanX getUser() {
                return user;
            }

            public void setUser(UserBeanX user) {
                this.user = user;
            }

            public static class UserBeanX {
                /**
                 * avatar_updated_at : 1479229506
                 * uid : 14212763
                 * last_visited_at : 1392596128
                 * created_at : 1392596128
                 * state : active
                 * last_device : android_2.7
                 * role :
                 * login : 我稀里糊涂的活着
                 * id : 14212763
                 * icon : 2016111601050649.JPEG
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
        }
    }
}
