package com.jpapractice01.byidentifier.order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatusIdf {

    PURCHASED(100L, "결제 완료"),
    SHIPPING_READY(200L, "배송준비중");

    private final long code;

    private final String name;

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
