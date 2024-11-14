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
        if (maeServices.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maeServices);
    }

    @PostMapping("/criar")
    public ResponseEntity<MaeModel> createMae(@RequestBody MaeModel maeModel) {
        try {
            MaeModel maeSave = maeService.createMae(maeModel);
            if (maeSave != null) {
                return ResponseEntity.ok().body(maeSave);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/listar/{id}")  // Buscar mãe por ID
    public ResponseEntity<MaeModel> getMaeById(@PathVariable Long id) {
        MaeModel maeFind = maeService.getMaeById(id);
        if (maeFind == null || maeFind.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(maeFind, HttpStatus.OK);
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<MaeModel> updateMaeById(@PathVariable Long id,@RequestBody MaeModel atualizarMae){
        try {
            MaeModel updatedMae = maeService.updateMaeById(id, atualizarMae);
            return ResponseEntity.ok(updatedMae);

        }catch(RuntimeException e){

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteMaeById(@PathVariable Long id) {
        if(maeService.getMaeById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Mae com o ID: " + id + " " + maeService.getMaeById(id) + maeService.deleteMae(id) + " foi deletada com sucesso");
    }
}
