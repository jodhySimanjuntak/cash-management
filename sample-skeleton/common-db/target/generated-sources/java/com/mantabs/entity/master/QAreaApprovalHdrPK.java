package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAreaApprovalHdrPK is a Querydsl query type for AreaApprovalHdrPK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAreaApprovalHdrPK extends BeanPath<AreaApprovalHdrPK> {

    private static final long serialVersionUID = -1802475299L;

    public static final QAreaApprovalHdrPK areaApprovalHdrPK = new QAreaApprovalHdrPK("areaApprovalHdrPK");

    public final StringPath groupApproval = createString("groupApproval");

    public final StringPath kodeAreaApproval = createString("kodeAreaApproval");

    public QAreaApprovalHdrPK(String variable) {
        super(AreaApprovalHdrPK.class, forVariable(variable));
    }

    public QAreaApprovalHdrPK(Path<? extends AreaApprovalHdrPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAreaApprovalHdrPK(PathMetadata metadata) {
        super(AreaApprovalHdrPK.class, metadata);
    }

}

