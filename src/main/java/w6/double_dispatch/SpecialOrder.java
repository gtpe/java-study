package w6.double_dispatch;

public class SpecialOrder extends Order {

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this);
    }

}
