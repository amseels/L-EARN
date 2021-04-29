/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.*;
import learn.User;


/**
 *
 * @author ASUS
 */
public class Conn {
    public final static String path = "jdbc:mysql://localhost:3306/l-earn";
    public final static String username = "root";
    public final static String password = "";
    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(path, username,password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
    public static User getUserById(String uid) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from user where user_id=?");
        st.setString(1, uid);
        ResultSet rs = st.executeQuery();
        User user = new User();
        while  (rs.next()){
            user.setPassword(rs.getString("password"));
            user.setBio(rs.getString("bio"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setRole(rs.getString("role"));
        }
        return user;
    }
    
    public static User getUserByUsername(String uname) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from user where username=?");
        st.setString(1, uname);
        ResultSet rs = st.executeQuery();
        User user = new User();
        while  (rs.next()){
            user.setPassword(rs.getString("password"));
            user.setBio(rs.getString("bio"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setRole(rs.getString("role"));
        }
        return user;
    }
    
    public static User getUserByUsernameAndPassword(String uname, String pass) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from user where username=? and password=?");
        st.setString(1, uname);
        st.setString(2, pass);        
        ResultSet rs = st.executeQuery();
        User user = new User();
        while  (rs.next()){
            user.setPassword(rs.getString("password"));
            user.setBio(rs.getString("bio"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setRole(rs.getString("role"));
        }
        return user;
    }
}  