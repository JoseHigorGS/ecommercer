package br.com.sistemasvendas.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;
    @Column(name = "name_product", length = 100)
    private String name;
    @Column(name = "details_product")
    private String details;
    @Column(name = "picture_product",length = 256,unique = true)
    private String picture;
    @Column(name = "price_product")
    private Double price;
    @Column(name = "available_product", length = 1)
    private Integer available;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category idCategory;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }
}
