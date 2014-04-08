package org.struts.test.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created with IntelliJ IDEA.
 * User: ThinkPad
 * Date: 14-4-7
 * Time: 下午11:39
 * To change this template use File | Settings | File Templates.
 */
public class MyDataSource {
    private static String className="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/test";
    private String username="root";
    private String password="root";
    static{
        try{
          Class.forName(className);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        Connection connection=null;
        try{
            connection= DriverManager.getConnection(url,username,password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
