package com.mantabs.entity.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MMF_MST_CABANG")
public class Cabang implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CABANG")
	private String idCabang;
	
	@Column(name = "NAMA_CABANG")
	private String namaCabang;
	
	@Column(name = "KELAS_CABANG")
	private String kelasCabang;
	
	@Column(name = "ALAMAT")
	private String alamat;
	
	@Column(name = "RT")
	private String rt;
	
	@Column(name = "RW")
	private String rw;
	
	@Column(name = "KODE_AREA_TELP1")
	private String kodeAreaTelp1;
	
	@Column(name = "NO_TELP1")
	private String noTelp1;
	
	@Column(name = "KODE_AREA_TELP2")
	private String kodeAreaTelp2;
	
	@Column(name = "NO_TELP2")
	private String noTelp2;
	
	@Column(name = "KODE_AREA_TELP3")
	private String kodeAreaTelp3;
	
	@Column(name = "NO_TELP3")
	private String noTelp3;
	
	@Column(name = "KODE_AREA_FAX")
	private String kodeAreaFax;
	
	@Column(name = "NO_FAX")
	private String noFax;
	
	@Column(name = "NO_HP")
	private String noHp;
	
	@Column(name = "PLAFON_PETTY_CASH")
	private BigDecimal plafonPettyCash;
	
	@Column(name = "BATAS_MAX_PETTY_CASH")
	private BigDecimal batasMaxPettyCash;
	
	@Column(name = "SISA_PETTY_CASH")
	private BigDecimal sisaPettyCash;
	
	@Column(name = "NILAI_KPM")
	private BigDecimal nilaiKpm;
	
	@Column(name = "NO_COA")
	private String noCoa;
	
	@Column(name = "WAKTU_LOKAL")
	private String waktuLokal;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "MODIFIED_DT")
	private Date modifiedDt;
	
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "END_DT")
	private Date endDt;
	
	@Column(name = "ID_KATEGORI_PRODUK")
	private String idKategoriProduk;
	
	@Column(name = "ID_PORTOFOLIO")
	private String idPortofolio;
	
	@Column(name = "ID_PROVINSI")
	private String idProvinsi;
	
	@Column(name = "ID_KOTA")
	private String idKota;
	
	@Column(name = "ID_KECAMATAN")
	private String idKecamatan;
	
	@Column(name = "ID_KELURAHAN")
	private String idKelurahan;
	
	@Column(name = "ID_REGIONAL")
	private String idRegional;
	
	@Column(name = "ID_CENTRO")
	private String idCentro;
	
	@Column(name = "ID_WILAYAH")
	private String idWilayah;
	
	@Column(name = "MASA_REQUEST")
	private Integer masaRequest;
	
	@Column(name = "BUFFER_CASH")
	private BigDecimal bufferCash;
	
	@Column(name = "ID_CETRO")
	private String idCetro;

	public String getIdCabang() {
		return idCabang;
	}

	public void setIdCabang(String idCabang) {
		this.idCabang = idCabang;
	}

	public String getNamaCabang() {
		return namaCabang;
	}

	public void setNamaCabang(String namaCabang) {
		this.namaCabang = namaCabang;
	}

	public String getKelasCabang() {
		return kelasCabang;
	}

	public void setKelasCabang(String kelasCabang) {
		this.kelasCabang = kelasCabang;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getRw() {
		return rw;
	}

	public void setRw(String rw) {
		this.rw = rw;
	}

	public String getKodeAreaTelp1() {
		return kodeAreaTelp1;
	}

	public void setKodeAreaTelp1(String kodeAreaTelp1) {
		this.kodeAreaTelp1 = kodeAreaTelp1;
	}

	public String getNoTelp1() {
		return noTelp1;
	}

	public void setNoTelp1(String noTelp1) {
		this.noTelp1 = noTelp1;
	}

	public String getKodeAreaTelp2() {
		return kodeAreaTelp2;
	}

	public void setKodeAreaTelp2(String kodeAreaTelp2) {
		this.kodeAreaTelp2 = kodeAreaTelp2;
	}

	public String getNoTelp2() {
		return noTelp2;
	}

	public void setNoTelp2(String noTelp2) {
		this.noTelp2 = noTelp2;
	}

	public String getKodeAreaTelp3() {
		return kodeAreaTelp3;
	}

	public void setKodeAreaTelp3(String kodeAreaTelp3) {
		this.kodeAreaTelp3 = kodeAreaTelp3;
	}

	public String getNoTelp3() {
		return noTelp3;
	}

	public void setNoTelp3(String noTelp3) {
		this.noTelp3 = noTelp3;
	}

	public String getKodeAreaFax() {
		return kodeAreaFax;
	}

	public void setKodeAreaFax(String kodeAreaFax) {
		this.kodeAreaFax = kodeAreaFax;
	}

	public String getNoFax() {
		return noFax;
	}

	public void setNoFax(String noFax) {
		this.noFax = noFax;
	}

	public String getNoHp() {
		return noHp;
	}

	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}

	public BigDecimal getPlafonPettyCash() {
		return plafonPettyCash;
	}

	public void setPlafonPettyCash(BigDecimal plafonPettyCash) {
		this.plafonPettyCash = plafonPettyCash;
	}

	public BigDecimal getBatasMaxPettyCash() {
		return batasMaxPettyCash;
	}

	public void setBatasMaxPettyCash(BigDecimal batasMaxPettyCash) {
		this.batasMaxPettyCash = batasMaxPettyCash;
	}

	public BigDecimal getSisaPettyCash() {
		return sisaPettyCash;
	}

	public void setSisaPettyCash(BigDecimal sisaPettyCash) {
		this.sisaPettyCash = sisaPettyCash;
	}

	public BigDecimal getNilaiKpm() {
		return nilaiKpm;
	}

	public void setNilaiKpm(BigDecimal nilaiKpm) {
		this.nilaiKpm = nilaiKpm;
	}

	public String getNoCoa() {
		return noCoa;
	}

	public void setNoCoa(String noCoa) {
		this.noCoa = noCoa;
	}

	

	public String getWaktuLokal() {
		return waktuLokal;
	}

	public void setWaktuLokal(String waktuLokal) {
		this.waktuLokal = waktuLokal;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(Date modifiedDt) {
		this.modifiedDt = modifiedDt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getEndDt() {
		return endDt;
	}

	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}

	public String getIdKategoriProduk() {
		return idKategoriProduk;
	}

	public void setIdKategoriProduk(String idKategoriProduk) {
		this.idKategoriProduk = idKategoriProduk;
	}

	public String getIdPortofolio() {
		return idPortofolio;
	}

	public void setIdPortofolio(String idPortofolio) {
		this.idPortofolio = idPortofolio;
	}

	public String getIdProvinsi() {
		return idProvinsi;
	}

	public void setIdProvinsi(String idProvinsi) {
		this.idProvinsi = idProvinsi;
	}

	public String getIdKota() {
		return idKota;
	}

	public void setIdKota(String idKota) {
		this.idKota = idKota;
	}

	public String getIdKecamatan() {
		return idKecamatan;
	}

	public void setIdKecamatan(String idKecamatan) {
		this.idKecamatan = idKecamatan;
	}

	public String getIdKelurahan() {
		return idKelurahan;
	}

	public void setIdKelurahan(String idKelurahan) {
		this.idKelurahan = idKelurahan;
	}

	public String getIdRegional() {
		return idRegional;
	}

	public void setIdRegional(String idRegional) {
		this.idRegional = idRegional;
	}

	public String getIdCentro() {
		return idCentro;
	}

	public void setIdCentro(String idCentro) {
		this.idCentro = idCentro;
	}

	public String getIdWilayah() {
		return idWilayah;
	}

	public void setIdWilayah(String idWilayah) {
		this.idWilayah = idWilayah;
	}

	public Integer getMasaRequest() {
		return masaRequest;
	}

	public void setMasaRequest(Integer masaRequest) {
		this.masaRequest = masaRequest;
	}

	public BigDecimal getBufferCash() {
		return bufferCash;
	}

	public void setBufferCash(BigDecimal bufferCash) {
		this.bufferCash = bufferCash;
	}

	public String getIdCetro() {
		return idCetro;
	}

	public void setIdCetro(String idCetro) {
		this.idCetro = idCetro;
	}

	

}
