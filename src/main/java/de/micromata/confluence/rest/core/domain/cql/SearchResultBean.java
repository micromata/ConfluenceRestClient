package de.micromata.confluence.rest.core.domain.cql;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.content.ContentBean;
import de.micromata.confluence.rest.core.domain.space.SpaceBean;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 06.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class SearchResultBean {

    @Expose
    private SpaceBean space;

    @Expose
    private ContentBean content;

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public SpaceBean getSpace() {
        return space;
    }

    public void setSpace(SpaceBean space) {
        this.space = space;
    }
}
