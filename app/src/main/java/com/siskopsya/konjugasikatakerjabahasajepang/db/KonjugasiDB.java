package com.siskopsya.konjugasikatakerjabahasajepang.db;
import android.provider.BaseColumns;
public class KonjugasiDB {
    private KonjugasiDB() {
    }
    public static class KonjugasiDatabase implements BaseColumns {
        public static final String TABLE_NAME = "konjugasi";
        public static final String id = "id";
        public static final String kata = "kata";
        public static final String kanji = "kanji";
        public static final String masu_positif = "masu_positif";
        public static final String masu_negatif = "masu_negatif";
        public static final String mashita_positif = "mashita_positif";
        public static final String mashita_negatif = "mashita_negatif";
        public static final String te_positif = "te_positif";
        public static final String te_negatif = "te_negatif";
        public static final String tai_positif = "tai_positif";
        public static final String tai_negatif = "tai_negatif";
        public static final String mashou_positif = "mashou_positif";
        public static final String mashou_negatif = "mashou_negatif";
        public static final String kamus_positif = "kamus_positif";
        public static final String kamus_negatif = "kamus_negatif";
        public static final String ta_positif = "ta_positif";
        public static final String ta_negatif = "ta_negatif";
        public static final String tara_positif = "tara_positif";
        public static final String tara_negatif = "tara_negatif";
        public static final String potensial_positif = "potensial_positif";
        public static final String potensial_negatif = "potensial_negatif";
        public static final String ajakan_positif = "ajakan_positif";
        public static final String ajakan_negatif = "ajakan_negatif";
        public static final String perintah_positif = "perintah_positif";
        public static final String perintah_negatif = "perintah_negatif";
        public static final String larangan_positif = "larangan_positif";
        public static final String larangan_negatif = "larangan_negatif";
        public static final String ba_positif = "ba_positif";
        public static final String ba_negatif = "ba_negatif";
        public static final String pasif_positif = "pasif_positif";
        public static final String pasif_negatif = "pasif_negatif";

    }
}
