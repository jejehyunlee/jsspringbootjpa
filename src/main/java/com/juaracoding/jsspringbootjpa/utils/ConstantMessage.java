package com.juaracoding.jsspringbootjpa.utils;

public class ConstantMessage {

    /*
    Memperbolehkan nilai numerik dari 0 hingga 9.
    Memperbolehkan Huruf besar dan huruf kecil dari a sampai z.
    Yang diperbolehkan hanya garis bawah “_”, tanda hubung “-“ dan titik “.”
    Titik tidak diperbolehkan di awal dan akhir local part (sebelum tanda @).
    Titik berurutan tidak diperbolehkan.
    Local part, maksimal 64 karakter.
     */
//    public final static String REGEX_EMAIL_STRICT = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    /*CONTENT TYPE*/
    public final static String CONTENT_TYPE_CSV = "text/csv";

    /*REGEX*/
    public final static String REGEX_PHONE = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    /*
    * Tidak memperbolehkan tanda | (pipa) dan ' (petik 1)
    */
    public final static String REGEX_EMAIL_STANDARD_RFC5322  = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public final static String REGEX_DATE_YYYYMMDD  = "^([0-9][0-9])?[0-9][0-9]-(0[0-9]||1[0-2])-([0-2][0-9]||3[0-1])$";
    public final static String REGEX_DATE_DDMMYYYY  = "^([0-2][0-9]||3[0-1])-(0[0-9]||1[0-2])-([0-9][0-9])?[0-9][0-9]$";

    /*Global*/
    public final static String SUCCESS_SAVE = "DATA BERHASIL DIBUAT";
    public final static String ERROR_UPLOAD_CSV = "UPLOAD FILE GAGAL ";
    public final static String ERROR_NOT_CSV_FILE = "FORMAT FILE HARUS CSV ";
    public final static String SUCCESS_SEND_EMAIL = "SILAHKAN CEK EMAIL YANG TELAH ANDA DAFTARKAN";
    public final static String SUCCESS_FIND_BY = "OK";
    public final static String SUCCESS_TRANSFER = "TRANSFER BERHASIL";
    public final static String WARNING_NOT_FOUND = "DATA TIDAK DITEMUKAN";
    public final static String WARNING_DATA_EMPTY = "DATA TIDAK ADA";

    public final static String ERROR_DATA_INVALID = "DATA TIDAK VALID";
    public final static String ERROR_INTERNAL_SERVER = "INTERNAL SERVER ERROR";
    public final static String ERROR_MAIL_FORM_JSON = "Malformed JSON request";
    public final static String ERROR_EMAIL_FORMAT_INVALID = "FORMAT EMAIL TIDAK SESUAI (Nomor/Karakter@Nomor/Karakter)";
    public final static String ERROR_PHONE_NUMBER_FORMAT_INVALID = "FORMAT NOMOR HANDPHONE TIDAK SESUAI (+628XX-)";
    public final static String ERROR_DATE_FORMAT_YYYYMMDD = "FORMAT TANGGAL TIDAK SESUAI (YYYY-mm-dd)";

    public final static String ERROR_UNEXPECTED = "UNEXPECTED ERROR";
    public final static String ERROR_UNPROCCESSABLE = "Validation error. Check 'errors' field for details.";

    public final static String ERROR_NO_CONTENT = "PERMINTAAN TIDAK DAPAT DIPROSES";
    public final static String WELCOME_MESSAGE = "This is Springboot BootCamp BCAF BATCH 1";
    public final static String TAKE_TOUR = "Ready To Start";
    public final static String WARNING_EMAIL_EXIST = "EMAIL SUDAH TERDAFTAR";

    /*Category Product*/


    public final static String MAX_CHAR_NAME_CATPROD ="Maksimal nama kategori adalah 40 karakter";

    public final static String CHAR_NAME_NOTEMPY ="Nama kategori tidak boleh kosong";
    public final static String CHAR_DESC_NOTEMPTY ="Descipsi tidak boleh kosong";

    public final static String ERROR_EMPTY_FILE = "FILE KOSONG , TIDAK ADA DATA !! ";

    public final static String ERROR_SAVE_FAILED = "DATA GAGAL DISIMPAN";

    /*
    Kategori Buku
 */
    public final static String WARNING_NAMA_KATBUK_EMPTY  = "NAMA KATEGORI BUKU WAJIB DIISI";
    public final static String WARNING_NAMA_KATBUK_MAX  = "NAMA KATEGORI BUKU MAKSIMAL 50 KARAKTER";
    public final static String WARNING_DESKRIPSI_KATBUK_EMPTY  = "DESKRIPSI KATEGORI BUKU WAJIB DIISI";
    public final static String WARNING_DESKRIPSI_KATBUK_MAX  = "DESKRIPSI KATEGORI MAKSIMAL 100 KARAKTER";


    /*
        Buku
     */
    public final static String WARNING_NAMA_BUKU_EMPTY  = "NAMA KATEGORI BUKU WAJIB DIISI";
    public final static String WARNING_NAMA_BUKU_MAX  = "NAMA KATEGORI BUKU MAKSIMAL 50 KARAKTER";
    public final static String WARNING_DESKRIPSI_BUKU_EMPTY  = "DESKRIPSI KATEGORI BUKU WAJIB DIISI";
    public final static String WARNING_DESKRIPSI_BUKU_MAX  = "DESKRIPSI KATEGORI MAKSIMAL 100 KARAKTER";



}
