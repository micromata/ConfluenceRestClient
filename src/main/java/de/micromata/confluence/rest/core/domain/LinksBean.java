package de.micromata.confluence.rest.core.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by cschulc on 01.07.2016.
 */
public class LinksBean {


    @Expose
    private String base;

    @Expose
    private String context;

    @Expose
    private String self;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }
}
