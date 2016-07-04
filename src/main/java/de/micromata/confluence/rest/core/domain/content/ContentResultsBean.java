package de.micromata.confluence.rest.core.domain.content;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.BaseBean;
import de.micromata.confluence.rest.core.domain.common.LinksBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class ContentResultsBean extends BaseBean {

    @Expose
    public List<ContentBean> results = new ArrayList<>();
    @Expose
    public Integer start;
    @Expose
    public Integer limit;
    @Expose
    public Integer size;
    @Expose
    public LinksBean _links;

    public LinksBean get_links() {
        return _links;
    }

    public void set_links(LinksBean _links) {
        this._links = _links;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<ContentBean> getResults() {
        return results;
    }

    public void setResults(List<ContentBean> results) {
        this.results = results;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }
}
