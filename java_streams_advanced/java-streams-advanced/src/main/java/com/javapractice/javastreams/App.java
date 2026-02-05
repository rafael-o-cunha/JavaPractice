package com.javapractice.javastreams;

import com.javapractice.domain.data.DataFactory;

public class App 
{
    public static void main( String[] args ){
        DataFactory db = new DataFactory();
        
        db.selectAllCustomers().forEach(System.out::println);
        
        System.out.println();
        
        db.selectAllOrders().forEach(System.out::println);
        
        System.out.println();
        
        db.selectAllProducts().forEach(System.out::println);
        
    }
}
