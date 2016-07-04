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
    public String id;

    @Expose
    public String type;

    @Expose
    public String status;

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
    public BodyBean body;

    @Expose
    public MetadataBean metadata;

    @Expose
    public RestrictionsBean restrictions;

    @Expose
    public LinksBean links;
}
