package br.com.sistemasvendas.app.service;


import br.com.sistemasvendas.app.model.Product;

import java.util.ArrayList;

public interface IProductService{
    public Product saveProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Product product);
    public ArrayList<Product> getAllProduct();
    public ArrayList<Product> getByKey(String key);
}
