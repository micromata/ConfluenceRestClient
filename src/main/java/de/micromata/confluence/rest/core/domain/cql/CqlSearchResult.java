package de.micromata.confluence.rest.core.domain.cql;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.common.LinksBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 06.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class CqlSearchResult {

    @Expose
    private List<SearchResultBean> results = new ArrayList<>();
    @Expose
    private int start;
    @Expose
    private int limit;
    @Expose
    private int size;
    @Expose
    private int totalSize;
    @Expose
    private String cqlQuery;
    @Expose
    private int searchDuration;
    @Expose
    private LinksBean _links;

    public LinksBean get_links() {
        return _links;
    }

    public void set_links(LinksBean _links) {
        this._links = _links;
    }

    public String getCqlQuery() {
        return cqlQuery;
    }

    public void setCqlQuery(String cqlQuery) {
        this.cqlQuery = cqlQuery;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<SearchResultBean> getResults() {
        return results;
    }

    public void setResults(List<SearchResultBean> results) {
        this.results = results;
    }

    public int getSearchDuration() {
        return searchDuration;
    }

    public void setSearchDuration(int searchDuration) {
        this.searchDuration = searchDuration;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
}
