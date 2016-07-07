package de.micromata.confluence.rest.core.domain.space;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.common.LinksBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 02.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class SpaceResultsBean {

    @Expose
    private List<SpaceBean> results = new ArrayList<SpaceBean>();
    @Expose
    private Integer start;
    @Expose
    private Integer limit;
    @Expose
    private Integer size;
    @Expose
    private LinksBean links;

    public List<SpaceBean> getResults() {
        return results;
    }

    public void setResults(List<SpaceBean> results) {
        this.results = results;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }
}
