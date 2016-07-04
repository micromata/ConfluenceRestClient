package de.micromata.confluence.rest.core.domain.content;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.common.LinksBean;
import de.micromata.confluence.rest.core.domain.space.SpaceBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class ContentBean {

    @Expose
    public String id;

    @Expose
    public String type;

    @Expose
    public String status;

    @Expose
    public String title;

    @Expose
    public SpaceBean space;

    @Expose
    public VersionBean version;

    @Expose
    public List<AncestorBean> ancestors = new ArrayList<>();

    @Expose
    public List<OperationBean> operations = new ArrayList<>();

    @Expose
    public ChildrenBean children;

    @Expose
    public ChildTypesBean childTypes;

    @Expose
    public DescendantsBean descendants;

    @Expose
    public ContainerBean container;

    @Expose
    public BodyBean body;

    @Expose
    public MetadataBean metadata;

    @Expose
    public RestrictionsBean restrictions;

    @Expose
    public LinksBean links;

    public List<AncestorBean> getAncestors() {
        return ancestors;
    }

    public void setAncestors(List<AncestorBean> ancestors) {
        this.ancestors = ancestors;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public ChildrenBean getChildren() {
        return children;
    }

    public void setChildren(ChildrenBean children) {
        this.children = children;
    }

    public ChildTypesBean getChildTypes() {
        return childTypes;
    }

    public void setChildTypes(ChildTypesBean childTypes) {
        this.childTypes = childTypes;
    }

    public ContainerBean getContainer() {
        return container;
    }

    public void setContainer(ContainerBean container) {
        this.container = container;
    }

    public DescendantsBean getDescendants() {
        return descendants;
    }

    public void setDescendants(DescendantsBean descendants) {
        this.descendants = descendants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public MetadataBean getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataBean metadata) {
        this.metadata = metadata;
    }

    public List<OperationBean> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationBean> operations) {
        this.operations = operations;
    }

    public RestrictionsBean getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(RestrictionsBean restrictions) {
        this.restrictions = restrictions;
    }

    public SpaceBean getSpace() {
        return space;
    }

    public void setSpace(SpaceBean space) {
        this.space = space;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public VersionBean getVersion() {
        return version;
    }

    public void setVersion(VersionBean version) {
        this.version = version;
    }
}
