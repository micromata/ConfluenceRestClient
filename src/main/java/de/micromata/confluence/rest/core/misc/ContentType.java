package de.micromata.confluence.rest.core.misc;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum ContentType {
    PAGE("page"),
    BLOGPOST("blogpost");

    String name;

    ContentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
