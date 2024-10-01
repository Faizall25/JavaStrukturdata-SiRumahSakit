/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class cConfig {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/rumahsakit";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultData;

//    Conection
    public static void connection() {

        try {
//            REGISTRASI DRIVER
            Class.forName(JDBC_DRIVER);

            connect = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("connection berhasil");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    SAVE DENGAN ID
    public static boolean simpan(String kategori, String sBarang, String bBaik, String bRusak, String keterangan) {
        boolean nilai = false;

        cConfig.connection();

        try {

            statement = connect.createStatement();
            String query = "INSERT INTO data VALUES("+null
            + ",'"+kategori+"',"
            + "'"+sBarang+"',"
            + "'"+bBaik+"',"
            + "'"+bRusak+"',"
            + "'"+keterangan+"')";
            
            if (!statement.execute(query)){
                nilai = true;
            }
            
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nilai;
    }

//    Save tanpa id
    public static boolean tambah(String Username,int Pasword, int Saldo) {
        boolean nilai = false;

        cConfig.connection();

        try {

            statement = connect.createStatement();
            String query = "INSERT INTO User VALUES(" + null + ","
                    + "'" + Username + "',"
                    + "" + Pasword + ","
                    + "" + Saldo + ")";

            if (!statement.execute(query)) {
                nilai = true;
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nilai;
    }
    
//    Delate
    public static boolean hapus(String nama) {
        boolean nilai = false;
        
        cConfig.connection();
        
        try {
            
            statement = connect.createStatement();
            String query = "delete from pesanan where nama='" +nama+ "'";
            
            if (!statement.execute(query)) {
                nilai = true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nilai;
    }

    public static boolean insertHistory(String username, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean insertHistory(JTextField Usersaldo, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean update(JTextField Usersaldo, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    UPDATE
    public boolean updateUser(int id, String kategori, String sBarang, String Bbaik, String bRusak, String keterangan){
        boolean nilai = false;
        
        cConfig.connection();
        
        try {
            
            statement = connect.createStatement();
            String query = "UPDATE `data` SET `id`='" +id+ "',`kategori`='" +kategori+ "',"
                    + "`sBarang`='" +sBarang+ "',`bBaik`='" +Bbaik+ "',`bRusak`='" +bRusak+ "',`keterangan`='" +keterangan+ "' WHERE id = '" +id+ "'";
            
            if (!statement.execute(query)){
                nilai = true;
                JOptionPane.showMessageDialog(null, "Berhasil Di Update");
            }
            
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nilai;
    }
    
//    Delete
    public static boolean delate(String username){
        boolean nilai = false;
        
        cConfig.connection();
        
        try {
            
            statement = connect.createStatement();
            String query = "DELETE FROM login_multiuser WHERE Username='" +username+ "'";
            
            if (!statement.execute(query)){
                nilai = true;
//                JOptionPane.showMessageDialog(null, "Berhasil Di Update");
            }
            
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nilai;
    }
    
//    Config Login 
    
    public static boolean login(String username, int pasword) {

        boolean nilai = false;
//        menghubungkan database
        cConfig.connection();

        try {
//            buat object statement
            statement = connect.createStatement();
//            membuat query ke database
            String query = "SELECT * FROM User WHERE Username = '" + username + "'and Pasword = '" + pasword + "'";
//            melakukan query
            resultData = statement.executeQuery(query);

            if (resultData.next()) {
                if (username.equals(resultData.getString("Username"))
                        && pasword==(resultData.getInt("Pasword"))) {
                                nilai = true;

//                    JOptionPane.showMessageDialog(null, "Berhasil login");
                }
            }

//            close connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nilai;
    }
    
//    MENCARI NAMA MENGGUNAKAN NIK/NIP
    public static String cariNama(String Nimp, int nilai) {
        String a = "";

        cConfig.connection();

        if (nilai == 1) {
            try {
                //            buat object statement
                statement = connect.createStatement();
//            membuat query ke database
                String query = "SELECT * FROM data WHERE nim = '" + Nimp + "'";
//            melakukan query
                resultData = statement.executeQuery(query);

                while (resultData.next()) {
                    a = resultData.getString("nama");
//                    System.out.println("nama di db = " + a);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if(nilai == 2){
            try {
                //            buat object statement
                statement = connect.createStatement();
//            membuat query ke database
                String query = "SELECT * FROM dataguru WHERE nip = '" + Nimp + "'";
//            melakukan query
                resultData = statement.executeQuery(query);

                while (resultData.next()) {
                    a = resultData.getString("nama");
//                    System.out.println("nama di db = " + a);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return a;
    }
    
    public static String getSaldo(String username) {

        boolean nilai = false;
//        menghubungkan database
        cConfig.connection();

        try {
//            buat object statement
            statement = connect.createStatement();
//            membuat query ke database
            String query = "SELECT * FROM login_multiuser WHERE Username = '" + username + "'";
//            melakukan query
            resultData = statement.executeQuery(query);

            if (resultData.next()) {
                return resultData.getString("Saldo");
            }

//            close connection
            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
    
    public static boolean UserPengirim(String username, int saldoKirim){
        boolean nilai = false;
        
        cConfig.connection();
        
        try {
            
            statement = connect.createStatement();
            String query = "UPDATE login_multiuser SET Saldo = Saldo - "+saldoKirim+" WHERE Username = '"+username+"'";
            
            if (!statement.execute(query)){
                nilai = true;
//                JOptionPane.showMessageDialog(null, "Berhasil Di Update");
            }
            
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nilai;
    }
    public static boolean UserPenerima(String username, int saldoKirim){
        boolean nilai = false;
        
        cConfig.connection();
        
        try {
            
            statement = connect.createStatement();
            String query = "UPDATE login_multiuser SET Saldo = Saldo + "+saldoKirim+" WHERE Username = '"+username+"'";
            
            if (!statement.execute(query)){
                nilai = true;
//                JOptionPane.showMessageDialog(null, "Berhasil Di Update");
            }
            
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nilai;
    }
    
    public static boolean insertHistory(String UsernamePengirim, String usernamePenerima, int Saldo) {
        boolean nilai = false;

        cConfig.connection();

        try {

            statement = connect.createStatement();
            String query = "INSERT INTO transaksi VALUES(" + null + ","
                    + "'" + UsernamePengirim + "',"
                    + "'" + usernamePenerima + "',"
                    + "" + Saldo + ")";

            if (!statement.execute(query)) {
                nilai = true;
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nilai;
    }
    
    public static boolean Input(String userName, String password, String namaRekening, String noRekening, int Saldo, String tipeRekening) {
        boolean nilai = false;

        cConfig.connection();

        try {

            statement = connect.createStatement();
            String query = "insert into login_multiuser values(" 
                    + "'" + userName +"',"
                    + "'" + password+ "',"
                    + "'" + namaRekening+"',"
                    + "'" + noRekening+ "',"
                    + "" + Saldo + ","
                    + "'" + tipeRekening+ "')";

            if (!statement.execute(query)) {
                JOptionPane.showMessageDialog(null, "Berhasil");
                nilai = true;
            }

            statement.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nilai;
    }
    
    
    
    public static boolean UserPenerimaSaldo(String Usersaldo, String noRekening, String namaRekening, int tambahSaldo){
        boolean nilai = false;
        
        cConfig.connection();
        
        try {
            
            statement = connect.createStatement();
            String query = "UPDATE login_multiuser SET Saldo = Saldo + "+tambahSaldo+" "
                    + "WHERE Username = '"+Usersaldo+"'"
                    + "Nama Rekening '"+namaRekening+"'" 
                    +"Nomor Rekening '"+noRekening+"'";
            
            if (!statement.execute(query)){
                nilai = true;
//                JOptionPane.showMessageDialog(null, "Berhasil Di Update");
            }
            
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nilai;
    }
    
    public static boolean update(String userName, int tambahSaldo){
        boolean nilai = false;
        
        cConfig.connection();
        
        try {
            
            statement = connect.createStatement();
            String query = "UPDATE login_multiuser SET Saldo = Saldo + "+tambahSaldo+" "+ "WHERE Username = '"+userName+"'";
            
            if (!statement.execute(query)){
                nilai = true;
//                JOptionPane.showMessageDialog(null, "Berhasil Di Update");
            }
            
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nilai;
    }
}    
