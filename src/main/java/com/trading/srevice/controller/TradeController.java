package com.trading.srevice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trade")
public class TradeController {

    @GetMapping("/home")
    public String showAfterSubmitPage(Model model) {
        return "trade/home";
    }
}
