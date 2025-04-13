package com.favoriteigo.expenses.repository;

import com.favoriteigo.expenses.entity.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * カテゴリーリポジトリテストクラス
 *
 * @author イッシー
 * @version 1.0
 * @see CategoryRepository
 * @since 1.0
 */
@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("登録できることを確認")
    public void saveTest() {
        Category category = new Category();
        category.setName("家賃");
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());

        // 登録できることを確認
        category = categoryRepository.save(category);
        assertThat(category.getId()).isGreaterThan(0);

        // 登録情報を取得できることを確認
        Optional<Category> savedCategory = categoryRepository.findById(category.getId());
        assertThat(savedCategory).isPresent();

        // テスト後は削除する
        categoryRepository.delete(savedCategory.get());

        //　削除されていることを確認
        assertThat(categoryRepository.findById(category.getId())).isNotPresent();
    }
}
