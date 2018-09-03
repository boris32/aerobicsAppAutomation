package infrastructure;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Boris on 7/22/2018.
 */
public class DataHandler{

    //Connection con = DriverManager.getConnection("jdbc:sqlite:/data/user/0/com.example.boris.myandroidapp/databases/myapp.db", null, null);


public void test() throws SQLException{
        try {
                Class.forName("org.sqlite.JDBC");
                //DriverManager.registerDriver(new org.sqlite.JDBC());

                String dbURL="JDBC:sqlite://data/data/com.example.boris.myandroidapp/databases/myapp";
                Connection conn=DriverManager.getConnection(dbURL);
                if(conn!=null){
                    System.out.println("Connected to the database");
                    DatabaseMetaData dm=(DatabaseMetaData)conn.getMetaData();
                    System.out.println("Driver name: "+dm.getDriverName());
                    System.out.println("Driver version: "+dm.getDriverVersion());
                    System.out.println("Product name: "+dm.getDatabaseProductName());
                    System.out.println("Product version: "+dm.getDatabaseProductVersion());
                    conn.close();
                }
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();}
            catch(SQLException ex){
                ex.printStackTrace();
        }

    }
}
