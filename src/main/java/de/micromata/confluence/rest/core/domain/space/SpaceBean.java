package de.micromata.confluence.rest.core.domain.space;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.BaseBean;
import de.micromata.confluence.rest.core.domain.common.ExpandableBean;
import de.micromata.confluence.rest.core.domain.common.LinksBean;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 02.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class SpaceBean extends BaseBean {

    @Expose
    private String key;
    @Expose
    private String name;
    @Expose
    private DescriptionBean description;
    @Expose
    private ExpandableBean expandable;

    public DescriptionBean getDescription() {
        return description;
    }

    public void setDescription(DescriptionBean description) {
        this.description = description;
    }

    public ExpandableBean getExpandable() {
        return expandable;
    }

    public void setExpandable(ExpandableBean expandable) {
        this.expandable = expandable;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
