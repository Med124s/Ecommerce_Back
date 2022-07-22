package com.start.ecom.EcomRepository;

import com.start.ecom.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Products,Long> {
    @RestResource(path = "searchProduct")
    public List<Products> findByNameContaining(@Param("name") String mc);
    @RestResource(path = "selectedProduct")
    public List<Products> findBySelectedTrue();
    @RestResource(path = "Available")
    public List<Products> findByAvailableTrue();
    @RestResource(path = "notSelected")
    public List<Products> findBySelectedFalse();
    @RestResource(path = "notAvailable")
    public List<Products> findByAvailableFalse();
    @RestResource(path = "promotion")
    public List<Products> findByPromotionTrue();
}
