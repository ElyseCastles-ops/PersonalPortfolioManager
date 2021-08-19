package com.citi.training.service;

import com.citi.training.model.StockWrapper;
import org.springframework.stereotype.Service;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class StockService {
    public StockWrapper findStock(final String ticker)
    {
        try
        {
            return new StockWrapper(YahooFinance.get(ticker));
        }
        catch ( IOException e)
        {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public BigDecimal findPrice(final StockWrapper stock) throws IOException
    {
        return stock.getStock().getQuote(true).getPrice();
    }


}
