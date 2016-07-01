package de.micromata.confluence.rest.core.domain;

import com.google.gson.annotations.Expose;

/**
 * Created by cschulc on 01.07.2016.
 */
public class UserBean {

    @Expose
    private String type;

    @Expose
    private String username;

    @Expose
    private String userKey;

    @Expose
    private ProfilePictureBean profilePicture;

    @Expose
    private String displayName;

    @Expose
    private LinksBean links;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public ProfilePictureBean getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ProfilePictureBean profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }
}
