package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity  
@Table(name="ADDRESSES_T")  
public class Address {  
    @Id   
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name="ADDRESS_ID")
    private int Id;  
    
    @Column(name="CITY")
    private String city;  
    
    @Column(name="STATE")
    private String state;  
    
    @ManyToOne 
    @JoinColumn(name="STUDENT_ID")
    private Student student;  
}  
