package com.produtosAPI.produtosAPI.repository;

import com.produtosAPI.produtosAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);

    void deleteByid(String id);

}
