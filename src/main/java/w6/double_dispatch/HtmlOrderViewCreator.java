package w6.double_dispatch;

public class HtmlOrderViewCreator implements OrderVisitor {

    private String html;

    public String getHtml() {
        return html;
    }

    @Override
    public void visit(Order order) {
        html = "<p>Regular Order</p>";
    }

    @Override
    public void visit(SpecialOrder order) {
        html = "<h1>Special Order</h1>";
    }

}
