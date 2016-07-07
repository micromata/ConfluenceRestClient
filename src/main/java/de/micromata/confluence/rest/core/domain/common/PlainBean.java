package de.micromata.confluence.rest.core.domain.common;

import com.google.gson.annotations.Expose;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class PlainBean {

    @Expose
    private String value;
    @Expose
    private String representation;

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
