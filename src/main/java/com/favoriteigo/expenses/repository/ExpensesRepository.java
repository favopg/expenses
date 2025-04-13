package com.favoriteigo.expenses.repository;

import com.favoriteigo.expenses.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 家計簿リポジトリクラス
 * @author イッシー
 * @version 1.0
 * @see com.favoriteigo.expenses.entity.Expenses
 * @since 1.0
 */
@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
}
