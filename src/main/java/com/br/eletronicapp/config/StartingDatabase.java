package com.br.eletronicapp.config;


import com.br.eletronicapp.models.Produto;
import com.br.eletronicapp.repositories.ContatoRepositoty;
import com.br.eletronicapp.repositories.ProdutoRepository;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@AllArgsConstructor
public class StartingDatabase implements CommandLineRunner {
//    @Autowired
//    private  ProdutoRepository repository;
//    @Autowired
//    private  ContatoRepositoty  contatoRepository;
//    @Override
    public void run(String... args) throws Exception {
        
        // Produto
        Produto prod = new Produto();
        prod.setId(null);
        prod.setImagem("D:\\NetBeansProjects\\assets\\produto-0001.jpg");
        prod.setNome("PC Gamer ");
        prod.setDescricao("Processador i7 3.8GHZ");
        prod.setEstoque(12);
        prod.setFormaDepagamento("Pagamento a vista com 10% de desconto ou em 12 vezes de R$ 225,00 no cartão");
        prod.setPreco(2700.0);
        
        // Produto 1
        Produto prod1 = new Produto();
        prod1.setId(null);
        prod1.setImagem("D:\\NetBeansProjects\\assets\\produto-0002.jpg");
        prod1.setNome("Notbook samsung ");
        prod1.setDescricao("Notebook 15.6 Book E30 Core I3-10110u 4gb 1TB Windows-10 Prata,"
                + " O que você precisa saber sobre este produto\n" +
                 " Processador Intel.\n" +
                 " Memória RAM de 4GB.\n" +
                 " Tela LED de 15.6\".\n" +
                 " A duração da bateria depende do uso que se dê ao produto.");
        prod1.setEstoque(3);
        prod1.setFormaDepagamento("em 12x R$290,84");
        prod1.setPreco(2999.9);
        
        // Produto 3
        Produto prod2 = new Produto();
        prod2.setId(null);
        prod2.setImagem("D:\\NetBeansProjects\\assets\\produto-0003.jpg");
        prod2.setNome("Cabo HDMI Preto");
        prod2 .setDescricao("Cabo HDMI medida 5m");
        prod2 .setEstoque(12);
        prod2.setFormaDepagamento("a vista");
        prod2 .setPreco(17.0);
       
        
        // Produto 3
        Produto prod3 = new Produto();
        prod3.setId(null);
        prod3.setImagem("D:\\NetBeansProjects\\assets\\produto-0004.jpg");
        prod3.setNome("Cabo sata vermelho");
        prod3.setDescricao("Cabo sata vermelho tamanho 45cm");
        prod3.setEstoque(6);
        prod3.setFormaDepagamento("a vista");
        prod3.setPreco(12.0);
       
         // Produto 4
        Produto prod4 = new Produto();
        prod4.setId(null);
        prod4.setImagem("D:\\NetBeansProjects\\assets\\produto-0005.jpg");
        prod4.setNome("Font ATX Real");
        prod4.setDescricao("Fonte atx CORSAIR 750 WATS ");
        prod4.setEstoque(6);
        prod4.setFormaDepagamento("Pagamento a vista no Pix com 15% R$ R$619,00 ou em até 12x de R$ 60,69 sem juros no cartão ");
        prod4.setPreco(728.24);
        //repository.saveAll(Arrays.asList(prod,prod1,prod2,prod3,prod4));
        
        
    }
    
}