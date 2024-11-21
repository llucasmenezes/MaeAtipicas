package MaesAtipicas.MaeAtipicas.mapper;

import MaesAtipicas.MaeAtipicas.DTO.AddressDTO;
import MaesAtipicas.MaeAtipicas.model.AddressModel;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressModel map(AddressDTO addressDTO){
        AddressModel addressModel = new AddressModel();
        addressModel.setId(addressDTO.getId());
        addressModel.setCountry(addressDTO.getCountry());
        addressModel.setCity(addressDTO.getCity());
        addressModel.setPostalcode(addressDTO.getPostalcode());
        addressModel.setStreet(addressDTO.getStreet());
        addressModel.setMaeModel(addressDTO.getMaeModel());

        return addressModel;
    }

    public AddressDTO map(AddressModel addressModel){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressModel.getId());
        addressDTO.setCountry(addressModel.getCountry());
        addressDTO.setState(addressModel.getState());
        addressDTO.setCity(addressModel.getCity());
        addressDTO.setPostalcode(addressModel.getPostalcode());
        addressDTO.setStreet(addressModel.getStreet());
        addressDTO.setMaeModel(addressModel.getMaeModel());

        return addressDTO;
    }
}
