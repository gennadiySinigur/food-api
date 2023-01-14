package com.gennadiysinigur.foodapi.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyRecipe {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    private String title;

    private String category;

    @Column(columnDefinition = "text")
    private String imageAddress;

    private String instruction;

    @ManyToMany(cascade = CascadeType.ALL, fetch = LAZY)
    @JoinTable(
            name = "my_recipe_ingredients",
            joinColumns = @JoinColumn(name = "my_recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    Set<Ingredient> ingredients;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
}
