package de.micromata.confluence.rest.core.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by cschulc on 01.07.2016.
 */
public class ProfilePictureBean {

    @Expose
    private String path;

    @Expose
    private Integer width;

    @Expose
    private Integer height;

    @Expose
    private Boolean isDefault;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
