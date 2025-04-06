package com.favoriteigo.expenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 家計簿アプリ導入
 *
 * @author イッシー
 * @version 1.0
 * @since 1.0
 */
@Controller
public class ExpenseController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "index";
    }


}
