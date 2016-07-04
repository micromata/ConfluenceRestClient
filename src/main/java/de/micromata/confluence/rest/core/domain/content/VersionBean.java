package de.micromata.confluence.rest.core.domain.content;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.UserBean;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class VersionBean {

    @Expose
    public UserBean by;
    @Expose
    public String when;
    @Expose
    public String message;
    @Expose
    public Integer number;
    @Expose
    public Boolean minorEdit;

    public UserBean getBy() {
        return by;
    }

    public void setBy(UserBean by) {
        this.by = by;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getMinorEdit() {
        return minorEdit;
    }

    public void setMinorEdit(Boolean minorEdit) {
        this.minorEdit = minorEdit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }
}
