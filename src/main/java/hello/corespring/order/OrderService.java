package hello.corespring.order;

// 주문 서비스 인터페이스(=역할)
public interface OrderService {

    // 주문 생성
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
