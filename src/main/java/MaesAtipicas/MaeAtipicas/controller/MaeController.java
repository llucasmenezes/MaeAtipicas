package MaesAtipicas.MaeAtipicas.controller;

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
    public ResponseEntity<List<MaeModel>> getAll() {
        List<MaeModel> maeServices = maeService.getAll();
        return ResponseEntity.ok(maeServices);
    }

    @PostMapping("/criar")
    public ResponseEntity<MaeModel> createMae(@RequestBody MaeModel maeModel) {
            MaeModel maeSave = maeService.createMae(maeModel);
            return ResponseEntity.ok(maeSave);
    }

    @GetMapping("/listar/{id}")  // Buscar mãe por ID
    public ResponseEntity<Optional<MaeModel>> getMaeById(@PathVariable Long id) {
        Optional<MaeModel> maeFind = maeService.getMaeById(id);
        return new ResponseEntity<>(maeFind, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<MaeModel> updateMaeById(@PathVariable Long id,@RequestBody MaeModel atualizarMae){
            MaeModel updatedMae = maeService.updateMaeById(id, atualizarMae);
            return ResponseEntity.ok(updatedMae);

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteMaeById(@PathVariable Long id) {
       maeService.deleteMae(id);
        return ResponseEntity.noContent().build();

    }
}
