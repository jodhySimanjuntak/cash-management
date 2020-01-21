package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QWilayah is a Querydsl query type for Wilayah
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWilayah extends EntityPathBase<Wilayah> {

    private static final long serialVersionUID = -126562891L;

    public static final QWilayah wilayah = new QWilayah("wilayah");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final StringPath endDt = createString("endDt");

    public final StringPath idKaryawan = createString("idKaryawan");

    public final StringPath idWilayah = createString("idWilayah");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final StringPath namaWilayah = createString("namaWilayah");

    public final StringPath picRegMkt = createString("picRegMkt");

    public final StringPath picRegOpr = createString("picRegOpr");

    public final StringPath picWilayahMkt = createString("picWilayahMkt");

    public final StringPath picWilayahOpr = createString("picWilayahOpr");

    public final StringPath status = createString("status");

    public QWilayah(String variable) {
        super(Wilayah.class, forVariable(variable));
    }

    public QWilayah(Path<? extends Wilayah> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWilayah(PathMetadata metadata) {
        super(Wilayah.class, metadata);
    }

}

