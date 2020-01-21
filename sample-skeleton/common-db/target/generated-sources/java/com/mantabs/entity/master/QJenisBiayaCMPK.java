package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJenisBiayaCMPK is a Querydsl query type for JenisBiayaCMPK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QJenisBiayaCMPK extends BeanPath<JenisBiayaCMPK> {

    private static final long serialVersionUID = 1031096814L;

    public static final QJenisBiayaCMPK jenisBiayaCMPK = new QJenisBiayaCMPK("jenisBiayaCMPK");

    public final StringPath kategoriBiaya = createString("kategoriBiaya");

    public final StringPath kodeJenisBiaya = createString("kodeJenisBiaya");

    public final StringPath subKategori = createString("subKategori");

    public QJenisBiayaCMPK(String variable) {
        super(JenisBiayaCMPK.class, forVariable(variable));
    }

    public QJenisBiayaCMPK(Path<? extends JenisBiayaCMPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJenisBiayaCMPK(PathMetadata metadata) {
        super(JenisBiayaCMPK.class, metadata);
    }

}

