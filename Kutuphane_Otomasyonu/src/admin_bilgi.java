public class admin_bilgi extends kullanici_bilgi{
    
    static String girisOnay() {
            return "Lütfen Boş Kalan Kısımları Doldurunuz.";
    }
    
    String girisOnay(boolean girisBasarili){
        if (!girisBasarili) {
            return "Giriş başarısız. Lütfen tekrar deneyiniz.";
        }
        return "";
    }
        
}
