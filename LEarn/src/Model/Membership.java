/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Membership {
    private String validation_status;
    private Date start_date;
    private String payment_proof;
    private Date expired_date;
    
    public static String[] validation = new String[]{"Valid", "Non-Valid"};

    public String getValidation_status() {
        return validation_status;
    }

    public void setValidation_status(String validation_status) {
        this.validation_status = validation_status;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getPayment_proof() {
        return payment_proof;
    }

    public void setPayment_proof(String payment_proof) {
        this.payment_proof = payment_proof;
    }

    public Date getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(Date expired_date) {
        this.expired_date = expired_date;
    }

    public Membership() {
        validation_status = validation[1];
        java.time.LocalDate local = java.time.LocalDate.now();
        start_date = new Date(local.getYear(), local.getMonthValue(), local.getDayOfMonth());
    }
    
    
}
