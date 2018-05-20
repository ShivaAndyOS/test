package com.invia.serveasy.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vehicle")
public class Vehicle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;

    @NotNull
    private String vehicle_name;

    @NotNull
    private double vehicle_price;

    @NotNull
    private String currency_unit;

    @NotNull
    private String  currency_type;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacture_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Manufacture manufacture_id;

    /*
     * 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Post post;
    
    */

    // Getters and Setters (Omitted for brevity)
    
  /*   {
"vehicle_name": "BMW 5 Series",
"vehicle_price": 2.62,
"currency_unit": "INR",
"currency_type": "Lakhs",
"manufacture_id": "10"
}
     */
}
