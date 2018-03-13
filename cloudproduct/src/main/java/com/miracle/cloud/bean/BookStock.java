package com.miracle.cloud.bean;

public class BookStock {
    private String isbn;

    private Integer stock;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}