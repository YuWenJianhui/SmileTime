package com.king.entity;

/**
 * Description： xxx<br/>
 * Copyright (c)   2016,  Jansonxu <br/>
 * This program is protected by copyright laws <br/>
 *
 * @author 宇文
 * @version : 1.0
 */
public class Lives {

        private int status;
        private Author author;
        private String update_at;
        private String created_at;
        private Share share;
        private int accumulated_count;
        private String content;
        private String thumbnail_url;
        private long room_id;
        private String location;
        private String hdl_live_url;
        private int visitors_count;
        private long id;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }


        public String getUpdate_at() {
            return update_at;
        }

        public void setUpdate_at(String update_at) {
            this.update_at = update_at;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }


        public Share getShare() {
            return share;
        }

        public void setShare(Share share) {
            this.share = share;
        }

        public int getAccumulated_count() {
            return accumulated_count;
        }

        public void setAccumulated_count(int accumulated_count) {
            this.accumulated_count = accumulated_count;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }


        public String getThumbnail_url() {
            return thumbnail_url;
        }

        public void setThumbnail_url(String thumbnail_url) {
            this.thumbnail_url = thumbnail_url;
        }

        public long getRoom_id() {
            return room_id;
        }

        public void setRoom_id(long room_id) {
            this.room_id = room_id;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getHdl_live_url() {
            return hdl_live_url;
        }

        public void setHdl_live_url(String hdl_live_url) {
            this.hdl_live_url = hdl_live_url;
        }

        public int getVisitors_count() {
            return visitors_count;
        }

        public void setVisitors_count(int visitors_count) {
            this.visitors_count = visitors_count;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

}
