package controller;

import Service.ProdutoService;
import model.Produto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listarProdutos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto > buscarProdutoPorId(@PathVariable Long id){

        Optional<Produto> produto = produtoService.buscarProdutoporId(id);

        if(produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }
        return ResponseEntity.notFound().build();
    }
}
