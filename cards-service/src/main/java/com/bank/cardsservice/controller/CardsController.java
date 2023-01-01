package com.bank.cardsservice.controller;

import com.bank.cardsservice.model.Cards;
import com.bank.cardsservice.model.Customer;
import com.bank.cardsservice.respoitory.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {
    private final CardsRepository cardsRepository;


    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer){
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());

        if(cards != null){
            return cards;
        } else {
            return null;
        }
    }
}
