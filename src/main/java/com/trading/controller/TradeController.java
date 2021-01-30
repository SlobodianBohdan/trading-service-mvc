package com.trading.controller;

import com.trading.dto.PageDto;
import com.trading.dto.TradeDto;
import com.trading.mapper.TradeDtoMapper;
import com.trading.model.Trade;
import com.trading.model.TradeStatus;
import com.trading.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String getAllActiveTrades(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNumber, Model model) {
        Page<Trade> tradesPage = tradeService.getAllByStatus(pageNumber, TradeStatus.ACTIVE);
        PageDto trades = this.mapper.toTradesPage(tradesPage);
        model.addAttribute("trades", trades);
        return "trade/list";
    }

    // Create Trade
    @GetMapping("/formCreate")
    public String getCreateForm() {
        return "trade/formCreate";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute TradeDto tradeDto, RedirectAttributes redirectAttributes) {
        tradeService.create(mapper.toEntity(tradeDto));
        redirectAttributes.addFlashAttribute("message", "Created new Trade!");
        return "redirect:/trade/list";
    }

    // Update Trade
    @GetMapping("/formUpdate/{tradeId}")
    public String getUpdateForm(@PathVariable Long tradeId, Model model) {
        Trade trade = tradeService.getById(tradeId);
        model.addAttribute("trade", trade);
        return "/trade/formUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute TradeDto tradeDto, RedirectAttributes redirectAttributes) {
        Trade trade = mapper.toEntity(tradeDto);
        tradeService.update(trade);
        redirectAttributes.addFlashAttribute("message", "Update this Trade!");
        return String.format("redirect:/trade/formUpdate/%s", trade.getId());
    }

    // Info Trade
    @GetMapping("/info/{tradeId}")
    public String getById(@PathVariable Long tradeId, Model model) {
        TradeDto tradeDto = mapper.toDto(tradeService.getById(tradeId));
        model.addAttribute("trade", tradeDto);
        return "trade/info";
    }

    // Delete Trade
    @GetMapping("/delete/{tradeId}")
    public String delete(@PathVariable Long tradeId, RedirectAttributes redirectAttributes) {
        tradeService.deleteTradeById(tradeId);
        return "redirect:/trade/list";
    }
}
