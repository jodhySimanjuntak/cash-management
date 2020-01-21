package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRegional is a Querydsl query type for Regional
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRegional extends EntityPathBase<Regional> {

    private static final long serialVersionUID = 856310051L;

    public static final QRegional regional = new QRegional("regional");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDt = createDateTime("endDt", java.util.Date.class);

    public final StringPath idKaryawan = createString("idKaryawan");

    public final StringPath idRegional = createString("idRegional");

    public final StringPath idWilayah = createString("idWilayah");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final StringPath namaRegional = createString("namaRegional");

    public final StringPath picRegMkt = createString("picRegMkt");

    public final StringPath picRegOpr = createString("picRegOpr");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QRegional(String variable) {
        super(Regional.class, forVariable(variable));
    }

    public QRegional(Path<? extends Regional> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegional(PathMetadata metadata) {
        super(Regional.class, metadata);
    }

}

