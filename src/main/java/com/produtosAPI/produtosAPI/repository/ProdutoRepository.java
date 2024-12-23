package com.produtosAPI.produtosAPI.repository;

import com.produtosAPI.produtosAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    void deleteByid(String id);
}
