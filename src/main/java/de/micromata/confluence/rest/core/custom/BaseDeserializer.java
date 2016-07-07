package de.micromata.confluence.rest.core.custom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 07.07.2016
 * Project: ConfluenceTransferPlugin
 */
public abstract class BaseDeserializer {

    protected Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
}
