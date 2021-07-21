package tradingalgorithminterface;

import classes.Price;
import classes.Trade;

public interface TradingAlgorithm {
    Trade buildTrades(Price price);
}
