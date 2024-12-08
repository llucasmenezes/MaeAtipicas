package MaesAtipicas.MaeAtipicas.controller;

import MaesAtipicas.MaeAtipicas.DTO.AddressDTO;
import MaesAtipicas.MaeAtipicas.model.AddressModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import MaesAtipicas.MaeAtipicas.repository.AddressRepository;
import MaesAtipicas.MaeAtipicas.service.AddressService;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/endereco")
public class AddressController {

    @Autowired
    private final AddressService addressService;
    private final AddressRepository addressRepository;

    @GetMapping("/listar")
    public ResponseEntity<List<AddressDTO>> findAll(){
        List<AddressDTO> addressDTO = addressService.addressAll();
        if(addressDTO.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressDTO, HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDTO){
        AddressDTO createAddress = addressService.createAddress(addressDTO);
        return new ResponseEntity<>(createAddress, HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Optional<AddressDTO>> getAddressById(@PathVariable Long id){
        Optional<AddressDTO> getAddress = addressService.getById(id);
        return new ResponseEntity<>(getAddress, HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<AddressDTO> putAddress(@RequestBody Long id, AddressDTO addressDTO){
        AddressDTO updateAdress = addressService.updateAddress(id, addressDTO);
        return new ResponseEntity<>(updateAdress, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdress(@PathVariable Long id){
        Optional<AddressModel> deleteAddress = addressRepository.findById(id);
        return ResponseEntity.noContent().build();
    }

}
