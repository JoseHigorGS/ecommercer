package br.com.sistemasvendas.app.dto;

import br.com.sistemasvendas.app.dao.ProductDAO;
import br.com.sistemasvendas.app.model.Product;
import br.com.sistemasvendas.app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDAO dao;

    @Override
    public Product saveProduct(Product product) {
        try {
            if (product.getName() != null && product.getName().trim().length() > 0) {
                dao.save(product);
                return product;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG PRODUCT:  " + ex);
        } catch (Exception ex) {
            System.out.println("DEBUG EXCEPTION: " + ex);
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            if (product.getId() != null && product.getName().trim().length() > 0) {
                dao.save(product);
                return product;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG PRODUCT:  " + ex);
        } catch (Exception ex) {
            System.out.println("DEBUG EXCEPTION: " + ex);
        }
        return null;
    }

    @Override
    public Product deleteProduct(Product product) {
        try {
            if (product.getId() != null) {
                dao.delete(product);
                return product;
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG PRODUCT:  " + ex);
        } catch (Exception ex) {
            System.out.println("DEBUG EXCEPTION: " + ex);
        }
        return null;
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return (ArrayList<Product>) dao.findAll();
    }

    @Override
    public ArrayList<Product> getByKey(String key) {
        try {
            if (key != null) {
                return dao.findByNameContaining(key);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("DEBUG PRODUCT:  " + ex);
        } catch (Exception ex) {
            System.out.println("DEBUG EXCEPTION: " + ex);
        }
        return null;
    }
}
