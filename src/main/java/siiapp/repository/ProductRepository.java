package siiapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import siiapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
