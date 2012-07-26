package solicitudtaller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    Connection con;
    Statement snt;
    ResultSet rs;
    static String server = "192.168.1.254";
    static String usr = "solicitud2";
    static String pass = "infinito";
    static String db = "solicitud2";
    String url = "jdbc:mysql://"+server+"/"+db;
    
    Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,usr, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String dateFormat(Date ddate){
            java.text.SimpleDateFormat dia = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String Fecha = dia.format(ddate);
            return Fecha;
        }
    
    public String gencod(String sql){
             int cod = 0;
        try {
            snt = con.createStatement();
            rs = snt.executeQuery(sql);
            rs.next() ;
            cod = rs.getInt("newcod");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            return String.valueOf(cod);
   }
    
     public int buscaCod(String sql){
                int aux = 0;
        try {
            snt = con.createStatement();
            rs = snt.executeQuery(sql);
            if (rs.next()) {
                aux = rs.getInt("id");
            }
        } catch (SQLException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return aux;
     }
     
    
}
