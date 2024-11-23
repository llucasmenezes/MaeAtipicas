package MaesAtipicas.MaeAtipicas.service;

import MaesAtipicas.MaeAtipicas.DTO.MaeDTO;
import MaesAtipicas.MaeAtipicas.exceptions.CpfDuplicadoException;
import MaesAtipicas.MaeAtipicas.exceptions.NoExistsById;
import MaesAtipicas.MaeAtipicas.mapper.MaeMapper;
import MaesAtipicas.MaeAtipicas.model.MaeModel;
import org.springframework.stereotype.Service;
import MaesAtipicas.MaeAtipicas.repository.MaeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MaeService {


    MaeRepository repository;
    private final MaeMapper maeMapper;

    public MaeService(MaeRepository repository, MaeMapper maeMapper){
        this.repository = repository;
        this.maeMapper = maeMapper;
    }


    //findALl
    public List<MaeDTO> getAll(){
        List<MaeModel> maes = repository.findAll();
        return maes.stream()
                   .map(maeMapper::map)
                   .collect(Collectors.toList());
    }

    //create
    public MaeDTO createMae(MaeDTO maeDTO){
        MaeModel maeModel = maeMapper.map(maeDTO);
        if(repository.existsByCpf(maeDTO.getCpf())) {
            throw new CpfDuplicadoException(maeDTO.getCpf());
        }
        maeModel = repository.save(maeModel);
        return maeMapper.map(maeModel);
    }

    //findById
    public Optional<MaeDTO> getMaeById(Long id){
        Optional<MaeModel> maePorId = repository.findById(id);

        if(!repository.existsById(id)){
           throw new NoExistsById(id);
        }

        return maePorId.map(maeMapper::map);
    }

    //updateById
    public MaeDTO updateMaeById(Long id, MaeDTO maeDTO) {
        Optional<MaeModel> maeExistente = repository.findById(id);
            if(!maeExistente.isPresent()){
                throw new NoExistsById(id);
            }
                MaeModel maeAtualizado = maeMapper.map(maeDTO);
                maeAtualizado.setId(id);
                MaeModel maeSalva = repository.save(maeAtualizado);

                return maeMapper.map(maeSalva);
        }

    //delete
    public void deleteMae(Long id){
        if(!repository.existsById(id)){
            throw new NoExistsById(id);
        }
        repository.deleteById(id);
    }
}
