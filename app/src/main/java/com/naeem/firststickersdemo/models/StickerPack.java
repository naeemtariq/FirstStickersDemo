package com.naeem.firststickersdemo.models;

import java.io.Serializable;
import java.util.List;

public class StickerPack implements Serializable {

    /**
     * identifier : 1
     * name : Cuppy
     * publisher : Jane Doe
     * tray_image_file : tray_Cuppy.png
     * image_data_version : 1
     * avoid_cache : false
     * publisher_email :
     * publisher_website :
     * privacy_policy_website :
     * license_agreement_website :
     * stickers : [{"image_file":"01_Cuppy_smile.webp","emojis":["☕","🙂"]},{"image_file":"02_Cuppy_lol.webp","emojis":["😄","😀"]},{"image_file":"03_Cuppy_rofl.webp","emojis":["😆","😂"]},{"image_file":"04_Cuppy_sad.webp","emojis":["😩","😰"]},{"image_file":"05_Cuppy_cry.webp","emojis":["😭","💧"]},{"image_file":"06_Cuppy_love.webp","emojis":["😍","♥"]},{"image_file":"07_Cuppy_hate.webp","emojis":["💔","👎"]},{"image_file":"08_Cuppy_lovewithmug.webp","emojis":["😍","💑"]},{"image_file":"09_Cuppy_lovewithcookie.webp","emojis":["😘","🍪"]},{"image_file":"10_Cuppy_hmm.webp","emojis":["🤔","😐"]},{"image_file":"11_Cuppy_upset.webp","emojis":["😱","😵"]},{"image_file":"12_Cuppy_angry.webp","emojis":["😡","😠"]},{"image_file":"13_Cuppy_curious.webp","emojis":["❓","🤔"]},{"image_file":"14_Cuppy_weird.webp","emojis":["🌈","😜"]},{"image_file":"15_Cuppy_bluescreen.webp","emojis":["💻","😩"]},{"image_file":"16_Cuppy_angry.webp","emojis":["😡","😤"]},{"image_file":"17_Cuppy_tired.webp","emojis":["😩","😨"]},{"image_file":"18_Cuppy_workhard.webp","emojis":["💻","🌃"]},{"image_file":"19_Cuppy_shine.webp","emojis":["🎉","✨"]},{"image_file":"20_Cuppy_disgusting.webp","emojis":["🤮","👎"]},{"image_file":"21_Cuppy_hi.webp","emojis":["🖐","🙋"]},{"image_file":"22_Cuppy_bye.webp","emojis":["🖐","👋"]},{"image_file":"23_Cuppy_greentea.webp","emojis":["🍵","😌"]},{"image_file":"24_Cuppy_phone.webp","emojis":["📱","😦"]},{"image_file":"25_Cuppy_battery.webp","emojis":["🔋","😵"]}]
     */

    private String identifier;
    private String name;
    private String publisher;
    private String tray_image_file;
    private String image_data_version;
    private boolean avoid_cache;
    private String publisher_email;
    private String publisher_website;
    private String privacy_policy_website;
    private String license_agreement_website;
    private List<Sticker> stickers;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTray_image_file() {
        return tray_image_file;
    }

    public void setTray_image_file(String tray_image_file) {
        this.tray_image_file = tray_image_file;
    }

    public String getImage_data_version() {
        return image_data_version;
    }

    public void setImage_data_version(String image_data_version) {
        this.image_data_version = image_data_version;
    }

    public boolean isAvoid_cache() {
        return avoid_cache;
    }

    public void setAvoid_cache(boolean avoid_cache) {
        this.avoid_cache = avoid_cache;
    }

    public String getPublisher_email() {
        return publisher_email;
    }

    public void setPublisher_email(String publisher_email) {
        this.publisher_email = publisher_email;
    }

    public String getPublisher_website() {
        return publisher_website;
    }

    public void setPublisher_website(String publisher_website) {
        this.publisher_website = publisher_website;
    }

    public String getPrivacy_policy_website() {
        return privacy_policy_website;
    }

    public void setPrivacy_policy_website(String privacy_policy_website) {
        this.privacy_policy_website = privacy_policy_website;
    }

    public String getLicense_agreement_website() {
        return license_agreement_website;
    }

    public void setLicense_agreement_website(String license_agreement_website) {
        this.license_agreement_website = license_agreement_website;
    }

    public List<Sticker> getStickers() {
        return stickers;
    }

    public void setStickers(List<Sticker> stickers) {
        this.stickers = stickers;
    }
}
