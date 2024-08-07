package org.rudradcruze.jpatutorial.jpatuts.controllers;

import org.rudradcruze.jpatutorial.jpatuts.entities.Product;
import org.rudradcruze.jpatutorial.jpatuts.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final int PAGE_SIZE = 5;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts(@RequestParam(defaultValue = "id") String sortBy) {
//        return productRepository.findBy(Sort.by(Sort.Direction.DESC, sortBy, "price", "quantity"));
        return productRepository.findBy(
                Sort.by(
                        Sort.Order.desc(sortBy),
                        Sort.Order.asc("price")
                )
        );
    }

    @GetMapping("/pagination")
    public List<Product> getAllProductsPagination(@RequestParam(defaultValue = "0") int pageNo,
                                                  @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable = PageRequest.of(
                pageNo,
                PAGE_SIZE,
                Sort.by(sortBy).ascending()
        );
        return productRepository.findAll(pageable).getContent();
    }

    @GetMapping("/pagination2")
    public List<Product> getAllProductsPaginationFilter(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy) {

        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(
                        pageNo,
                        PAGE_SIZE,
                        Sort.by(sortBy).ascending()
                )
        );
    }
}
