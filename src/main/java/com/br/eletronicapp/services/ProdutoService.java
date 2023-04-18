package com.br.eletronicapp.services;

/**
 *
 * @author Evandro
 */
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.eletronicapp.models.Produto;
import com.br.eletronicapp.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ProdutoService {
    
    private final ProdutoRepository repository;

    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }
   

    public void insertProduto(Produto eletronic) {
        repository.save(eletronic);
    }

    public Produto findProdutoById(Integer id) {
        return repository.findById(id).get();
    }

    public Produto updateProduto( Produto eletronic, Integer id) {
        
        Produto model = repository.findById(id).get();
        eletronic.setNome(model.getNome());
        eletronic.setDescricao(model.getDescricao());
        eletronic.setFormaDepagamento(model.getFormaDepagamento());
        //eletronic.setImagem(model.getImagem());
        return repository.save(eletronic);
    }

    public void deleteProdutoById(Integer id) {
        repository.deleteById(id);
    }

    @Autowired
    private FileUploadService  fileUploadService;
    public void updatePicture( Integer id, MultipartFile webFile) {

        try {
            //ver -> application.properties -> file.upload.folder
            File fileDisk = fileUploadService.saveOnDisk(webFile);

            String filePath = fileDisk.getAbsolutePath();

            System.out.println(filePath);

            Produto model = repository.findById(id).get();
            model.setImagem(filePath);


            repository.save(model);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

}
