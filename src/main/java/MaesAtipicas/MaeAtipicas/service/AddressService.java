package MaesAtipicas.MaeAtipicas.service;

import MaesAtipicas.MaeAtipicas.DTO.AddressDTO;
import MaesAtipicas.MaeAtipicas.exceptions.CpfDuplicadoException;
import MaesAtipicas.MaeAtipicas.exceptions.NoExistsByIdException;
import MaesAtipicas.MaeAtipicas.mapper.AddressMapper;
import lombok.AllArgsConstructor;
import MaesAtipicas.MaeAtipicas.model.AddressModel;
import org.springframework.stereotype.Service;
import MaesAtipicas.MaeAtipicas.repository.AddressRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AddressService {

   private final AddressRepository repository;
    private final AddressMapper addressMapper;




    public List<AddressDTO> addressAll(){
     List<AddressModel> addressModel = repository.findAll();
     return addressModel.stream()
                        .map(addressMapper::map)
                        .collect(Collectors.toList());
    }


    public AddressDTO createAddress(AddressDTO addressDTO) {
        AddressModel addressModel = addressMapper.map(addressDTO);
        if(!repository.existsById(addressDTO.getId())) {
            throw new CpfDuplicadoException("endereco já existente");
        }

        addressModel = repository.save(addressModel);
        return addressMapper.map(addressModel);
    }


    public AddressDTO updateAddress(Long id, AddressDTO addressDTO){
        Optional<AddressModel> addressExistente = repository.findById(id);
        if(!addressExistente.isPresent()){
            throw new NoExistsByIdException(id);
        }

        AddressModel addressModel = addressMapper.map(addressDTO);
        addressModel.setId(id);
        AddressModel addressSave = repository.save(addressModel);

        return addressMapper.map(addressSave);
    }


    public Optional<AddressDTO> getById(Long id){
        Optional<AddressModel> addressPorId = repository.findById(id);
        if(addressPorId.isPresent()){
            throw new NoExistsByIdException(id);
        }
        return addressPorId.map(addressMapper::map);
    }


    public void deleteAddressById(Long id){
        if (!repository.existsById(id)) {
            throw new NoExistsByIdException(id);
        }
        repository.deleteById(id);
    }
}
