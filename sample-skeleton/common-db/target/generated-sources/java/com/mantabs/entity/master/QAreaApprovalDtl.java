package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAreaApprovalDtl is a Querydsl query type for AreaApprovalDtl
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAreaApprovalDtl extends EntityPathBase<AreaApprovalDtl> {

    private static final long serialVersionUID = -109141432L;

    public static final QAreaApprovalDtl areaApprovalDtl = new QAreaApprovalDtl("areaApprovalDtl");

    public final StringPath areaApproval = createString("areaApproval");

    public final StringPath cabang = createString("cabang");

    public final StringPath createdBy = createString("createdBy");

    public final StringPath createdDt = createString("createdDt");

    public final StringPath endDt = createString("endDt");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final StringPath modifiedDt = createString("modifiedDt");

    public final NumberPath<Integer> seqNo = createNumber("seqNo", Integer.class);

    public final StringPath status = createString("status");

    public QAreaApprovalDtl(String variable) {
        super(AreaApprovalDtl.class, forVariable(variable));
    }

    public QAreaApprovalDtl(Path<? extends AreaApprovalDtl> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAreaApprovalDtl(PathMetadata metadata) {
        super(AreaApprovalDtl.class, metadata);
    }

}

