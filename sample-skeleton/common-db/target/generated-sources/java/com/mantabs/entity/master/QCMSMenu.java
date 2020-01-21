package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCMSMenu is a Querydsl query type for CMSMenu
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCMSMenu extends EntityPathBase<CMSMenu> {

    private static final long serialVersionUID = -1522086204L;

    public static final QCMSMenu cMSMenu = new QCMSMenu("cMSMenu");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Integer> deleted = createNumber("deleted", Integer.class);

    public final DateTimePath<java.util.Date> deletedAt = createDateTime("deletedAt", java.util.Date.class);

    public final StringPath description = createString("description");

    public final StringPath iconUrl = createString("iconUrl");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> isActive = createNumber("isActive", Integer.class);

    public final StringPath label = createString("label");

    public final NumberPath<Integer> menuOrder = createNumber("menuOrder", Integer.class);

    public final StringPath menuType = createString("menuType");

    public final StringPath menuUrl = createString("menuUrl");

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final NumberPath<Integer> permissionId = createNumber("permissionId", Integer.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QCMSMenu(String variable) {
        super(CMSMenu.class, forVariable(variable));
    }

    public QCMSMenu(Path<? extends CMSMenu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCMSMenu(PathMetadata metadata) {
        super(CMSMenu.class, metadata);
    }

}

