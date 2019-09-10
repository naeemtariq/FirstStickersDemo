package com.naeem.firststickersdemo.models;

import java.io.Serializable;
import java.util.List;

public class Sticker implements Serializable {


    /**
     * image_file : 25_Cuppy_battery.webp
     * emojis : ["🔋","😵"]
     */

    private String image_file;
    private List<String> emojis;

    public String getImage_file() {
        return image_file;
    }

    public void setImage_file(String image_file) {
        this.image_file = image_file;
    }

    public List<String> getEmojis() {
        return emojis;
    }

    public void setEmojis(List<String> emojis) {
        this.emojis = emojis;
    }
}
