package com.br.eletronicapp.services;

/**
 *
 * @author Evandro
 */

import com.br.eletronicapp.dto.ProdutoDTO;
import com.br.eletronicapp.exceptions.RecordException;
import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.eletronicapp.models.Produto;
import com.br.eletronicapp.repositories.ProdutoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

@Service
@Validated
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ModelMapper modelProdutoMapper;
    private final FileUploadService fileUploadService;
     
    public List<ProdutoDTO> getAllProdutos() {
        return repository.findAll()
                .stream()
                .map(this::produtoMapperDTO)
                .collect(ArrayList::new,
                ArrayList::add, ArrayList::addAll);
    }

    public ProdutoDTO insertProduto(@Valid Produto produto) {
        return produtoMapperDTO(repository.save(produto));
    }

    public ProdutoDTO findProdutoById(@PathVariable @NotNull @Positive Integer id) throws RecordException {
         Produto p = repository.findById(id)
                 .orElseThrow(() -> new RecordException("Product ID not found!"));
         return produtoMapperDTO(p);
    }

    public ProdutoDTO updateProduto(@Valid Produto produto, @NotNull @Positive Integer id) throws RecordException {

        return repository.findById(id).map(newRecord ->{
        newRecord.setNome(produto.getNome());
        newRecord.setDescricao(produto.getDescricao());
        newRecord.setFormaDepagamento(produto.getFormaDepagamento());
        newRecord.setImagem(produto.getImagem());
        newRecord.setEstoque(produto.getEstoque());
        newRecord.setPreco(produto.getPreco());
        return produtoMapperDTO(repository.save(newRecord));
        }).orElseThrow(()-> new RecordException("Id not found!"));
       
    }

    public void deleteProdutoById(@PathVariable @NotNull @Positive Integer id) throws RecordException {
        repository.delete(repository.findById(id).orElseThrow(()-> new RecordException("Id not found!")));
    }
    
    /*
      Atualizando a imagem que está vindo da URI webserve.
      Salnado a imagem no disco.
      Passando a imagem atualizado para o produto específico
    */
    public void updatePicture(@PathVariable @Valid Integer id, MultipartFile webFile) {
        try {
            //Vizualisar no application.properties a configuração no file.upload.folder

            File fileDisk = fileUploadService.saveOnDisk(webFile, id);

            String filePath = fileDisk.getAbsolutePath();

            Produto produto = repository.findById(id).get();

            produto.setImagem(filePath);

            repository.save(produto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
     private ProdutoDTO produtoMapperDTO(Produto produto){
        return modelProdutoMapper.map(produto, ProdutoDTO.class);
    }
}
