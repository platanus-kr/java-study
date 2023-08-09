package com.jpapractice01.byreference.order;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OrderCustomer {
    private String name;

    private String celPhoneNumber;

    private String telPhoneNumber;
    
    private String orderCustomer;
}
