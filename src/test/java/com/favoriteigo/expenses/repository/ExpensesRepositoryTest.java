package com.favoriteigo.expenses.repository;

import com.favoriteigo.expenses.entity.Category;
import com.favoriteigo.expenses.entity.Expenses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 家計簿リポジトリテストクラス
 *
 * @author イッシー
 * @version 1.0
 * @see ExpensesRepository
 * @since 1.0
 */
@SpringBootTest
public class ExpensesRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    @Test
    @DisplayName("家計簿テーブルに登録できること")
    public void saveTest() {

        // カテゴリーテーブル登録
        Category category = new Category();
        category.setName("生活費");
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        Category savedCategory = categoryRepository.save(category);

        // 家計簿テーブル登録
        Expenses expense = new Expenses();
        expense.setKind("expense");
        expense.setUseDate(Date.valueOf(LocalDate.now()));
        expense.setMoney(new BigDecimal("5000"));
        expense.setMemo("食料品代");
        expense.setExpenseCategory(savedCategory); // Categoryに関連付け

        Expenses savedExpenses = expensesRepository.save(expense);

        assertThat(savedExpenses).isNotNull();

        // テスト後にデータ削除
        expensesRepository.delete(savedExpenses);
        categoryRepository.delete(savedCategory);

    }

    @Test
    @DisplayName("カテゴリーエンティティから家計簿テーブルに登録できること")
    public void saveFromCategoryTest() {

        // カテゴリーテーブル登録
        Category category = new Category();
        category.setName("生活費");
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());

        // 家計簿テーブル登録
        List<Expenses> expenses = new ArrayList<>();
        Expenses expense = new Expenses();
        expense.setKind("expense");
        expense.setUseDate(Date.valueOf(LocalDate.now()));
        expense.setMoney(new BigDecimal("5000"));
        expense.setMemo("食料品代");
        expense.setExpenseCategory(category); // Categoryに関連付け
        expenses.add(expense);
        category.setExpenses(expenses);

        // カテゴリーエンティティ登録処理で家計簿テーブルにも登録
        Category savedCategory = categoryRepository.save(category);
        assertThat(savedCategory).isNotNull();

        // テスト後にデータ削除
        categoryRepository.delete(savedCategory);

        // 削除できていることを確認
        assertThat(categoryRepository.findById(savedCategory.getId())).isNotPresent();

    }

}
