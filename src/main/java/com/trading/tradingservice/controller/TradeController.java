package com.trading.tradingservice.controller;

import com.trading.tradingservice.dto.PageDto;
import com.trading.tradingservice.dto.ResultDto;
import com.trading.tradingservice.dto.TradeDto;
import com.trading.tradingservice.mapper.TradeDtoMapper;
import com.trading.tradingservice.model.Trade;
import com.trading.tradingservice.model.TradeStatus;
import com.trading.tradingservice.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


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
    @GetMapping("/admin/formCreate")
    public String getCreateForm() {
        return "trade/formCreate";
    }

    @PostMapping("/admin/new")
    public String create(@Valid TradeDto tradeDto, RedirectAttributes redirectAttributes) {
        tradeService.create(mapper.toEntity(tradeDto));
        redirectAttributes.addFlashAttribute("message", "Created new Trade!");
        return "redirect:/trade/list";
    }

    // Update Trade
    @GetMapping("/admin/formUpdate/{tradeId}")
    public String getUpdateForm(@PathVariable Long tradeId, Model model) {
        Trade trade = tradeService.getById(tradeId);
        model.addAttribute("trade", trade);
        return "/trade/formUpdate";
    }

    @PostMapping("/admin/update")
    public String update(@Valid TradeDto tradeDto, RedirectAttributes redirectAttributes) {
        Trade trade = mapper.toEntity(tradeDto);
        tradeService.update(trade);
        redirectAttributes.addFlashAttribute("message", "Update this Trade!");
        return String.format("redirect:/trade/admin/formUpdate/%s", trade.getId());
    }

    // Info Trade
    @GetMapping("/info/{tradeId}")
    public String getById(@PathVariable Long tradeId, Model model) {
        TradeDto tradeDto = mapper.toDto(tradeService.getById(tradeId));
        model.addAttribute("trade", tradeDto);
        return "trade/info";
    }

    // Delete Trade
    @PostMapping("/admin/delete/{tradeId}")
    public String delete(@PathVariable Long tradeId, RedirectAttributes redirectAttributes) {
        tradeService.deleteTradeById(tradeId);
        redirectAttributes.addFlashAttribute("message", "Delete trade was successful!");
        return "redirect:/trade/list";
    }

    //Send in archive trade
    @PostMapping("/admin/archive/{tradeId}")
    public String sendInArchiveTrade(@PathVariable("tradeId") Long tradeId, @Valid ResultDto result, RedirectAttributes redirectAttributes) {
        tradeService.changeStatusFotTrade(tradeId, result.getExpectedResult());
        redirectAttributes.addFlashAttribute("message", "Trade sent to archive!");
        return "redirect:/trade/list";
    }

    @GetMapping({"/archive"})
    public String archiveTrades(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNumber, Model model) {

        Page<Trade> tradesPage = tradeService.getAllWithArchive(pageNumber);
        PageDto trades = this.mapper.toTradesPage(tradesPage);
        model.addAttribute("trades", trades);
        return "trade/archive";
    }

    @GetMapping("/findArchive")
    public String findAllArchive(
            @RequestParam(name = "page", required = false, defaultValue = "1") int pageNumber,
            @RequestParam String currencyPair, Model model) {
        Page<Trade> tradesPage = tradeService.findAllByCurrencyPairArchive(pageNumber, currencyPair);
        PageDto trades = this.mapper.toTradesPage(tradesPage);
        model.addAttribute("trades", trades);
        model.addAttribute("currencyPair", currencyPair);
        return "trade/archive";
    }

    @GetMapping("/findList")
    public String findAllList(
            @RequestParam(name = "page", required = false, defaultValue = "1") int pageNumber,
            @RequestParam String currencyPair, Model model) {
        Page<Trade> tradesPage = tradeService.findAllByCurrencyPairList(pageNumber, currencyPair);
        PageDto trades = this.mapper.toTradesPage(tradesPage);
        model.addAttribute("trades", trades);
        model.addAttribute("currencyPair", currencyPair);
        return "trade/list";
    }

    @GetMapping("/progress")
    public String getProgress(Model model) {
//        List<Trade> trades = tradeService.getAll();
//        model.addAttribute("trades",trades);
        return "trade/progress";
    }
}
