package com.produtosAPI.produtosAPI.controller;

import com.produtosAPI.produtosAPI.model.Produto;
import com.produtosAPI.produtosAPI.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido" + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterporID(@PathVariable ("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public String deletar(@PathVariable ("id") String id) {
        produtoRepository.deleteById(id);
        return "Produto Deletado";
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);

    }

    @GetMapping
    public List<Produto> buscar(@RequestParam ("nome")String nome){
        return produtoRepository.findByNome(nome);
    }

}
