package de.micromata.confluence.rest.core.misc;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 02.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum SpaceStatus {

    CURRENT("current"), ARCHIVED("archived");

    private String name;

    SpaceStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
