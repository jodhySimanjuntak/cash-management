package com.mantabs.collection.master.area_assignment.tools;

public class StringConstants {
	public static final String LOV_HANDLER = "lovHandler";
	public static final String IDPARAM_CATEGORY_ENTITY = "GBL0001";
	public static final String IDPARAM_CONTENT_TYPE = "MIN0001";
	public static final String IDPARAM_APPLICATION_NAME = "MRL0001";
	public static final String IDPARAM_MAX_LOGIN_ATTEMPTS = "MSR0001";
	public static final String IDPARAM_MIN_PASS_CHAR_COUNT = "MSR0002";
	public static final String IDPARAM_MIN_PASS_NUM_COUNT = "MSR0003";
	public static final String IDPARAM_MIN_PASS_SPC_COUNT = "MSR0004";
	public static final String IDPARAM_MIN_PASS_LENGTH = "MSR0005";
	public static final String IDPARAM_DEFAULT_PASSWORD = "MSR0006";
	public static final String IDPARAM_PROFILE_PIC_UPLOAD_LOCATION = "MSR0007";
	public static final String IDPARAM_MEMBER_TYPE = "MCS0001";
	public static final String IDPARAM_PAYMENT_STATE = "MCS0002";
	public static final String IDPARAM_INFO_UPLOAD_LOCATION = "MIN0002";
	public static final String IDPARAM_INFO_UPLOAD_LOCATION_SLIDER = "MIN0003";
	public static final String IDPARAM_BRAND_UPLOAD_LOCATION = "MBR0001";
	public static final String IDPARAM_CATEGORY_UPLOAD_LOCATION = "MCA0001";
	public static final String IDPARAM_CATEGORYTYPE_UPLOAD_LOCATION = "MCT0001";
	public static final String IDPARAM_CLASSIFICATION_UPLOAD_LOCATION = "MCL0001";
	public static final String IDPARAM_PRODUCT_UPLOAD_LOCATION = "MPD0002";
	public static final String IDPARAM_MANUFACTURER_UPLOAD_LOCATION = "MMF0001";
	public static final String IDPARAM_MAX_SLIDER = "MHP0001";
	public static final String IDPARAM_UNIT_OF_MEASURE = "MPD0001";
	public static final String IDPARAM_SO_STATE = "TSO0002";
	public static final String IDPARAM_ORDER_TYPE = "TSO0001";
	
	public static final String MSG_USER_NOT_FOUND = "Maaf, username tidak terdaftar.";
	public static final String MSG_USER_DISABLED = "Maaf, username telah dinonaktifkan.\n"
			+ "Hubungi pihak administrasi untuk bantuan lebih lanjut.";
	public static final String MSG_INVALID_PASSWORD = "Maaf, password yang dimasukkan salah.\n"
			+ "Anda dapat mencoba log-in lagi sebanyak %d kali\n"
			+ "sebelum account anda diblokir."; // %d berdasarkan max login attempt dalam setting
	public static final String MSG_USER_LOCKED = "Maaf, account Anda terblokir karena salah "
			+ "memasukkan password sebanyak %d kali."; // %d berdasarkan max login attempt dalam setting
	public static final String MSG_LOGIN_FILL_ALL = "Silakan isi username dan/atau"
			+ " password sebelum melanjutkan.";
	public static final String MSG_ROLE_DISABLED = "Maaf, role account anda telah dinonaktifkan.\n"
			+ "Silakan hubungi pihak administrasi untuk bantuan lebih lanjut.";
	public static final String MSG_GENERIC_LOGIN_ERROR = "Maaf, username dan/atau password Anda salah.";
	
	//%s = nama field / ID
	public static final String MSG_FORM_TEMPLATE = "Tidak bisa menyimpan data karena ditemukannya kesalahan "
			+ "dalam proses pengisian form: \n";
	public static final String MSG_FORM_PROMO_TEMPLATE = "Tidak bisa menambahkan detail promo karena ditemukannya kesalahan "
			+ "dalam proses pengisian form: \n";
	public static final String MSG_FORM_ID_EXISTS = "* %s yang ingin didaftarkan telah digunakan.\n";
	public static final String MSG_OLD_COPY = "* %s yang ingin diedit telah diubah oleh pengguna lain.\n"
			+ "Silakan tekan tombol Back dan Edit kembali.";
	public static final String MSG_FORM_FIELD_IS_EMPTY = "* %s tidak boleh kosong.\n";
	public static final String MSG_FORM_FIELD_ILLEGAL_CHAR = "* %s mengandung karakter illegal.\n";
	public static final String MSG_FORM_DATEDIFF_NEGATIVE = "* Perbedaan tanggal %s tidak boleh negatif.\n";
	public static final String MSG_FORM_EMAIL_INVALID = "* Email tidak benar.\n";
	public static final String MSG_FORM_PHONE_NUMERIC_INVALID = "* Nomor %s tidak benar.\n";
	public static final String MSG_FORM_NUMERIC_NEGATIVE = "* %s harus positif.\n";
	public static final String MSG_FORM_NUMERIC_OVERFLOW = "* %s tidak boleh lebih dari %s.\n";
	public static final String MSG_FORM_PASSWORD_INVALID = "* Password tidak sesuai ketentuan.\n"
			+ "  Pastikan password yang dimasukkan mengandung paling sedikit: \n"
			+ "  - %d karakter panjangnya,\n"
			+ "  - %d digit, %d huruf, dan %d karakter special.\n";
	public static final String MSG_FORM_PASSWORD_EQUALS_USERNAME = "* Password tidak boleh sama dengan nama user.\n";
	
	public static final String MSG_SRC_FILL_ALL = "Mohon isi field berikut ini untuk melakukan pencarian: \n";
	public static final String MSG_USER_EXPIRED = "Maaf, akun anda telah kadaluarsa.";
	public static final String MSG_NO_EDIT_ACCESS = "Anda tidak punya hak untuk melakukan Edit.";
	public static final String MSG_NO_DEL_ACCESS = "Anda tidak punya hak untuk melakukan Delete.";
	public static final String MSG_NOTHING_TO_EXPORT = "Tidak ada data yang akan diexport.";
	public static final Object SERVER_URL = "http://206.189.158.91:8080/spf-asset";
}
