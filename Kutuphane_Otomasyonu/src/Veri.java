import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Veri{
    
    
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    

    
    public boolean girisYap(String kullanici_adi, String parola){
    
        String sorgu = "Select * from kullanicilar where kullanici_adi = ? and parola = ?";
        
        try{
        preparedStatement = con.prepareStatement(sorgu);
        
        preparedStatement.setString(1,kullanici_adi);
        preparedStatement.setString(2,parola);
        
        ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        }catch(SQLException ex){
            return false;
        }      
    }
    
    public void kayıtOl(String kullanici_adi, String parola){
    
        String sorgu2 = "insert into kullanicilar (kullanici_adi,parola) values(?,?)";
        
        try{
        preparedStatement = con.prepareStatement(sorgu2);
        
        preparedStatement.setString(1,kullanici_adi);
        preparedStatement.setString(2,parola);
        preparedStatement.executeUpdate();           
        }catch(SQLException ex){          
        }    
    }
    
    public ArrayList<Kitaplar> kitaplariGetir(){
            ArrayList<Kitaplar> cikti = new ArrayList<Kitaplar>();
            
        try {
            statement = con.createStatement();
            String sorgu3 = "Select * From kitaplar";
            
            ResultSet rs = statement.executeQuery(sorgu3);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String kitap_adi = rs.getString("kitapadi");
                String yazar_adi = rs.getString("yazaradi");
                String yayin_evi = rs.getString("yayinevi");
                String kitap_turu = rs.getString("kitapturu");
                String kitap_durumu = rs.getString("kitapdurumu");
                
                cikti.add(new Kitaplar(id, kitap_adi, yazar_adi, yayin_evi, kitap_turu, kitap_durumu));              
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void kitapEkle(String kitap_adi, String yazar_adi, String yayin_evi, String kitap_turu, String kitap_durumu){
        
        String sorgu4 = "insert into kitaplar (kitapadi,yazaradi,yayinevi,kitapturu,kitapdurumu) values (?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu4);
            
            preparedStatement.setString(1, kitap_adi);
            preparedStatement.setString(2, yazar_adi);
            preparedStatement.setString(3, yayin_evi);
            preparedStatement.setString(4, kitap_turu);
            preparedStatement.setString(5, kitap_durumu);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kitapGuncelle(int id, String yenikitap_adi, String yeniyazar_adi, String yeniyayin_Evi, String yenikitap_turu){
        
        String sorgu5 = "update kitaplar set kitapadi = ? , yazaradi = ? , yayinevi = ? , kitapturu = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu5);
            
            preparedStatement.setString(1, yenikitap_adi);
            preparedStatement.setString(2, yeniyazar_adi);
            preparedStatement.setString(3, yeniyayin_Evi);
            preparedStatement.setString(4, yenikitap_turu);
            
            preparedStatement.setInt(5, id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kitapSil(int id){
        String sorgu6 = "delete from kitaplar where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu6);
            preparedStatement.setInt(1,id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void kitapVer(int id, String kitap_adi_GE, String kitap_yazari_GE, String yayin_evi_GE, String kitap_turu_GE, String kitap_durumu_GE) {
            String sorgu10 = "update kitaplar set kitapadi = ? , yazaradi = ? , yayinevi = ? , kitapturu = ?, kitapdurumu = ? where id = ?";
        
            kitap_durumu_GE = "Mevcut Değil";
        try {
            preparedStatement = con.prepareStatement(sorgu10);
            
            preparedStatement.setString(1, kitap_adi_GE);
            preparedStatement.setString(2, kitap_yazari_GE);
            preparedStatement.setString(3, yayin_evi_GE);
            preparedStatement.setString(4, kitap_turu_GE);
            preparedStatement.setString(5, kitap_durumu_GE);
            
            preparedStatement.setInt(6, id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void kitapAl(int kitapid, String kitap_adi_GE, String kitap_yazari_GE, String yayin_evi_GE, String kitap_turu_GE, String kitap_durumu_GE) {
            String sorgu11 = "update kitaplar set kitapadi = ? , yazaradi = ? , yayinevi = ? , kitapturu = ?, kitapdurumu = ? where id = ?";
        
            kitap_durumu_GE = "Mevcut";
        try {
            preparedStatement = con.prepareStatement(sorgu11);
            
            preparedStatement.setString(1, kitap_adi_GE);
            preparedStatement.setString(2, kitap_yazari_GE);
            preparedStatement.setString(3, yayin_evi_GE);
            preparedStatement.setString(4, kitap_turu_GE);
            preparedStatement.setString(5, kitap_durumu_GE);
            
            preparedStatement.setInt(6, kitapid);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Veri(){
        String url = "jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.db_ismi+"?&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
        try{
            con = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola);
            System.out.println("Bağlantı başarılı...");
        }
        catch(SQLException ex){
            System.out.println("Bağlantı başarısız...");
        }
    }
 
    void uyeEkle(String uye_adi, String cinsiyet, String dogum_tarihi, String telefon, String e_mail) {
        String sorgu7 = "insert into kullanicilar_uye (uye_adi,cinsiyet,dogum_tarihi,telefon,e_mail) values (?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu7);
            
            preparedStatement.setString(1, uye_adi);
            preparedStatement.setString(2, cinsiyet);
            preparedStatement.setString(3, dogum_tarihi);
            preparedStatement.setString(4, telefon);
            preparedStatement.setString(5, e_mail);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void uyeGuncelle(int id, String uye_adi_G, String cinsiyet_G, String dogum_tarihi_G, String telefon_G, String e_mail_G) {
        String sorgu8 = "update kullanicilar_uye set uye_adi = ? , cinsiyet = ? , dogum_tarihi = ? , telefon = ?, e_mail = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu8);
            
            preparedStatement.setString(1, uye_adi_G);
            preparedStatement.setString(2, cinsiyet_G);
            preparedStatement.setString(3, dogum_tarihi_G);
            preparedStatement.setString(4, telefon_G);
            preparedStatement.setString(5, e_mail_G);
            
            preparedStatement.setInt(6, id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Uyeler> uyeleriGetir(){
            ArrayList<Uyeler> cikti = new ArrayList<Uyeler>();
            
        try {
            statement = con.createStatement();
            String sorgu3 = "Select * From kullanicilar_uye";
            
            ResultSet rs = statement.executeQuery(sorgu3);
            
            while(rs.next()){
                int id = rs.getInt("id");
                int kitaplari = rs.getInt("kitaplari");
                String uye_adi = rs.getString("uye_adi");
                String cinsiyet = rs.getString("cinsiyet");
                String dogum_tarihi = rs.getString("dogum_tarihi");
                String telefon = rs.getString("telefon");
                String e_mail = rs.getString("e_mail");
                
                cikti.add(new Uyeler(id, uye_adi, cinsiyet, dogum_tarihi, telefon, e_mail, kitaplari));              
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    void uyeSil(int id) {
        String sorgu6 = "delete from kullanicilar_uye where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu6);
            preparedStatement.setInt(1,id);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void uyeyeVer(int uyeid, String uye_adi_GE, String cinsiyet_GE, String dogum_tarihi_GE, String telefon_GE, String e_mail_GE, int kitaplari) {
                String sorgu8 = "update kullanicilar_uye set uye_adi = ? , cinsiyet = ? , dogum_tarihi = ? , telefon = ?, e_mail = ?, kitaplari = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu8);
            
            preparedStatement.setString(1, uye_adi_GE);
            preparedStatement.setString(2, cinsiyet_GE);
            preparedStatement.setString(3, dogum_tarihi_GE);
            preparedStatement.setString(4, telefon_GE);
            preparedStatement.setString(5, e_mail_GE);
            preparedStatement.setInt(6, kitaplari);
            
            preparedStatement.setInt(7, uyeid);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Veri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
