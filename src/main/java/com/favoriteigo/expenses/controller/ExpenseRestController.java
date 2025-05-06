package com.favoriteigo.expenses.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 家計簿情報コントローラ
 *
 * @author イッシー
 * @version 1.0
 * @since 1.0
 */
@RestController
public class ExpenseRestController {

    @GetMapping("/api/index")
    public List<Map<String, Object>> getExpenseList() {
        return List.of(
                Map.of(
                        "id","1",
                        "category","食費",
                        "money","10000",
                        "date","2023-10-01",
                        "memo","昼食代"
                ),
                Map.of(
                        "id","2",
                        "category","家賃",
                        "money","65950",
                        "date","2023-10-01",
                        "memo","昼食代"
                )
        );
    }

}
