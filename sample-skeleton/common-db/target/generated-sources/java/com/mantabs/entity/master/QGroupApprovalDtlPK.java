package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGroupApprovalDtlPK is a Querydsl query type for GroupApprovalDtlPK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QGroupApprovalDtlPK extends BeanPath<GroupApprovalDtlPK> {

    private static final long serialVersionUID = 1004382745L;

    public static final QGroupApprovalDtlPK groupApprovalDtlPK = new QGroupApprovalDtlPK("groupApprovalDtlPK");

    public final StringPath groupApproval = createString("groupApproval");

    public final StringPath idNo = createString("idNo");

    public final NumberPath<Integer> seqNo = createNumber("seqNo", Integer.class);

    public QGroupApprovalDtlPK(String variable) {
        super(GroupApprovalDtlPK.class, forVariable(variable));
    }

    public QGroupApprovalDtlPK(Path<? extends GroupApprovalDtlPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroupApprovalDtlPK(PathMetadata metadata) {
        super(GroupApprovalDtlPK.class, metadata);
    }

}

