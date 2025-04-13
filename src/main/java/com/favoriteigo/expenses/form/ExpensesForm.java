package com.favoriteigo.expenses.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 家計簿情報を保持するFormクラス
 *
 * @author イッシー
 * @version 1.0
 * @since 1.0
 */
@Getter
@Setter
public class ExpensesForm {

    @NotBlank
    @Size(max = 1, message = "種類は１文字で入力してください")
    private String kind = null;

    private String category = null;

    private int money = 0;

    private LocalDate useDate = null;

    private String memo = null;

    @Override
    public String toString() {
        return "ExpensesForm{" +
                "kind='" + kind + '\'' +
                ", category='" + category + '\'' +
                ", money=" + money +
                ", useDate=" + useDate +
                ", memo='" + memo + '\'' +
                '}';
    }
}
