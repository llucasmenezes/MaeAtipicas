package MaesAtipicas.MaeAtipicas.service;

import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import MaesAtipicas.MaeAtipicas.exceptions.CpfDuplicadoException;
import MaesAtipicas.MaeAtipicas.exceptions.NoExistsById;
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
        if(repository.existsByCpf(maeModel.getCpf())) {
            throw new CpfDuplicadoException(maeModel.getCpf());
        }
        return repository.save(maeModel);
    }

    //findById
    public Optional<MaeModel> getMaeById(Long id){
        if(!repository.existsById(id)){
           throw new NoExistsById(id);
        }

         Optional<MaeModel> maeModel = repository.findById(id);
        return maeModel;
    }

    //updateById
    public MaeModel updateMaeById(Long id, MaeModel atualizarMae) {
            if(!repository.existsById(id)){
                throw new NoExistsById(id);
            }
                atualizarMae.setId(id);
                return repository.save(atualizarMae);
        }

    //delete
    public void deleteMae(Long id){
        if(!repository.existsById(id)){
            throw new NoExistsById(id);
        }
        repository.deleteById(id);
    }
}
