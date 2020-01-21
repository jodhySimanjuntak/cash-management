package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGroupApprovalDtl is a Querydsl query type for GroupApprovalDtl
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGroupApprovalDtl extends EntityPathBase<GroupApprovalDtl> {

    private static final long serialVersionUID = -933032034L;

    public static final QGroupApprovalDtl groupApprovalDtl = new QGroupApprovalDtl("groupApprovalDtl");

    public final DateTimePath<java.util.Date> craetedDt = createDateTime("craetedDt", java.util.Date.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final StringPath groupApproval = createString("groupApproval");

    public final StringPath idNo = createString("idNo");

    public final StringPath jabatan = createString("jabatan");

    public final StringPath levelJabatan = createString("levelJabatan");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final NumberPath<Integer> seqNo = createNumber("seqNo", Integer.class);

    public final StringPath status = createString("status");

    public QGroupApprovalDtl(String variable) {
        super(GroupApprovalDtl.class, forVariable(variable));
    }

    public QGroupApprovalDtl(Path<? extends GroupApprovalDtl> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroupApprovalDtl(PathMetadata metadata) {
        super(GroupApprovalDtl.class, metadata);
    }

}

