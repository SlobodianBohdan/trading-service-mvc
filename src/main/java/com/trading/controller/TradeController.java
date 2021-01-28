package com.trading.controller;

import com.trading.dto.TradeDto;
import com.trading.mapper.TradeDtoMapper;
import com.trading.model.Trade;
import com.trading.model.TradeStatus;
import com.trading.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Trade> trades = tradeService.getAllByStatus(TradeStatus.ACTIVE);
        model.addAttribute("trades", trades);
        return "trade/list";
    }

    // Create Trade
    @GetMapping("/formCreate")
    public String getCreateGet() {
        return "trade/formCreate";
    }

    @GetMapping("/new")
    public String create(@ModelAttribute TradeDto tradeDto) {
        tradeService.create(mapper.toEntity(tradeDto));
        return "/trade/home";
    }

    // Update Trade
    @GetMapping("/formUpdate/{animalId}")
    public String getUpdateForm(@PathVariable Long tradeId, Model model) {
        Trade trade = tradeService.getById(tradeId);
        model.addAttribute("trade", trade);
        return "/trade/formUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("Trade") Trade trade) {
        tradeService.update(trade);
        return String.format("redirect:/trade/%s", trade.getId());
    }

    // Info Trade
    @GetMapping("/info/{tradeId}")
    public String getById(@PathVariable Long tradeId, Model model) {
        TradeDto tradeDto = mapper.toDto(tradeService.getById(tradeId));
        model.addAttribute("trade", tradeDto);
        return "trade/info";
    }
}
