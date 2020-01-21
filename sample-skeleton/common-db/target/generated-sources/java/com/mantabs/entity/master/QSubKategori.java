package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubKategori is a Querydsl query type for SubKategori
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubKategori extends EntityPathBase<SubKategori> {

    private static final long serialVersionUID = -2081293118L;

    public static final QSubKategori subKategori1 = new QSubKategori("subKategori1");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final StringPath kategoriBiaya = createString("kategoriBiaya");

    public final StringPath kodeSubKategori = createString("kodeSubKategori");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final StringPath status = createString("status");

    public final StringPath subKategori = createString("subKategori");

    public QSubKategori(String variable) {
        super(SubKategori.class, forVariable(variable));
    }

    public QSubKategori(Path<? extends SubKategori> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubKategori(PathMetadata metadata) {
        super(SubKategori.class, metadata);
    }

}

