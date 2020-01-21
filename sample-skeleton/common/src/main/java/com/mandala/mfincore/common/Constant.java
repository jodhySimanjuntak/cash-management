package com.mandala.mfincore.common;

public final class Constant {
	public static String SUCCESS = "SUCCESS";
	public static final String MESSAGEBOX_SAVE_QUESTION = "Apakah anda yakin akan menyimpan data ini ?";
	public static final String MESSAGEBOX_UPDATE_QUESTION = "Apakah anda yakin akan mengubah data ini ?";
	public static final String MESSAGEBOX_DELETE_QUESTION = "Apakah anda yakin akan menghapus data ini ?";
	public static final String MESSAGEBOX_SUBMIT_QUESTION = "Apakah anda yakin akan submit data ini ?";

	public static final String MESSAGEBOX_SAVE_TITLE = "Konfirmasi Simpan Data";
	public static final String MESSAGEBOX_UPDATE_TITLE = "Konfirmasi Ubah Data";
	public static final String MESSAGEBOX_DELETE_TITLE = "Konfirmasi Hapus Data";
	public static final String MESSAGEBOX_SUBMIT_TITLE = "Konfirmasi Submit Data";

	public static final String MESSAGEBOX_SAVE_SUCCESS = "Data berhasil disimpan";
	public static final String MESSAGEBOX_UPDATE_SUCCESS = "Data berhasil diubah";
	public static final String MESSAGEBOX_DELETE_SUCCESS = "Data berhasil dihapus";
	public static final String MESSAGEBOX_SUBMIT_SUCCESS = "Data berhasil disubmit";

	public static final String MESSAGEBOX_SAVE_FAILED = "Data gagal disimpan \n";
	public static final String MESSAGEBOX_UPDATE_FAILED = "Data gagal diubah \n";
	public static final String MESSAGEBOX_DELETE_FAILED = "Data gagal dihapus \n";
	public static final String MESSAGEBOX_SUBMIT_FAILED = "Data gagal disubmit \n";
	public static final String MESSAGEBOX_PRINT_FAILED = "Data gagal dicetak \n";

	public static final String MESSAGEBOX_MANDATORY = "Data Mandatori Harus Diisi";
	public static final String MESSAGEBOX_MANDATORY_VALUE = "Value Harus Diisi";
	
	public static final String MESSAGEBOX_NOT_FOUND = "Data Tidak Ditemukan";
	public static final String MESSAGEBOX_VALIDATION_DATE = "Tanggal Sampai Tidak Boleh Lebih Kecil Dari Tanggal Mulai";
	public static final String MESSAGEBOX_NOT_DELETE = "Data Tidak Dapat Dihapus Dikarenakan Keterkaitan Dengan Data Yang Lain";

	public final int PAGE_SIZE = 15;
	
	//status mutasi
	public static final String MENUNGGU_PERSETUJUAN = "MENUNGGU PERSETUJUAN";
	public static final String PENGAJUAN = "PENGAJUAN";
	public static final String DISETUJUI = "DISETUJUI";
	public static final String DITOLAK = "DITOLAK";
	public static final String IN_TRANSIT = "IN TRANSIT";
	public static final String DITERIMA = "DITERIMA";
	public static final String DIKEMBALIKAN = "DIKEMBALIKAN";
	public static final String IN_TRANSIT_PENGEMBALIAN = "IN TRANSIT - PENGEMBALIAN";
	
	//Status jaminan booking
	public static final String AVAILABLE = "AVAILABLE";
	public static final String KIRIM_KE_KP = "KIRIM KE KP";
	public static final String MUTASI_KELUAR_PENGAJUAN = "MTS KELUAR - PENGAJUAN";
	public static final String MUTASI_KELUAR_MENUNGGU_PERSETUJUAN = "MTS KELUAR - MENUNGGU PERSETUJUAN";
	public static final String MUTASI_KELUAR_DISETUJUI = "MTS KELUAR - DISETUJUI";
	public static final String MUTASI_KELUAR_DITOLAK = "MTS KELUAR - DITOLAK";
	public static final String MUTASI_KELUAR_IN_TRANSIT = "MTS KELUAR - IN TRANSIT";
	public static final String KIRIM_KE_BANK = "KIRIM KE BANK";
	public static final String BANK_HO = "BANK-HO";
	public static final String DIKEMBALIKAN_MANUAL = "DIKEMBALIKAN MANUAL";
}

