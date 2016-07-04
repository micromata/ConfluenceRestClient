package de.micromata.confluence.rest.core.domain.space;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.common.PlainBean;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class DescriptionBean {

    @Expose
    public PlainBean plain;

    public PlainBean getPlain() {
        return plain;
    }

    public void setPlain(PlainBean plain) {
        this.plain = plain;
    }
}
