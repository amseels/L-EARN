/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Conn.getConnection;
import Model.Membership;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class MembershipConn {
    public Membership getMembershipById(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from membership where membership_id =?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        Membership membership = new Membership();
        while  (rs.next()){
            membership.setValidation_status(rs.getString("validation_status"));
            membership.setStart_date(rs.getDate("start_date"));
            membership.setPayment_proof(rs.getString("payment_proof"));
            membership.setExpired_date(rs.getDate("expired_date"));
        }
        return membership;
    }
}
