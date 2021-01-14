public class Kitaplar {
    
    private int id;
    private String kitap_adi;
    private String kitap_yazari;
    private String yayin_evi;
    private String kitap_turu;
    private String kitap_durumu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitap_adi() {
        return kitap_adi;
    }

    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }

    public String getKitap_yazari() {
        return kitap_yazari;
    }

    public void setKitap_yazari(String kitap_yazari) {
        this.kitap_yazari = kitap_yazari;
    }

    public String getYayin_evi() {
        return yayin_evi;
    }

    public void setYayin_evi(String yayin_evi) {
        this.yayin_evi = yayin_evi;
    }

    public String getKitap_turu() {
        return kitap_turu;
    }

    public void setKitap_turu(String kitap_turu) {
        this.kitap_turu = kitap_turu;
    }

        public String getKitap_durumu() {
        return kitap_durumu;
    }

    public void setKitap_durumu(String kitap_durumu) {
        this.kitap_durumu = kitap_durumu;
    }
    
    public Kitaplar(int id, String kitap_adi, String kitap_yazari, String yayin_evi, String kitap_turu, String kitap_durumu) {
        this.id = id;
        this.kitap_adi = kitap_adi;
        this.kitap_yazari = kitap_yazari;
        this.yayin_evi = yayin_evi;
        this.kitap_turu = kitap_turu;
        this.kitap_durumu = kitap_durumu;
    }

}
