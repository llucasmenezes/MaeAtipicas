package MaesAtipicas.MaeAtipicas.controller;

import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import MaesAtipicas.MaeAtipicas.model.MaeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import MaesAtipicas.MaeAtipicas.repository.MaeRepository;
import MaesAtipicas.MaeAtipicas.service.MaeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mae")
public class MaeController {

    @Autowired
    MaeService maeService;

    @Autowired
    MaeRepository maeRepository;

    @GetMapping("/lista")
    public ResponseEntity<List<MaeDTO>> getAll() {
        List<MaeDTO> maeServices = maeService.getAll();
        return ResponseEntity.ok(maeServices);
    }

    @PostMapping("/criar")
    public ResponseEntity<MaeDTO> createMae(@RequestBody MaeDTO maeDTO) {
            maeDTO = maeService.createMae(maeDTO);
            return ResponseEntity.ok(maeDTO);
    }

    @GetMapping("/listar/{id}")  // Buscar mãe por ID
    public ResponseEntity<Optional<MaeDTO>> getMaeById(@PathVariable Long id) {
        Optional<MaeDTO> maeDTO = maeService.getMaeById(id);
        return new ResponseEntity<>(maeDTO, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<MaeDTO> updateMaeById(@PathVariable Long id,@RequestBody MaeDTO atualizarMae){
            MaeDTO updatedMae = maeService.updateMaeById(id, atualizarMae);
            return ResponseEntity.ok(updatedMae);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteMaeById(@PathVariable Long id) {
       maeService.deleteMae(id);
        return ResponseEntity.noContent().build();

    }
}
