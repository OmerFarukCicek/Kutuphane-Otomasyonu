public class Uyeler{

    private int id;
    private String kullanici_adi;
    private String cinsiyet;
    private String dogum_tarihi;
    private String telefon;
    private String e_mail;
    private int kitaplari;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the kullanici_adi
     */
    public String getKullanici_adi() {
        return kullanici_adi;
    }

    /**
     * @param kullanici_adi the kullanici_adi to set
     */
    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    /**
     * @return the cinsiyet
     */
    public String getCinsiyet() {
        return cinsiyet;
    }

    /**
     * @param cinsiyet the cinsiyet to set
     */
    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    /**
     * @return the dogum_tarihi
     */
    public String getDogum_tarihi() {
        return dogum_tarihi;
    }

    /**
     * @param dogum_tarihi the dogum_tarihi to set
     */
    public void setDogum_tarihi(String dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * @return the E_mail
     */
    public String getE_mail() {
        return e_mail;
    }

    /**
     * @param E_mail the E_mail to set
     */
    public void setE_mail(String E_mail) {
        this.e_mail = E_mail;
    }

    Uyeler(int id, String uye_adi, String cinsiyet, String dogum_tarihi, String telefon, String e_mail, int kitaplari) {
        this.id = id;
        this.kullanici_adi = uye_adi;
        this.cinsiyet = cinsiyet;
        this.dogum_tarihi = dogum_tarihi;
        this.telefon = telefon;
        this.e_mail = e_mail;
        this.kitaplari = kitaplari;
    }

    /**
     * @return the kitaplari
     */
    public int getKitaplari() {
        return kitaplari;
    }

    /**
     * @param kitaplari the kitaplari to set
     */
    public void setKitaplari(int kitaplari) {
        this.kitaplari = kitaplari;
    }
}
