package br.com.duckdelivery.duckdelivery.controler;

import br.com.duckdelivery.duckdelivery.model.Entrega;
import br.com.duckdelivery.duckdelivery.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.duckdelivery.duckdelivery.utils.CarregarBanco;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregasControler {

    @GetMapping
    public List<Entrega> listar() {
        if (CarregarBanco.getFretadora().getEntregas().isEmpty()) {
            CarregarBanco.carregarBanco();
            return CarregarBanco.getFretadora().getEntregas();
        } else {
            return CarregarBanco.getFretadora().getEntregas();
        }
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
    public ResponseEntity<?> deletarProduto(@PathVariable Integer entregaId,
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
