/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Conn.getConnection;
import Model.Tutor_Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class Tutor_PaymentConn {
    public static Tutor_Payment getUserById(String uid) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from user where user_id=?");
        st.setString(1, uid);
        ResultSet rs = st.executeQuery();
        Tutor_Payment tutor_Payment = new Tutor_Payment();
        while  (rs.next()){
            tutor_Payment.setInput_time(rs.getDate("input_time"));
            tutor_Payment.setPayment_time(rs.getDate("payment_time"));
            tutor_Payment.setPayment_status(rs.getString("payment_status"));
            tutor_Payment.setAmount(rs.getDouble("amount"));
        }
        return tutor_Payment;
    }
}
