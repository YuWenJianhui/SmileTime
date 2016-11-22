package com.king.entity;

/**
 * Description： xxx<br/>
 * Copyright (c)   2016,  Jansonxu <br/>
 * This program is protected by copyright laws <br/>
 *
 * @author 宇文
 * @version : 1.0
 */
public class Author {

        private int origin;
        private String name;
        private String gender;
        private String intro;
        private boolean is_follow;
        private int nick_id;
        private long id;
        private String headurl;

        public int getOrigin() {
            return origin;
        }

        public void setOrigin(int origin) {
            this.origin = origin;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public boolean isIs_follow() {
            return is_follow;
        }

        public void setIs_follow(boolean is_follow) {
            this.is_follow = is_follow;
        }

        public int getNick_id() {
            return nick_id;
        }

        public void setNick_id(int nick_id) {
            this.nick_id = nick_id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getHeadurl() {
            return headurl;
        }

        public void setHeadurl(String headurl) {
            this.headurl = headurl;
        }

}
