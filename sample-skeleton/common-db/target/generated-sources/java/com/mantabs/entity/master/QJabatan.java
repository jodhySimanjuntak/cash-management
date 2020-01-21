package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJabatan is a Querydsl query type for Jabatan
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJabatan extends EntityPathBase<Jabatan> {

    private static final long serialVersionUID = 982517927L;

    public static final QJabatan jabatan = new QJabatan("jabatan");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDt = createDateTime("endDt", java.util.Date.class);

    public final StringPath idJabatan = createString("idJabatan");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final StringPath namaJabatan = createString("namaJabatan");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QJabatan(String variable) {
        super(Jabatan.class, forVariable(variable));
    }

    public QJabatan(Path<? extends Jabatan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJabatan(PathMetadata metadata) {
        super(Jabatan.class, metadata);
    }

}

