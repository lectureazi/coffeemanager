package com.mc.coffeemanager.domain.code;

import com.mc.coffeemanager.domain.coffee.Coffee;

// enum : 열거형
// 서로 연관된 상수들의 집합
// 자바에서의 Enum은 Enum의 자식 클래스로 enum의 메서드가 제공된다.
public enum OrderStatus {

    OK(0, "주문 생성 성공"),
    FAIL_SOLDOUT(1, "품절로 인한 주문 실패"),
    FAIL_STOCK(2, "재고부족으로 인한 주문 실패"),
    OrderStatus(3, "비시즌입니다."),
    COMPLETE(4, "주문처리가 완료되었습니다.");

    private int code;
    private String desc;

    private OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String desc(){
        return desc;
    }

    public static OrderStatus checkStatus(Coffee coffee, int orderCnt) {
        if(coffee.getStock() < orderCnt) return FAIL_STOCK;
        return OK;
    }

    public boolean isOk(){
        return code == OK.code;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
