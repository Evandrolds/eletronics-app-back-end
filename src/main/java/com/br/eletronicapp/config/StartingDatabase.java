package com.br.eletronicapp.config;

import com.br.eletronicapp.repositories.ContatoRepositoty;
import com.br.eletronicapp.models.Contato;
import com.br.eletronicapp.models.Produto;
import com.br.eletronicapp.repositories.ProdutoRepository;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Evandro
 */
@Configuration
@AllArgsConstructor
public class StartingDatabase implements CommandLineRunner {
    @Autowired
    private  ProdutoRepository repository;
    @Autowired
    private  ContatoRepositoty  contatoRepository;
    @Override
    public void run(String... args) throws Exception {
        
        Produto prod = new Produto();
        prod.setId(null);
        prod.setImagem("D:\\WorkSpaceVisualCode\\Eletronic-App\\docs\\assets\\img-CPU.jpg");
        prod.setNome("Computador");
        prod.setDescricao("PC gamer ");
        prod.setEstoque(12);
        prod.setFormaDepagamento("Pagamento a vista com 10% de desconto ou em 12 vezes no cartão");
        prod.setPreco(3700.0);
        
        Produto prod1 = new Produto();
        prod1.setId(null);
        prod1.setImagem("D:\\WorkSpaceVisualCode\\Eletronic-App\\docs\\assets\\img-notebook.jpg");
        prod1.setNome("LepTop");
        prod1.setDescricao("Sammsung ");
        prod1.setEstoque(6);
        prod1.setFormaDepagamento("Pagamento a vista com 10% de desconto ou em 12 vezes no cartão");
        prod1.setPreco(2700.0);
        repository.saveAll(Arrays.asList(prod,prod1));
        
        Contato contato = new Contato();
        contato.setNome("Pedro");
        contato.setAssunto("ConfigDataBase");
        contato.setEmail("evandro@hotmail.com");
        contato.setTelefone("31212131231230");
        contato.setTexto("asdfsdkljfklsafh açsdhfhsdfiohsfh owhfiohdhfad");
        contatoRepository.save(contato);
    }
    
}
