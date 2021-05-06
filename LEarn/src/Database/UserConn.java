/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Conn.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import learn.User;

/**
 * Berisi function get yang berkaitan dengan class User
 * @author Anas
 */
public class UserConn {

    /**
     * Untuk mencari user menggunakan user id, output berupa object user
     * @param uid
     * @return
     * @throws SQLException
     */
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
    
    /**
     * Untuk mencari user menggunakan username, output berupa object user
     * @param uname
     * @return
     * @throws SQLException
     */
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
    
    /**
     * Untuk mencari user menggunakan username dan password, output berupa object user
     * @param uname
     * @param pass
     * @return
     * @throws SQLException
     */
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
