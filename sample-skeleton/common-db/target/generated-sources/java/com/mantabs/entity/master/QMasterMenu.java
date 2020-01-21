package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMasterMenu is a Querydsl query type for MasterMenu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMasterMenu extends EntityPathBase<MasterMenu> {

    private static final long serialVersionUID = -1769014043L;

    public static final QMasterMenu masterMenu = new QMasterMenu("masterMenu");

    public final StringPath createdBy = createString("createdBy");

    public final StringPath createdByDatetime = createString("createdByDatetime");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final StringPath modifiedDatetime = createString("modifiedDatetime");

    public final StringPath moduleName = createString("moduleName");

    public final NumberPath<Integer> orderNo = createNumber("orderNo", Integer.class);

    public final StringPath pageName = createString("pageName");

    public final StringPath pageTitle = createString("pageTitle");

    public final StringPath parentPageName = createString("parentPageName");

    public final StringPath status = createString("status");

    public final StringPath uri = createString("uri");

    public QMasterMenu(String variable) {
        super(MasterMenu.class, forVariable(variable));
    }

    public QMasterMenu(Path<? extends MasterMenu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMasterMenu(PathMetadata metadata) {
        super(MasterMenu.class, metadata);
    }

}

