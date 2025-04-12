package com.favoriteigo.expenses.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * 家計簿情報を保持するFormクラス
 *
 * @author イッシー
 * @version 1.0
 * @since 1.0
 */
public class ExpensesForm {

    @NotBlank
    @Size(max = 1, message = "種類は１文字で入力してください")
    private String kind = null;

    private String category = null;

    private int money = 0;

    private LocalDate useDate = null;

    private String memo = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public LocalDate getUseDate() {
        return useDate;
    }

    public void setUseDate(LocalDate useDate) {
        this.useDate = useDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

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
