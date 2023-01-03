/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.DBConnection to edit this template
 */
package gudang.Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Shoffan Darul Mufti
 */


public class DBConnection {
    
    public Connection create_connection(){
        String url = "jdbc:mysql://localhost:3306/gudang";
        String username = "root";
        String password = "";
        
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Database");
            return conn;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
