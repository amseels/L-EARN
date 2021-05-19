/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Conn.getConnection;
import Model.Tutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class TutorConn {
    public Tutor getTutorById(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from tutor where tutor_id =?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        Tutor tutor = new Tutor();
        while  (rs.next()){
            tutor.setEligibility_proof(rs.getString("eligibility_proof"));
            tutor.setRating(rs.getDouble("rating"));
            tutor.setValidation_status(rs.getString("validation_status"));            
        }
        return tutor;
    }   
    public static String getTutorIdByUserId(String u) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from tutor where user_id=?");
        st.setString(1, u);     
        ResultSet rs = st.executeQuery();
        return rs.getString("tutor_id");
    }
    
    public static void postTutor(Tutor t, String uid) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("insert into tutor (eligibility_proof, rating, validation_status, user_id)"+" values(?,?,?,?)");
        st.setString(1, t.getEligibility_proof());
        st.setDouble(2, t.getRating());
        st.setString(3, t.getValidation_status());
        st.setString(4, uid);

        st.execute();
    }
}
