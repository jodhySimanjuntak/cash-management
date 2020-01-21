package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCMSUser is a Querydsl query type for CMSUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCMSUser extends EntityPathBase<CMSUser> {

    private static final long serialVersionUID = -1521834704L;

    public static final QCMSUser cMSUser = new QCMSUser("cMSUser");

    public final NumberPath<Integer> branchId = createNumber("branchId", Integer.class);

    public final StringPath cabangId = createString("cabangId");

    public final StringPath centroId = createString("centroId");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Integer> deleted = createNumber("deleted", Integer.class);

    public final DateTimePath<java.util.Date> deletedAt = createDateTime("deletedAt", java.util.Date.class);

    public final NumberPath<Integer> districtId = createNumber("districtId", Integer.class);

    public final StringPath email = createString("email");

    public final StringPath fullname = createString("fullname");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> isActive = createNumber("isActive", Integer.class);

    public final NumberPath<Integer> localdb = createNumber("localdb", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath regionalId = createString("regionalId");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public final StringPath username = createString("username");

    public final StringPath utype = createString("utype");

    public final StringPath wilayahId = createString("wilayahId");

    public QCMSUser(String variable) {
        super(CMSUser.class, forVariable(variable));
    }

    public QCMSUser(Path<? extends CMSUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCMSUser(PathMetadata metadata) {
        super(CMSUser.class, metadata);
    }

}

