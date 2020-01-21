package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGroupApprovalHdrPK is a Querydsl query type for GroupApprovalHdrPK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QGroupApprovalHdrPK extends BeanPath<GroupApprovalHdrPK> {

    private static final long serialVersionUID = 1007605939L;

    public static final QGroupApprovalHdrPK groupApprovalHdrPK = new QGroupApprovalHdrPK("groupApprovalHdrPK");

    public final StringPath idNo = createString("idNo");

    public final StringPath kategoriBiaya = createString("kategoriBiaya");

    public final StringPath kodeGroupApproval = createString("kodeGroupApproval");

    public QGroupApprovalHdrPK(String variable) {
        super(GroupApprovalHdrPK.class, forVariable(variable));
    }

    public QGroupApprovalHdrPK(Path<? extends GroupApprovalHdrPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroupApprovalHdrPK(PathMetadata metadata) {
        super(GroupApprovalHdrPK.class, metadata);
    }

}

