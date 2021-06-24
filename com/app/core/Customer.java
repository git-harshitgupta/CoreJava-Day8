package com.app.core;

import en.CustomerTypeEnum;
import exeception.CustomerHandlingException;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Customer{
    public static SimpleDateFormat sdf;

    static{
        sdf=new SimpleDateFormat("dd-MM-yyyy");
    }
    private String customerName;
    private String emailAddress;
    private String password;
    private int registrationAmmount;
    private Date dateOfBirth;
    private CustomerTypeEnum customerType;


    public Customer(String customerName, String emailAddress, String password, int registrationAmmount, Date dateOfBirth){
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.registrationAmmount = registrationAmmount;
        this.dateOfBirth = dateOfBirth;
        switch(registrationAmmount){
            case 100:
                customerType = CustomerTypeEnum.SILVER;
                break;
            case 150:
                customerType = CustomerTypeEnum.GOLD;
                break;
            case 200:
                customerType = CustomerTypeEnum.PLATINUM;
                break;
        }
    }



    public Customer(String next, String emailAddress, String password, Date date) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return "Customer name: " + customerName + 
                ", email address: " + emailAddress + 
                ", customer type: " +customerType+
                ". Date of birth: " + sdf.format(dateOfBirth);
    }

    public Customer(String emailAddress) {
        this.emailAddress = emailAddress;
    }


}
