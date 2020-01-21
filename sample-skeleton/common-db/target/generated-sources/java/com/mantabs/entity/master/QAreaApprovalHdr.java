package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAreaApprovalHdr is a Querydsl query type for AreaApprovalHdr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAreaApprovalHdr extends EntityPathBase<AreaApprovalHdr> {

    private static final long serialVersionUID = -109138078L;

    public static final QAreaApprovalHdr areaApprovalHdr = new QAreaApprovalHdr("areaApprovalHdr");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDt = createDateTime("endDt", java.util.Date.class);

    public final StringPath groupApproval = createString("groupApproval");

    public final StringPath inisiator = createString("inisiator");

    public final StringPath kodeAreaApproval = createString("kodeAreaApproval");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final StringPath modifiedDt = createString("modifiedDt");

    public final StringPath status = createString("status");

    public QAreaApprovalHdr(String variable) {
        super(AreaApprovalHdr.class, forVariable(variable));
    }

    public QAreaApprovalHdr(Path<? extends AreaApprovalHdr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAreaApprovalHdr(PathMetadata metadata) {
        super(AreaApprovalHdr.class, metadata);
    }

}

