package w6.double_dispatch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HtmlOrderViewCreatorTest {

    @Test
    void test() {
        List<Order> orderList = Arrays.asList(new  Order(), new SpecialOrder());
        HtmlOrderViewCreator htmlOrderViewCreator = new HtmlOrderViewCreator();

        orderList.get(0).accept(htmlOrderViewCreator);
        String orderHtml = htmlOrderViewCreator.getHtml();
        orderList.get(1).accept(htmlOrderViewCreator);
        String specialOrderHtml = htmlOrderViewCreator.getHtml();

        assertEquals(orderHtml, "<p>Regular Order</p>");
        assertEquals(specialOrderHtml, "<h1>Special Order</h1>");
    }

}