package Service;
import model.Produto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProdutoService {

    private final List<Produto> produtos = new ArrayList<>();
    private  final AtomicLong contadorId = new AtomicLong(0);

    public  ProdutoService(){

        produtos.add(new Produto(
                contadorId.incrementAndGet(),
                "Condicionador Coiffer",
                "Condicionador para uso diario",
                44.90,
                15
                )
        );

        produtos.add(new Produto(
                contadorId.incrementAndGet(),
                "Shampoo Coiffer",
                "Shampoo para cuidados capilares",
                39.90,
                20
        ));
    }

    public List<Produto> listarProdutos(){
        return produtos;
    }

    public Optional<Produto> buscarProdutoporId(Long id){
        return produtos.stream().filter(produto -> produto.getId().equals(id)).findFirst();
    }
}
