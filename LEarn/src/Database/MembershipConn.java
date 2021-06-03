package Database;

import static Database.Conn.getConnection;
import Model.Membership;
import java.sql.*;
import java.util.*;

public class MembershipConn {
    
    public static Membership getMembershipData(ResultSet rs) throws SQLException{
        Membership membership = new Membership();
        
        membership.setValidation_status(rs.getString("validation_status"));
        membership.setStart_date(rs.getDate("start_date"));
        membership.payment_proof = rs.getBlob("payment_proof").getBinaryStream();;
        membership.setExpired_date(rs.getDate("expired_date"));
        
        return membership;
    }
    
    public static Membership getMembershipById(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from membership where membership_id =?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        
        return rs.next() ? getMembershipData(rs): null;
    }
    
    public static Membership getMembershipByDate(String id) throws SQLException {
        // TODo Get member dengan id tersebut, exp date <= current date dan validation status = Valid
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from membership where user_id =? and expired_date<=CURRENT_DATE()");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        return getMembershipData(rs);
    }
    
    public static Membership getMembershipByUserId(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from membership where user_id =?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        
        return rs.next() ? getMembershipData(rs): null;
    }
    public static Membership getMembershipBySubsId(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from membership where subs_id =?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        
        return rs.next() ? getMembershipData(rs): null;
    }
    
    public static void postMembership(Membership m, int sid, int uid) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("insert into membership "
                + "(validation_status, start_date, payment_proof, expired_date, subs_id, user_id)"
                +" values(?,?,?,?,?,?)");
        
        st.setString(1, m.getValidation_status());
        st.setDate(2, m.getStart_date());
        st.setBlob(3, m.payment_proof);
        st.setDate(4, m.getExpired_date());
        st.setInt(5, sid);        
        st.setInt(6, uid);

        st.execute();
    }
}
