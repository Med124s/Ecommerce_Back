package com.start.ecom;

import com.start.ecom.EcomRepository.CategoryRepository;
import com.start.ecom.EcomRepository.ProductRepository;
import com.start.ecom.Entity.Categories;
import com.start.ecom.Entity.Products;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	@Autowired
	ProductRepository prodRepos;
	@Autowired
	CategoryRepository catRepos;
	@Autowired
	private RepositoryRestConfiguration reposRestConfig;

	@Override
	public void run(String... args) throws Exception {
		reposRestConfig.exposeIdsFor(Products.class,Categories.class);
	catRepos.save(new Categories(null,"Computer",null,null,null));
	catRepos.save(new Categories(null,"Printer",null,null,null));
	catRepos.save(new Categories(null,"Smart-phone",null,null,null));

	Random rdm = new Random();
	catRepos.findAll().forEach(c->{
		for(int i=0;i<6;i++){
			Products p = new Products();
			p.setName(RandomString.make(6));
			p.setDescription(RandomString.make(12));
			p.setAvailable(rdm.nextBoolean());
			p.setSelected(rdm.nextBoolean());
			p.setPromotion(rdm.nextBoolean());
			p.setCurrentPrice(rdm.nextDouble());
			p.setProductImage("unknow.jpg");
			p.setCate(c);
			prodRepos.save(p);
		}
	});
	}
}
