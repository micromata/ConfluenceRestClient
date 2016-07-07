package de.micromata.confluence.rest.core.custom;

import com.google.gson.*;
import de.micromata.confluence.rest.core.domain.BaseBean;
import de.micromata.confluence.rest.core.domain.content.ContentBean;
import de.micromata.confluence.rest.core.domain.cql.CqlSearchResult;
import de.micromata.confluence.rest.core.domain.space.SpaceBean;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 07.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class CqlSearchResultDeserializer extends BaseDeserializer implements JsonDeserializer<CqlSearchResult> {

    private static final String SPACE = "space";
    private static final String CONTENT = "content";

    @Override
    public CqlSearchResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CqlSearchResult cqlSearchResult = gson.fromJson(json, CqlSearchResult.class);
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement resultsElement = jsonObject.get("results");
        JsonArray resultsArray = resultsElement.getAsJsonArray();
        List<BaseBean> baseBeen = deserializeResultsArray(resultsArray);
        cqlSearchResult.setResults(baseBeen);
        return cqlSearchResult;
    }

    private List<BaseBean> deserializeResultsArray(JsonArray results) {
        List<BaseBean> retval = new ArrayList<>();
        for (JsonElement result : results) {
            JsonObject jsonObject = result.getAsJsonObject();
            if (jsonObject.has("content") == true) {
                JsonElement content = jsonObject.get(CONTENT);
                ContentBean contentBean = gson.fromJson(content, ContentBean.class);
                retval.add(contentBean);
            } else if (jsonObject.has("space") == true) {
                JsonElement space = jsonObject.get(SPACE);
                SpaceBean spaceBean = gson.fromJson(space, SpaceBean.class);
                retval.add(spaceBean);
            } else {
                // nothing
            }
        }
        return retval;
    }

}
