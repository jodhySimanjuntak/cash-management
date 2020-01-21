package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubKategoriPK is a Querydsl query type for SubKategoriPK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSubKategoriPK extends BeanPath<SubKategoriPK> {

    private static final long serialVersionUID = 1332076093L;

    public static final QSubKategoriPK subKategoriPK = new QSubKategoriPK("subKategoriPK");

    public final StringPath kategoriBiaya = createString("kategoriBiaya");

    public final StringPath kodeSubKategori = createString("kodeSubKategori");

    public QSubKategoriPK(String variable) {
        super(SubKategoriPK.class, forVariable(variable));
    }

    public QSubKategoriPK(Path<? extends SubKategoriPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubKategoriPK(PathMetadata metadata) {
        super(SubKategoriPK.class, metadata);
    }

}

