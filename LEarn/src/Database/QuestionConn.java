/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Conn.getConnection;
import Model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionConn {
    public static Question getQuestionById(String id) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from question where question_id =?");
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        Question question = new Question();
        while  (rs.next()){
            question.setCategory(rs.getString("category"));
            question.setContent(rs.getString("content"));
            question.setTime(rs.getDate("time"));       
        }
        return question;
    }
    
    public static List<Question> getAllQuestions() throws SQLException{
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from question");
        ResultSet rs = st.executeQuery();
        
        List<Question> questions = new ArrayList<>();
        while  (rs.next()){
            questions.add(getQuestionData(rs));
        }        
        return questions;
    }
    
    public static List<Question> getAllQuestionsByCategory(String category) throws SQLException{
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("select * from question where category =?");
        st.setString(1, category);
        ResultSet rs = st.executeQuery();
        
        List<Question> questions = new ArrayList<>();
        while  (rs.next()){
            questions.add(getQuestionData(rs));
        }        
        return questions;
    }
    
    private static Question getQuestionData(ResultSet rs) throws SQLException{
        Question question = new Question();
        question.setCategory(rs.getString("category"));
        question.setContent(rs.getString("content"));
        question.setTime(rs.getDate("time"));
        question.question_id = rs.getInt("question_id");
        question.user_id = rs.getInt("user_id");
        return question;
    }
    
    public static void postQuestion(Question q, int u) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("insert into question (category, content, time, user_id)"+" values(?,?,?,?)");
        st.setString(1, q.getCategory());
        st.setString(2, q.getContent());
        st.setDate(3, q.getTime());
        st.setInt(4, u);
        
        st.execute();
    }
}
