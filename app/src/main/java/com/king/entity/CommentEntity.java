package com.king.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class CommentEntity {

    /**
     * count : 50
     * items :
     * total : 103
     * page : 1
     * err : 0
     */

    private int count;
    private int total;
    private int page;
    private int err;
    private List<ItemsBean> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * content : 回复 102楼：是的，这才算是真爱。
         * parent_id : 368770553
         * liked : true
         * like_count : 0
         * at_infos : {}
         * floor : 103
         * created_at : 1480059679
         * refer :
         * id : 368770598
         * user :
         */

        private String content;
        private int parent_id;
        private boolean liked;
        private int like_count;
        private AtInfosBean at_infos;
        private int floor;
        private int created_at;
        private ReferBean refer;
        private int id;
        private UserBeanX user;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public AtInfosBean getAt_infos() {
            return at_infos;
        }

        public void setAt_infos(AtInfosBean at_infos) {
            this.at_infos = at_infos;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getCreated_at() {
            return created_at;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public ReferBean getRefer() {
            return refer;
        }

        public void setRefer(ReferBean refer) {
            this.refer = refer;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public UserBeanX getUser() {
            return user;
        }

        public void setUser(UserBeanX user) {
            this.user = user;
        }

        public static class AtInfosBean {
        }

        public static class ReferBean {
            /**
             * content : 回复 1楼：这样的女人才是当今的典范
             * parent_id : 368757980
             * like_count : 0
             * at_infos : {}
             * floor : 102
             * created_at : 1480059623
             * id : 368770553
             * user :
             */

            private String content;
            private int parent_id;
            private int like_count;
            private AtInfosBeanX at_infos;
            private int floor;
            private int created_at;
            private int id;
            private UserBean user;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getParent_id() {
                return parent_id;
            }

            public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
            }

            public int getLike_count() {
                return like_count;
            }

            public void setLike_count(int like_count) {
                this.like_count = like_count;
            }

            public AtInfosBeanX getAt_infos() {
                return at_infos;
            }

            public void setAt_infos(AtInfosBeanX at_infos) {
                this.at_infos = at_infos;
            }

            public int getFloor() {
                return floor;
            }

            public void setFloor(int floor) {
                this.floor = floor;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class AtInfosBeanX {
            }

            public static class UserBean {
                /**
                 * last_visited_at : 1441084576
                 * created_at : 1441084576
                 * last_device : ios_7.3.2
                 * state : active
                 * role : n
                 * login : 漫漫人生路:
                 * id : 30207972
                 * icon : 20150901131616.jpg
                 */

                private int last_visited_at;
                private int created_at;
                private String last_device;
                private String state;
                private String role;
                private String login;
                private int id;
                private String icon;

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

                public String getLast_device() {
                    return last_device;
                }

                public void setLast_device(String last_device) {
                    this.last_device = last_device;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
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

        public static class UserBeanX {
            /**
             * last_visited_at : 1428450721
             * created_at : 1428450721
             * last_device : android_6.5.0
             * state : active
             * role : n
             * login : 魔鬼中的败类
             * id : 27415520
             * icon : 2016092719221292.JPEG
             */

            private int last_visited_at;
            private int created_at;
            private String last_device;
            private String state;
            private String role;
            private String login;
            private int id;
            private String icon;

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

            public String getLast_device() {
                return last_device;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
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
