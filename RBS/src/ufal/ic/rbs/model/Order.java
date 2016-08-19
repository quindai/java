/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ufal.ic.rbs.model;

import java.sql.Timestamp;
import java.util.Calendar;

public class Order {
	
//	private int id;
    private double amount, amount_paid;
    private String order_date;
    private EnumPaymntType paymntType;

    public Order(double amount, double amount_paid, String order_date, EnumPaymntType paymntType) {
        this.amount = amount;
        this.amount_paid = amount_paid;
        this.paymntType = paymntType;
        this.order_date = order_date;
    }
        
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
    public String getOrder_date() {
            return order_date;
    }
    public void setOrder_date(String order_date) {
            this.order_date = order_date ;
    }
    public double getAmount() {
            return amount;
    }
    public void setAmount(double amount) {
            this.amount = amount;
    }
    public double getAmount_paid() {
            return amount_paid;
    }
    public void setAmount_paid(double amount_paid) {
            this.amount_paid = amount_paid;
    }
    public EnumPaymntType getPaymntType() {
            return paymntType;
    }
    public void setPaymntType(EnumPaymntType paymntType) {
            this.paymntType = paymntType;
    }

    @Override
    public String toString() {
            return "Orders [order_date=" + order_date + ", amount="
                            + amount + ", amount_paid=" + amount_paid + ", paymntType="
                            + paymntType + "]";
    }



}
