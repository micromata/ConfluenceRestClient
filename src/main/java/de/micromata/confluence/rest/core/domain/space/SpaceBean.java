package de.micromata.confluence.rest.core.domain.space;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.LinksBean;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 02.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class SpaceBean {

    @Expose
    public Integer id;
    @Expose
    public String key;
    @Expose
    public String name;
    @Expose
    public String type;
    @Expose
    public LinksBean links;
    @Expose
    public ExpandableBean expandable;

    public ExpandableBean getExpandable() {
        return expandable;
    }

    public void setExpandable(ExpandableBean expandable) {
        this.expandable = expandable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
