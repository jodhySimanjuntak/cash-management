package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGlobalParam is a Querydsl query type for GlobalParam
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGlobalParam extends EntityPathBase<GlobalParam> {

    private static final long serialVersionUID = -1064834778L;

    public static final QGlobalParam globalParam = new QGlobalParam("globalParam");

    public final StringPath charValues = createString("charValues");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateTo = createDateTime("dateTo", java.util.Date.class);

    public final DateTimePath<java.util.Date> dateValues = createDateTime("dateValues", java.util.Date.class);

    public final StringPath idCondition = createString("idCondition");

    public final StringPath idParam = createString("idParam");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final StringPath namaParam = createString("namaParam");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QGlobalParam(String variable) {
        super(GlobalParam.class, forVariable(variable));
    }

    public QGlobalParam(Path<? extends GlobalParam> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGlobalParam(PathMetadata metadata) {
        super(GlobalParam.class, metadata);
    }

}

