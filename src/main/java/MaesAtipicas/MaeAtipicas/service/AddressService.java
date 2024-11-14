package MaesAtipicas.MaeAtipicas.service;

import lombok.AllArgsConstructor;
import MaesAtipicas.MaeAtipicas.model.AddressModel;
import org.springframework.stereotype.Service;
import MaesAtipicas.MaeAtipicas.repository.AddressRepository;
import MaesAtipicas.MaeAtipicas.repository.MaeRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressService {

   private final AddressRepository repository;
    private final MaeRepository maeRepository;



    //listar todos
    public List<AddressModel> addressModel(){
        return repository.findAll();
    }

    //create
    public AddressModel createAddress(AddressModel addressModel) {
        if(addressModel.getId() != null){
            throw new IllegalArgumentException("Já existe");
        }
        return repository.save(addressModel);
    }

    //save
    public List<AddressModel> getAllAddress(){
        return repository.findAll();
    }

    //update
    public AddressModel updateAddress(Long id, AddressModel addressModel){
        if (!repository.existsById(id)){
             throw new IllegalArgumentException("Nao encontrado");
        }
        addressModel.setId(id);
        return repository.save(addressModel);
    }

    //findById
    public AddressModel getById(Long id){
        Optional<AddressModel> maeModel = repository.findById(id);
        return maeModel.orElse(null);
    }

    //delete
    public void deleteAddressById(Long id){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Nao encontrado");
        }
        repository.deleteById(id);
    }
}
