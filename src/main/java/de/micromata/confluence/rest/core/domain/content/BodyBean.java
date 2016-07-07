package de.micromata.confluence.rest.core.domain.content;

import com.google.gson.annotations.Expose;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class BodyBean {

    @Expose
    private ViewBean view;

    public ViewBean getView() {
        return view;
    }

    public void setView(ViewBean view) {
        this.view = view;
    }
}
