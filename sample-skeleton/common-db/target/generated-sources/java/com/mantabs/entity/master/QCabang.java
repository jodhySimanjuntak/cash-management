package com.mantabs.entity.master;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCabang is a Querydsl query type for Cabang
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCabang extends EntityPathBase<Cabang> {

    private static final long serialVersionUID = -307257446L;

    public static final QCabang cabang = new QCabang("cabang");

    public final StringPath alamat = createString("alamat");

    public final NumberPath<java.math.BigDecimal> batasMaxPettyCash = createNumber("batasMaxPettyCash", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> bufferCash = createNumber("bufferCash", java.math.BigDecimal.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> createdDt = createDateTime("createdDt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDt = createDateTime("endDt", java.util.Date.class);

    public final StringPath idCabang = createString("idCabang");

    public final StringPath idCentro = createString("idCentro");

    public final StringPath idCetro = createString("idCetro");

    public final StringPath idKategoriProduk = createString("idKategoriProduk");

    public final StringPath idKecamatan = createString("idKecamatan");

    public final StringPath idKelurahan = createString("idKelurahan");

    public final StringPath idKota = createString("idKota");

    public final StringPath idPortofolio = createString("idPortofolio");

    public final StringPath idProvinsi = createString("idProvinsi");

    public final StringPath idRegional = createString("idRegional");

    public final StringPath idWilayah = createString("idWilayah");

    public final StringPath kelasCabang = createString("kelasCabang");

    public final StringPath kodeAreaFax = createString("kodeAreaFax");

    public final StringPath kodeAreaTelp1 = createString("kodeAreaTelp1");

    public final StringPath kodeAreaTelp2 = createString("kodeAreaTelp2");

    public final StringPath kodeAreaTelp3 = createString("kodeAreaTelp3");

    public final NumberPath<Integer> masaRequest = createNumber("masaRequest", Integer.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public final DateTimePath<java.util.Date> modifiedDt = createDateTime("modifiedDt", java.util.Date.class);

    public final StringPath namaCabang = createString("namaCabang");

    public final NumberPath<java.math.BigDecimal> nilaiKpm = createNumber("nilaiKpm", java.math.BigDecimal.class);

    public final StringPath noCoa = createString("noCoa");

    public final StringPath noFax = createString("noFax");

    public final StringPath noHp = createString("noHp");

    public final StringPath noTelp1 = createString("noTelp1");

    public final StringPath noTelp2 = createString("noTelp2");

    public final StringPath noTelp3 = createString("noTelp3");

    public final NumberPath<java.math.BigDecimal> plafonPettyCash = createNumber("plafonPettyCash", java.math.BigDecimal.class);

    public final StringPath rt = createString("rt");

    public final StringPath rw = createString("rw");

    public final NumberPath<java.math.BigDecimal> sisaPettyCash = createNumber("sisaPettyCash", java.math.BigDecimal.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath waktuLokal = createString("waktuLokal");

    public QCabang(String variable) {
        super(Cabang.class, forVariable(variable));
    }

    public QCabang(Path<? extends Cabang> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCabang(PathMetadata metadata) {
        super(Cabang.class, metadata);
    }

}

