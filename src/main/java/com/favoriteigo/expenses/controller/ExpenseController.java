package com.favoriteigo.expenses.controller;

import com.favoriteigo.expenses.form.ExpensesForm;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 家計簿アプリ導入
 *
 * @author イッシー
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ExpenseController {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Hello, World!");
        model.addAttribute("expenses", new ExpensesForm());
        return "index";

    }

    @PostMapping("/register")
    public String register(@ModelAttribute("expenses") @Valid ExpensesForm form, BindingResult result, Model model) {
        model.addAttribute("message2", "Hello, World!");
        logger.info(form.toString());

        if (result.hasErrors()) {
            logger.info("バリデーションチェックエラー{}", result.getAllErrors().toString());
            model.addAttribute("errors", result.getAllErrors());
        }

        return "index";
    }

}
