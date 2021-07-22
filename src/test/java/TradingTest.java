import classes.Price;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class TradingTest {
    @Test
    @Order(1)
    public void haveTradeTest() {
        System.out.println("### haveTradeTest test start ###");

        Price price = new Price();
        price.setProductName("test product");
        price.setPrice(20.22);

        Trading trading = new Trading();
        trading.addNewPriceData(price);
        trading.run();

        System.out.println("trading.resultTrade = " + trading.resultTrade);
        assertNotNull(trading.resultTrade);

        String tradeProductName = trading.resultTrade.getProductName();
        String tradeDirection = trading.resultTrade.getDirection();
        double tradePrice = trading.resultTrade.getPrice();
        int tradeQuantity = trading.resultTrade.getQuantity();
        assertEquals(tradeProductName, "test product");
        assertEquals(tradeDirection, "BUY");
        assertEquals(tradePrice, 20.22);
        assertEquals(tradeQuantity, 1000);

        System.out.println("### haveTradeTest test end ###");
    }

    @Test
    @Order(2)
    public void dontHaveTradeTest() {
        System.out.println("### dontHaveTradeTest test start ###");

        Price price = new Price();
        price.setProductName("test product2");
        price.setPrice(1.1);

        Trading trading = new Trading();
        trading.addNewPriceData(price);
        trading.run();

        System.out.println("trading.resultTrade = " + trading.resultTrade);
        assertNull(trading.resultTrade);

        System.out.println("### dontHaveTradeTest test end ###");
    }
}
