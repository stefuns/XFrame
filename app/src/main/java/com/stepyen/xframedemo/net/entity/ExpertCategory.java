package com.stepyen.xframedemo.net.entity;

/**
 * date：2019-05-25
 * author：stepyen
 * description：
 */
public class ExpertCategory {


    /**
     * catId : 512
     * catCode : qxyl
     * description :
     * catName : 情绪压力
     */

    private int catId;
    private String catCode;
    private String description;
    private String catName;

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
