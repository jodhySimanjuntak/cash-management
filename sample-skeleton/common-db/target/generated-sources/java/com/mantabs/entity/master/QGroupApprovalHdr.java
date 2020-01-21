package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGroupApprovalHdr is a Querydsl query type for GroupApprovalHdr
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGroupApprovalHdr extends EntityPathBase<GroupApprovalHdr> {

    private static final long serialVersionUID = -933028680L;

    public static final QGroupApprovalHdr groupApprovalHdr = new QGroupApprovalHdr("groupApprovalHdr");

    public final StringPath branchId = createString("branchId");

    public final StringPath budget = createString("budget");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<java.math.BigDecimal> endRangePengajuan = createNumber("endRangePengajuan", java.math.BigDecimal.class);

    public final StringPath groupApproval = createString("groupApproval");

    public final StringPath idNo = createString("idNo");

    public final StringPath inisiator = createString("inisiator");

    public final StringPath jenisBiaya = createString("jenisBiaya");

    public final StringPath kategoriBiaya = createString("kategoriBiaya");

    public final StringPath kodeGroupApproval = createString("kodeGroupApproval");

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modofiedDt = createDateTime("modofiedDt", java.util.Date.class);

    public final NumberPath<java.math.BigDecimal> startRangePengajuan = createNumber("startRangePengajuan", java.math.BigDecimal.class);

    public final StringPath status = createString("status");

    public final StringPath subKategori = createString("subKategori");

    public final StringPath tingkatJabatan = createString("tingkatJabatan");

    public QGroupApprovalHdr(String variable) {
        super(GroupApprovalHdr.class, forVariable(variable));
    }

    public QGroupApprovalHdr(Path<? extends GroupApprovalHdr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGroupApprovalHdr(PathMetadata metadata) {
        super(GroupApprovalHdr.class, metadata);
    }

}

