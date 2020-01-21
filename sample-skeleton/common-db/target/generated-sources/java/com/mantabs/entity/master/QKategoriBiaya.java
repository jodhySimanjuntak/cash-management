package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QKategoriBiaya is a Querydsl query type for KategoriBiaya
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QKategoriBiaya extends EntityPathBase<KategoriBiaya> {

    private static final long serialVersionUID = -1412962120L;

    public static final QKategoriBiaya kategoriBiaya1 = new QKategoriBiaya("kategoriBiaya1");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final StringPath kategoriBiaya = createString("kategoriBiaya");

    public final StringPath kodeKategoriBiaya = createString("kodeKategoriBiaya");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final StringPath status = createString("status");

    public QKategoriBiaya(String variable) {
        super(KategoriBiaya.class, forVariable(variable));
    }

    public QKategoriBiaya(Path<? extends KategoriBiaya> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKategoriBiaya(PathMetadata metadata) {
        super(KategoriBiaya.class, metadata);
    }

}

