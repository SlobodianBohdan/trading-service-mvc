package com.trading.controller;

import com.trading.dto.TradeDto;
import com.trading.mapper.TradeDtoMapper;
import com.trading.model.Trade;
import com.trading.model.TradeStatus;
import com.trading.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/trade")
public class TradeController {

    private TradeService tradeService;

    private TradeDtoMapper mapper;

    @Autowired
    public TradeController(TradeService tradeService, TradeDtoMapper mapper) {
        this.tradeService = tradeService;
        this.mapper = mapper;
    }

    @GetMapping("/home")
    public String showAfterSubmitPage(Model model) {
        return "trade/home";
    }

    @GetMapping({"/list"})
    public String getAll(Model model) {
//        Page<Animal> animalsPage = animalService.getAllByAnimalStatus(pageNumber, AnimalStatus.FREE);
//        PageDto animals = this.mapper.toAnimalsPage(animalsPage);
        List<Trade> trades = tradeService.getAll().stream()
                .filter(trade -> trade.getTradeStatus().equals(TradeStatus.ACTIVE))
                .collect(Collectors.toList());

        model.addAttribute("trades", trades);
        return "trade/list";
    }

    @GetMapping("/formCreate")
    public String getCreateGet() {
        return "trade/formCreate";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute TradeDto tradeDto) {
        tradeService.create(mapper.toEntity(tradeDto));
        return "/trade/home";
    }
}
