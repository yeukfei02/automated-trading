import classes.Price;
import classes.Trade;
import tradingalgorithminterface.TradingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Trading implements TradingAlgorithm {
    private final List<Price> priceList = getPriceList();
    public Trade resultTrade = null;

    public void addNewPriceData(Price price) {
        priceList.add(price);
    }

    public void run() {
        if (!priceList.isEmpty()) {
            double sum = 0;

            List<Price> lastFourItemPriceList = priceList.subList(priceList.size() - 4, priceList.size());
            System.out.println("lastFourItemPriceList.size() = " + lastFourItemPriceList.size());
            for (Price priceItem : lastFourItemPriceList) {
                sum += priceItem.getPrice();
            }
            System.out.println("sum = " + sum);

            double average = sum / lastFourItemPriceList.size();
            System.out.println("average = " + average);

            Price lastPriceItem = priceList.get(priceList.size() - 1);
            double lastItemPrice = lastPriceItem.getPrice();
            System.out.println("lastItemPrice = " + lastItemPrice);

            if (average < lastItemPrice) {
                resultTrade = buildTrades(lastPriceItem);
            }
        }

        if (resultTrade != null) {
            String resultTradeProductName = resultTrade.getProductName();
            String resultTradeDirection = resultTrade.getDirection();
            double resultTradePrice = resultTrade.getPrice();
            int resultTradeQuantity = resultTrade.getQuantity();
            System.out.printf("%s,%s,%.2f,%d \n", resultTradeProductName, resultTradeDirection, resultTradePrice, resultTradeQuantity);
        }
    }

    private List<Price> getPriceList() {
        String[] productNameArray = new String[3];
        productNameArray[0] = "C UN";
        productNameArray[1] = "AAPL UW";
        productNameArray[2] = "AAL UW";

        List<Price> priceList = new ArrayList<>();
        for (String productName : productNameArray) {
            Price price = new Price();
            price.setProductName(productName);

            switch (productName) {
                case "C UN":
                    price.setPrice(2201.00);
                    break;
                case "AAPL UW":
                    price.setPrice(2209.00);
                    break;
                case "AAL UW":
                    price.setPrice(7.60);
                    break;
            }
            priceList.add(price);
        }

        Price price = new Price();
        price.setProductName("AAL UW");
        price.setPrice(7.64);

        Price price2 = new Price();
        price2.setProductName("AAL UW");
        price2.setPrice(7.61);

        Price price3 = new Price();
        price3.setProductName("AAL UW");
        price3.setPrice(7.67);

        priceList.add(price);
        priceList.add(price2);
        priceList.add(price3);

        return priceList;
    }

    @Override
    public Trade buildTrades(Price price) {
        Trade trade = new Trade();
        trade.setProductName(price.getProductName());
        trade.setDirection("BUY");
        trade.setPrice(price.getPrice());
        trade.setQuantity(1000);
        return trade;
    }
}
