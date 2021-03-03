package br.com.duckdelivery.duckdelivery.controler;

import br.com.duckdelivery.duckdelivery.model.Entrega;
import br.com.duckdelivery.duckdelivery.model.EntregaTerrea;
import br.com.duckdelivery.duckdelivery.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.duckdelivery.duckdelivery.model.*;
import br.com.duckdelivery.duckdelivery.utils.CarregarBanco;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaControler {

    @GetMapping
    public List<Entrega> listar() {
        if (CarregarBanco.getFretadora().getEntregas().isEmpty()) {
            CarregarBanco.carregarBanco();
            return CarregarBanco.getFretadora().getEntregas();
        } else {
            return CarregarBanco.getFretadora().getEntregas();
        }
    }

    @PostMapping("/entrega-terrea")
    public ResponseEntity<Entrega> solicitarEntregaTerrea(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(produto.getId(),produto.getValor(),produto.getDescricao()));
        Carrinho carrinho = new Carrinho(produtos);
        EntregaTerrea entregaTerrea = new EntregaTerrea(4,"Rua Luiz Mendonsa da Silva Oliveira, 780", 19008.0, carrinho);
        CarregarBanco.getFretadora().adcionarEntrega(entregaTerrea);
        URI uri = uriBuilder.path("/entregas/{id}").buildAndExpand(4).toUri();
        return ResponseEntity.created(uri).body(entregaTerrea);
    }

    @PostMapping("/entrega-maritima")
    public ResponseEntity<Entrega> solicitarEntregaMaritima(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(produto.getId(),produto.getValor(),produto.getDescricao()));
        Carrinho carrinho = new Carrinho(produtos);
        EntregaMaritima entregaMaritima = new EntregaMaritima(5,"Rua Luiz Mendonsa da Silva Oliveira, 780", 19008.0, carrinho);
        CarregarBanco.getFretadora().adcionarEntrega(entregaMaritima);
        URI uri = uriBuilder.path("/entregas/{id}").buildAndExpand(4).toUri();
        return ResponseEntity.created(uri).body(entregaMaritima);
    }

    @PostMapping("/entrega-aerea")
    public ResponseEntity<Entrega> solicitarEntregaAerea(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(produto.getId(),produto.getValor(),produto.getDescricao()));
        Carrinho carrinho = new Carrinho(produtos);
        EntregaAerea entregaAerea = new EntregaAerea(6,"Rua Luiz Mendonsa da Silva Oliveira, 780", 19008.0, carrinho);
        CarregarBanco.getFretadora().adcionarEntrega(entregaAerea);
        URI uri = uriBuilder.path("/entregas/{id}").buildAndExpand(4).toUri();
        return ResponseEntity.created(uri).body(entregaAerea);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> detalhar(@PathVariable Integer id) {
        for (int i = 0;
             i < CarregarBanco.getFretadora().getEntregas().size();
             i++) {
            if (CarregarBanco.getFretadora().getEntregas().get(i).getId() == id) {
                return ResponseEntity.ok().body(CarregarBanco.getFretadora().getEntregas().get(i));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{entregaId}")
    public ResponseEntity<?> cancelarEntrega(@PathVariable Integer entregaId) {
        for (int i = 0;
             i < CarregarBanco.getFretadora().getEntregas().size();
             i++) {
            if (CarregarBanco.getFretadora().getEntregas().get(i).getId() == entregaId) {
                CarregarBanco.getFretadora().cancelarEntrega(i);
                return ResponseEntity.ok().body("Delivery canceled.");
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{entregaId}/{produtoId}")
    public ResponseEntity<?> cancelarEntregaProduto(@PathVariable Integer entregaId,
                                            @PathVariable Integer produtoId) {
        for (int i = 0;
             i < CarregarBanco.getFretadora().getEntregas().size();
             i++) {
            if (CarregarBanco.getFretadora().getEntregas().get(i).getId() == entregaId) {
                CarregarBanco.getFretadora().deletarProduto(entregaId, produtoId);
                return ResponseEntity.ok().body("Product deleted");
            }
        }
        return ResponseEntity.notFound().build();
    }

}
