package w6.double_dispatch;

public class Order implements Visitable<OrderVisitor> {

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this);
    }

}
