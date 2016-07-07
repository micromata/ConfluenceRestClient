package de.micromata.confluence.rest.core.domain.content;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.common.LinksBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class AncestorBean {

    @Expose
    private String id;

    @Expose
    private String type;

    @Expose
    private String status;

    @Expose
    private List<AncestorBean> ancestors = new ArrayList<>();

    @Expose
    private List<OperationBean> operations = new ArrayList<>();

    @Expose
    private ChildrenBean children;

    @Expose
    private ChildTypesBean childTypes;

    @Expose
    private DescendantsBean descendants;

    @Expose
    private BodyBean body;

    @Expose
    private MetadataBean metadata;

    @Expose
    private RestrictionsBean restrictions;

    @Expose
    private LinksBean links;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
