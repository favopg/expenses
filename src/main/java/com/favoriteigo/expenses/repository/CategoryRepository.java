package com.favoriteigo.expenses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.favoriteigo.expenses.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}