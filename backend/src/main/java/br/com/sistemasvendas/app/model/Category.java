package br.com.sistemasvendas.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer id;
    @Column(name = "name_category",length = 100, unique = true)
    private String name;

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
}
