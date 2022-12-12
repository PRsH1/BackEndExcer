package net.skhu.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Jumoon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    
    
    int quantity;
    
    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;
    
 
}
