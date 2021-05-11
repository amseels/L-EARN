/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Conn.getConnection;
import Model.Answer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class AnswerConn {
    public Answer getAnswerById(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from answer where answer_id =?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        Answer answer = new Answer();
        while  (rs.next()){
            answer.setTime(rs.getDate("time"));
            answer.setContent(rs.getString("content"));
            answer.setRating(rs.getDouble("rating"));            
        }
        return answer;
    }
}

