package com.start.ecom.EcomRepository;

import com.start.ecom.Entity.Categories;
import com.start.ecom.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Categories,Long> {
    @RestResource(path = "searchCategory")
    public List<Categories> findByNameContaining(@Param("name") String mc);
}
