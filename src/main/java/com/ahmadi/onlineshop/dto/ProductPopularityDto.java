package com.ahmadi.onlineshop.dto;

public class ProductPopularityDto {
    private Long productId;
    private Long totalSold;

    public ProductPopularityDto(Long productId, Long totalSold) {
        this.productId = productId;
        this.totalSold = totalSold;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(Long totalSold) {
        this.totalSold = totalSold;
    }
}