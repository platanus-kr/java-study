package com.jpapractice01.byreference.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {

    PURCHASED(100L, "결제 완료"),
    SHIPPING_READY(200L, "배송준비중")
    ;

    private final long code;

    private final String name;

}
