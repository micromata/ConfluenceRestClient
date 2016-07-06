package de.micromata.confluence.rest.core.cql;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum ExcerptStrategy {
    INDEXED("indexed"),
    HIGHLIGHT("highlight"),
    NONE("none");

    String name;

    ExcerptStrategy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
