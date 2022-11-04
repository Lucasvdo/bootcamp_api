package br.com.bootcamp.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @NonNull
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @NonNull
    @Column(name = "PRODUCT_VALUE")
    private BigDecimal productValue;

    public Product() {
    }

    public Product(Long productId, @NonNull String productName, @NonNull BigDecimal productValue) {
        this.productId = productId;
        this.productName = productName;
        this.productValue = productValue;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductValue() {
        return productValue;
    }

    public void setProductValue(BigDecimal productValue) {
        this.productValue = productValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!Objects.equals(productId, product.productId)) return false;
        if (!Objects.equals(productName, product.productName)) return false;
        return Objects.equals(productValue, product.productValue);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productValue != null ? productValue.hashCode() : 0);
        return result;
    }
}
