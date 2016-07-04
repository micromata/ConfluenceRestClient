package de.micromata.confluence.rest.core.misc;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum ExpandField {
    SPACE("space"),
    BODY_VIEW("body.view"),
    VERSION("version"),
    CONTAINER("container"),
    HISTORY("history"),
    CHILDREN("children"),
    OPERATIONS("operations"),
    DESCENDANTS("descendants"),
    ANCESTORS("ancestors"),
    RESTRICTIONS("restrictions");

    String name;

    ExpandField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
