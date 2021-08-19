package com.citi.training;

import com.citi.training.entity.CashTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class addCashTransaction {

    private RestTemplate template = new RestTemplate();

    //@Disabled
    @Test
    public void testPostCashTransaction() throws URISyntaxException {

        CashTransaction transaction = new CashTransaction();
        transaction.setAccountId(1);
        transaction.setAmount(500.00);
        transaction.setDate(Date.valueOf(LocalDate.now()));
        transaction.setName("Amazon");
        transaction.setId(99);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CashTransaction> httpEntity = new HttpEntity<>(transaction, headers);

        URI uri = new URI("http://localhost:8080/cashtransactions/new/");

        CashTransaction ct = template.postForObject(uri, httpEntity, CashTransaction.class);

        assertThat(transaction.getAccountId(),  equalTo(ct.getAccountId()));
    }
}

