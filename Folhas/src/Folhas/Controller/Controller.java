package com.exemple.Folhas;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import Folhas.DTO.DTO;
import Folhas.Model.FolhasModel;
import Folhas.Repository.IntRepository;

@RestController
@RequestMapping("Folhas")  // Changed the path to reflect "Folhas"
public class Controller {

    @Autowired
    private IntRepository folhasRepository;
    
    @Autowired
    private DTO dto;
    // Changed to FolhasRepository

    @PostMapping
    public ResponseEntity<FolhasModel> createFolha(@RequestMapping DTO folhasDTO) {  // Changed method and DTO
        FolhasModel folha = new FolhasModel();  // Changed to FolhaModel
        folha.setNome(dto.nome());
        folha.setTipo(dto.tipo());
        folha.setFormato(dto.formato());
        folha.setCor(dto.cor());
        folha.setTamanho(dto.tamanho());
        folha.setTextura(dto.textura());
        FolhasModel savedFolha = folhasRepository.save(folha);
        return new ResponseEntity<>(savedFolha, HttpStatus.CREATED);
    }

    @GetMapping
    public List<FolhaModel> getAllFolhas() {  // Changed method and return type
        return folhaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FolhasModel> getFolhaById(@PathVariable UUID id) {  // Changed method and model
        Optional<FolhasModel> folhasOptional = folhasRepository.findById(id);
        if (folhasOptional.isPresent()) {
            return new ResponseEntity<>(folhasOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FolhasModel> updateFolha(@PathVariable UUID id, @RequestBody FolhasDTO folhasDTO) {  // Changed method
        Optional<FolhasModel> folhaOptional = folhasRepository.findById(id);
        if (folhaOptional.isPresent()) {
            FolhasModel folha = folhasOptional.get();
            folha.setNome(dto.nome());
            folha.setTipo(dto.nome());
            folha.setFormato(dto.formato());
            folha.setCor(dto.cor());
            folha.setTamanho(dto.tamanho());
            folha.setTextura(dto.textura());
            FolhasModel updatedFolha = folhasRepository.save(folha);
            return new ResponseEntity<>(updatedFolha, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFolhas(@PathVariable UUID id) {  // Changed method and model
        Optional<FolhasModel> folhasOptional = folhasRepository.findById(id);
        if (folhasOptional.isPresent()) {
            folhasRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
