package com.favoriteigo.expenses.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * 家計簿エンティティクラス
 *
 * @author イッシー
 * @version 1.0
 * @since 1.0
 */
@Setter
@Getter
@Entity(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String kind;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Category expenseCategory;

    private BigDecimal money;

    private Date useDate;

    private String memo;

    @Version
    private int version;
}
