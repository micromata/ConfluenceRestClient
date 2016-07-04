package de.micromata.confluence.rest.core.domain.space;

import com.google.gson.annotations.Expose;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 02.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class ExpandableBean {

    @Expose
    public String metadata;

    @Expose
    public String icon;

    @Expose
    public String description;

    @Expose
    public String homepage;

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
