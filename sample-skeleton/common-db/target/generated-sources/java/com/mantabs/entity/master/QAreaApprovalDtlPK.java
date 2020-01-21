package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAreaApprovalDtlPK is a Querydsl query type for AreaApprovalDtlPK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAreaApprovalDtlPK extends BeanPath<AreaApprovalDtlPK> {

    private static final long serialVersionUID = -1805698493L;

    public static final QAreaApprovalDtlPK areaApprovalDtlPK = new QAreaApprovalDtlPK("areaApprovalDtlPK");

    public final NumberPath<Integer> seqNo = createNumber("seqNo", Integer.class);

    public QAreaApprovalDtlPK(String variable) {
        super(AreaApprovalDtlPK.class, forVariable(variable));
    }

    public QAreaApprovalDtlPK(Path<? extends AreaApprovalDtlPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAreaApprovalDtlPK(PathMetadata metadata) {
        super(AreaApprovalDtlPK.class, metadata);
    }

}

