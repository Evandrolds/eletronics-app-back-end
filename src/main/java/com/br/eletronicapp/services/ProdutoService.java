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
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public List<Produto> getAllProdutos() {
        return repository.findAll();
    }

    public void insertProduto(Produto produto) {
        repository.save(produto);
    }

    public Produto findProdutoById(Integer id) {
        Optional<Produto> p = repository.findById(id);
        return p.get();
    }

    public Produto updateProduto(Produto produto, Integer id) {

        Produto model = repository.findById(id).get();
        model.setNome(produto.getNome());
        model.setDescricao(produto.getDescricao());
        model.setFormaDepagamento(produto.getFormaDepagamento());
        model.setImagem(produto.getImagem());
        return repository.save(model);
    }

    public void deleteProdutoById(Integer id) {
        repository.deleteById(id);
    }
    // Loading product images

    @Autowired
    private FileUploadService fileUploadService;

    public void updatePicture(Integer id, MultipartFile webFile) {
        try {
            //ver -> application.properties -> file.upload.folder

            File fileDisk = fileUploadService.saveOnDisk(webFile, id);

            String filePath = fileDisk.getAbsolutePath();

            Produto produto = repository.findById(id).get();

            produto.setImagem(filePath);

            repository.save(produto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
