package de.micromata.confluence.rest.core.domain.content;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.common.ExpandableBean;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class ViewBean {

    @Expose
    public String value;

    @Expose
    public String representation;

    @Expose
    public ExpandableBean expandable;

    public ExpandableBean getExpandable() {
        return expandable;
    }

    public void setExpandable(ExpandableBean expandable) {
        this.expandable = expandable;
    }

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
