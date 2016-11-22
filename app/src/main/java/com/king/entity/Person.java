package com.king.entity;

import java.util.List;

/**
 * Description： xxx<br/>
 * Copyright (c)   2016,  Jansonxu <br/>
 * This program is protected by copyright laws <br/>
 *
 * @author 宇文
 * @version : 1.0
 */
public class Person {
    private List<Banners> banners;
    private List<Lives> lives;

    public List<Banners> getBanners() {
        return banners;
    }

    public void setBanners(List<Banners> banners) {
        this.banners = banners;
    }

    public List<Lives> getLives() {
        return lives;
    }

    public void setLives(List<Lives> lives) {
        this.lives = lives;
    }

}
