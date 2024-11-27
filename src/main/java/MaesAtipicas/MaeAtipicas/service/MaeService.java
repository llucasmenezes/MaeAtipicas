package MaesAtipicas.MaeAtipicas.service;

import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import MaesAtipicas.MaeAtipicas.exceptions.CpfDuplicadoException;
import MaesAtipicas.MaeAtipicas.exceptions.NoExistsByIdException;
import MaesAtipicas.MaeAtipicas.mapper.MaeMapper;
import MaesAtipicas.MaeAtipicas.model.MaeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import MaesAtipicas.MaeAtipicas.repository.MaeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MaeService {

    @Autowired
    MaeRepository repository;
    @Autowired
    private final MaeMapper maeMapper;

    public MaeService(MaeRepository repository, MaeMapper maeMapper){
        this.repository = repository;
        this.maeMapper = maeMapper;
    }



    public List<MaeDTO> getAll(){
        List<MaeModel> maes = repository.findAll();
        return maes.stream()
                .map(maeMapper::map)
                .collect(Collectors.toList());
    }


    public MaeDTO createMae(MaeDTO maeDTO){
        MaeModel maeModel = maeMapper.map(maeDTO);
        if(repository.existsByCpf(maeDTO.getCpf())) {
            throw new CpfDuplicadoException(maeDTO.getCpf());
        }
        maeModel = repository.save(maeModel);
        return maeMapper.map(maeModel);
    }


    public Optional<MaeDTO> getMaeById(Long id){
        Optional<MaeModel> maePorId = repository.findById(id);

        if(!repository.existsById(id)){
           throw new NoExistsByIdException(id);
        }

        return maePorId.map(maeMapper::map);
    }


    public MaeDTO updateMaeById(Long id, MaeDTO maeDTO) {
        Optional<MaeModel> maeExistente = repository.findById(id);
            if(!maeExistente.isPresent()){
                throw new NoExistsByIdException(id);
            }
                MaeModel maeAtualizado = maeMapper.map(maeDTO);
                maeAtualizado.setId(id);
                MaeModel maeSalva = repository.save(maeAtualizado);

                return maeMapper.map(maeSalva);
        }


    public void deleteMae(Long id){
        if(!repository.existsById(id)){
            throw new NoExistsByIdException(id);
        }
        repository.deleteById(id);
    }
}
