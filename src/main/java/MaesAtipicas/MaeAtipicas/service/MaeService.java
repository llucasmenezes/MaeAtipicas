package MaesAtipicas.MaeAtipicas.service;

import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import lombok.AllArgsConstructor;
import MaesAtipicas.MaeAtipicas.model.MaeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MaesAtipicas.MaeAtipicas.repository.MaeRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MaeService {

    @Autowired
    MaeRepository repository;

    public MaeDTO convertToDTO(MaeModel maeModel) {
        return new MaeDTO(
                maeModel.getId(),
                maeModel.getCpf(),
                maeModel.getName(),
                maeModel.getLastName()
        );
    }

    //findALl
    public List<MaeModel> getAll(){
        return repository.findAll();
    }

    //create
    public MaeModel createMae(MaeModel maeModel){
        if(maeModel.getId() != null) {
            throw new IllegalArgumentException("Já existe");
        }
        return repository.save(maeModel);
    }

    //findById
    public MaeModel getMaeById(Long id){
        Optional<MaeModel> maeModel = repository.findById(id);
        return maeModel.orElse(null);
    }

    //updateById
    public MaeModel updateMaeById(Long id, MaeModel atualizarMae) {
            if(!repository.existsById(id)){
                throw new IllegalArgumentException("Id nao encontrado!");
            } else{
                atualizarMae.setId(id);
                return repository.save(atualizarMae);
            }
        }

    //delete
    public Optional<Void> deleteMae(Long id){
        repository.deleteById(id);
        return null;
    }
}
