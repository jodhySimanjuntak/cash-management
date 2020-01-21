package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJenisBiayaCM is a Querydsl query type for JenisBiayaCM
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJenisBiayaCM extends EntityPathBase<JenisBiayaCM> {

    private static final long serialVersionUID = 966434995L;

    public static final QJenisBiayaCM jenisBiayaCM = new QJenisBiayaCM("jenisBiayaCM");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final StringPath jenisBiaya = createString("jenisBiaya");

    public final StringPath kategoriBiaya = createString("kategoriBiaya");

    public final StringPath kodeJenisBiaya = createString("kodeJenisBiaya");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final StringPath status = createString("status");

    public final StringPath subKategori = createString("subKategori");

    public QJenisBiayaCM(String variable) {
        super(JenisBiayaCM.class, forVariable(variable));
    }

    public QJenisBiayaCM(Path<? extends JenisBiayaCM> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJenisBiayaCM(PathMetadata metadata) {
        super(JenisBiayaCM.class, metadata);
    }

}

