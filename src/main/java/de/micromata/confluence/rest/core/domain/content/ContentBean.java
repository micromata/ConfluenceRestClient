package de.micromata.confluence.rest.core.domain.content;

import com.google.gson.annotations.Expose;
import de.micromata.confluence.rest.core.domain.BaseBean;
import de.micromata.confluence.rest.core.domain.common.LinksBean;
import de.micromata.confluence.rest.core.domain.space.SpaceBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Christian Schulze (c.schulze@micromata.de)
 * Date: 04.07.2016
 * Project: ConfluenceTransferPlugin
 */
public class ContentBean extends BaseBean {

    @Expose
    private String status;

    @Expose
    private String title;

    @Expose
    private SpaceBean space;

    @Expose
    private VersionBean version;

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
    private ContainerBean container;

    @Expose
    private BodyBean body;

    @Expose
    private MetadataBean metadata;

    @Expose
    private RestrictionsBean restrictions;

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

    public VersionBean getVersion() {
        return version;
    }

    public void setVersion(VersionBean version) {
        this.version = version;
    }
}
