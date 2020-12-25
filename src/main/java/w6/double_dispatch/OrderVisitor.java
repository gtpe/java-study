package w6.double_dispatch;

public interface OrderVisitor {

    void visit(Order order);

    void visit(SpecialOrder order);

}
