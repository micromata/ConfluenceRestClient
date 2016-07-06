package de.micromata.confluence.rest.core.cql;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 06.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum SortOrder {

    ASC("asc"), DESC("desc");

    private String order;

    SortOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return this.order;
    }
}
