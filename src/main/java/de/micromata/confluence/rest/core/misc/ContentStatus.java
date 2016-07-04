package de.micromata.confluence.rest.core.misc;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public enum ContentStatus {
    ANY("any"), CURRENT("current"),TRASHED("trashed");
    String name;

    ContentStatus(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
