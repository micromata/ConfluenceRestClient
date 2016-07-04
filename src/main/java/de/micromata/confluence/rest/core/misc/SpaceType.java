package de.micromata.confluence.rest.core.misc;

/**
 * The possible Types of a Confluence, global or personal.
 *
 *
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 02.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum SpaceType {

    GLOBAL("global"), PERSONAL("personal");

    private String name;

    SpaceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
