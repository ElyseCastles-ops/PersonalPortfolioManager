package com.citi.training.service;

import com.citi.training.entity.Gainer;
import com.citi.training.entity.Holding;
import com.citi.training.entity.Mover;
import com.citi.training.model.StockWrapper;
import com.citi.training.repo.HoldingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

@Service
public class HoldingServiceImpl implements HoldingService {

    @Autowired
    private HoldingRepository holdingRepository;

    @Autowired
    private StockService stockService;

    @Override
    public Holding getHoldingById(int id) {return holdingRepository.findById(id);}

    @Override
    public Collection<Holding> getHoldingsByAccountId(int accountId) {return  holdingRepository.findByAccountId(accountId);}

    @Override
    public Collection<Holding> getHoldingByAccountTicker(String ticker) {return holdingRepository.findByTicker(ticker);}

    @Override
    public Collection<Holding> getHoldingByAccountQuantity(double quantity){return holdingRepository.findByQuantity(quantity);}

    @Override
    public Collection<Holding> getAllHoldings() {
        return holdingRepository.findAll();
    }

    @Override
    public Holding getHoldingByTickerAndAccountId(String ticker, Integer accountId) {
        return holdingRepository.findByTickerAndAccountId(ticker, accountId);
    }


    @Override
    public Collection<Gainer> getGainersLosers() {
        Collection<Holding> holdings = getAllHoldings();
        List<Gainer> stocks = new ArrayList<>();
        List<String> tickers = new ArrayList<>();
        for (Holding holding : holdings) {
            try {
                StockWrapper stock = stockService.findStock(holding.getTicker());
                if (!tickers.contains(stock.getStock().getSymbol())) {
                    stocks.add(new Gainer(holding.getAccountId(), holding.getTicker(), holding.getQuantity(), stock.getStock().getQuote().getChangeInPercent().doubleValue()));
                    tickers.add(stock.getStock().getSymbol());
                }

            } catch (NullPointerException e) {
                System.out.println("No percent change found for " + holding.getTicker());
            }
        }
        Collections.sort(stocks);
        return stocks;
    }

    @Override
    public Collection<Mover> getMarketMovers() {
        List<Mover> movers = new ArrayList<>();
        movers.add(new Mover("INDU", "Dow Jones",stockService.findStock("INDU").getStock().getQuote().getChangeInPercent().doubleValue()));
        //movers.add(new Mover("IXIC", "Nasdaq", stockService.findStock("IXIC").getStock().getQuote().getChangeInPercent().doubleValue()));
        movers.add(new Mover(".INX", "S&P 500", stockService.findStock("INX").getStock().getQuote().getChangeInPercent().doubleValue()));
        return movers;
    }

}
