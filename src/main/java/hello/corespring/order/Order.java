package hello.corespring.order;

// 주문 엔티티
public class Order {

    private Long memberId;      // 회원 번호
    private String itemName;    // 상품 명
    private int itemPrice;      // 상품 가격
    private int discountPrice;  // 할인

    // 생성자
    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    // 상품의 가격 - 할인 가격을 해주는 계산 로직
    public int calculatePrice() {
        return itemPrice - discountPrice;
    }

    // memberId, itemName, itemPrice, discountPrice의 getter, setter
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    // lec) order 객체 자체를 출력할 경우 toString이 호출된다.
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
