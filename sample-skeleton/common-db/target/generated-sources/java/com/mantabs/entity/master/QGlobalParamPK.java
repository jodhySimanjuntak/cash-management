package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGlobalParamPK is a Querydsl query type for GlobalParamPK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QGlobalParamPK extends BeanPath<GlobalParamPK> {

    private static final long serialVersionUID = -1104002655L;

    public static final QGlobalParamPK globalParamPK = new QGlobalParamPK("globalParamPK");

    public final StringPath idCondition = createString("idCondition");

    public final StringPath idParam = createString("idParam");

    public QGlobalParamPK(String variable) {
        super(GlobalParamPK.class, forVariable(variable));
    }

    public QGlobalParamPK(Path<? extends GlobalParamPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGlobalParamPK(PathMetadata metadata) {
        super(GlobalParamPK.class, metadata);
    }

}

