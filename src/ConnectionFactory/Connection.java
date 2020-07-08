 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andrey
 */
public class Connection {
    
    public static java.sql.Connection getConnection(){
        final String myServer = "jdbc:mysql://localhost/biblioteca";
        final String user = "root";
        final String psw = "";
        
        try{
            return DriverManager.getConnection(myServer, user, psw);
        }catch(SQLException error){
            throw new RuntimeException(error);
        }
        
    }
    
}
