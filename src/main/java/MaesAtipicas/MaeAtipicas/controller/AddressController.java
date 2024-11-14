package MaesAtipicas.MaeAtipicas.controller;

import MaesAtipicas.MaeAtipicas.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import MaesAtipicas.MaeAtipicas.repository.AddressRepository;
import MaesAtipicas.MaeAtipicas.service.AddressService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "/endereco")
public class AddressController {

    @Autowired
    AddressService addressService;
    AddressRepository addressRepository;

    //findALl
    @GetMapping("/listar")
    public ResponseEntity<List<AddressModel>> findAll(){
        List<AddressModel> addressModel = addressService.getAllAddress();
        if(addressModel.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressModel, HttpStatus.OK);
    }

    //create
    @PostMapping("/criar")
    public ResponseEntity<AddressModel> createAddress(@RequestBody AddressModel addressModel){
        AddressModel createAddress = addressService.createAddress(addressModel);
        if(createAddress.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createAddress, HttpStatus.CREATED);
    }

    //findById
    @GetMapping("/listar/{id}")
    public ResponseEntity<AddressModel> getAddressById(@PathVariable Long id){
        AddressModel getAddress = addressService.getById(id);
        if(getAddress.getId() == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(getAddress, HttpStatus.OK);
    }

    //put
    @PutMapping("/atualizar")
    public ResponseEntity<AddressModel> putAddress(@RequestBody Long id, AddressModel addressModel){
        AddressModel updateAdress = addressService.updateAddress(id, addressModel);
        if (updateAdress.getId() == null){
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(updateAdress, HttpStatus.CREATED);
    }


    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdress(@PathVariable Long id){
        Optional<AddressModel> deleteAddress = addressRepository.findById(id);
        if(deleteAddress.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
