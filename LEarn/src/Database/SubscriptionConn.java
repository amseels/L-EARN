/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Conn.getConnection;
import Model.Subscription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class SubscriptionConn {
    public Subscription getSubscriptionById(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from subscription where subs_id =?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        Subscription subscription = new Subscription();
        while  (rs.next()){
            subscription.setName(rs.getString("name"));
            subscription.setPrice(rs.getDouble("price"));
            subscription.setValidity_periode(rs.getDouble("validity_periode"));            
        }
        return subscription;
    }   
}
