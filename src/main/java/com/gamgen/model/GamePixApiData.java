package com.gamgen.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class GamePixApiData {

    public String id;
    public String title;
    public Date creation;
    public boolean featured;
    public int height;
    public int width;
    public String orientation;
    public boolean responsive;
    public String author;
    public BigDecimal rkScore;
    public BigDecimal rks;
    public String thumbnailUrl;
    public String thumbnailUrl100;
    public String url;
    public boolean touch;
    public boolean hwcontrols;
    public Date lastUpdate;
    public String description;
    public String category;
    public ArrayList<String> categories;
    public String desc_it;
    public String desc_en;
    public String desc_fr;
    public String desc_de;
    public String desc_es;
    public BigDecimal size;
    public BigDecimal min_android_version;
    public BigDecimal min_ios_version;
    public BigDecimal min_wp_version;
    public Date approval_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public boolean isResponsive() {
        return responsive;
    }

    public void setResponsive(boolean responsive) {
        this.responsive = responsive;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getRkScore() {
        return rkScore;
    }

    public void setRkScore(BigDecimal rkScore) {
        this.rkScore = rkScore;
    }

    public BigDecimal getRks() {
        return rks;
    }

    public void setRks(BigDecimal rks) {
        this.rks = rks;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getThumbnailUrl100() {
        return thumbnailUrl100;
    }

    public void setThumbnailUrl100(String thumbnailUrl100) {
        this.thumbnailUrl100 = thumbnailUrl100;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isTouch() {
        return touch;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    public boolean isHwcontrols() {
        return hwcontrols;
    }

    public void setHwcontrols(boolean hwcontrols) {
        this.hwcontrols = hwcontrols;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getDesc_it() {
        return desc_it;
    }

    public void setDesc_it(String desc_it) {
        this.desc_it = desc_it;
    }

    public String getDesc_en() {
        return desc_en;
    }

    public void setDesc_en(String desc_en) {
        this.desc_en = desc_en;
    }

    public String getDesc_fr() {
        return desc_fr;
    }

    public void setDesc_fr(String desc_fr) {
        this.desc_fr = desc_fr;
    }

    public String getDesc_de() {
        return desc_de;
    }

    public void setDesc_de(String desc_de) {
        this.desc_de = desc_de;
    }

    public String getDesc_es() {
        return desc_es;
    }

    public void setDesc_es(String desc_es) {
        this.desc_es = desc_es;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getMin_android_version() {
        return min_android_version;
    }

    public void setMin_android_version(BigDecimal min_android_version) {
        this.min_android_version = min_android_version;
    }

    public BigDecimal getMin_ios_version() {
        return min_ios_version;
    }

    public void setMin_ios_version(BigDecimal min_ios_version) {
        this.min_ios_version = min_ios_version;
    }

    public BigDecimal getMin_wp_version() {
        return min_wp_version;
    }

    public void setMin_wp_version(BigDecimal min_wp_version) {
        this.min_wp_version = min_wp_version;
    }

    public Date getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(Date approval_date) {
        this.approval_date = approval_date;
    }
}
