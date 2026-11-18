package com.platform.practicepc2.shared.infrastructure.persistence.jpa.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Embeddable
public class AssetValuePersistenceEmbeddable {

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "currency", nullable = false)
    private String currency;

    // constructor without parameters

    public AssetValuePersistenceEmbeddable() {
    }

    // constructor with parameters

    public AssetValuePersistenceEmbeddable(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

}
