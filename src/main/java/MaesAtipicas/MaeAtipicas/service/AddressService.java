package MaesAtipicas.MaeAtipicas.service;

import MaesAtipicas.MaeAtipicas.exceptions.NoExistsById;
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
        if(repository.existsById(addressModel.getId())){
            throw new NoExistsById(addressModel.getId());
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
             throw new NoExistsById(id);
        }
        addressModel.setId(id);
        return repository.save(addressModel);
    }

    //findById
    public Optional<AddressModel> getById(Long id){
        if(!repository.existsById(id)) {
            throw new NoExistsById(id);
        }
        return repository.findById(id);
    }

    //delete
    public void deleteAddressById(Long id){
        if (!repository.existsById(id)) {
            throw new NoExistsById(id);
        }
        repository.deleteById(id);
    }
}
