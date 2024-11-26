package MaesAtipicas.MaeAtipicas.mapper;

import MaesAtipicas.MaeAtipicas.DTO.AddressDTO;
import MaesAtipicas.MaeAtipicas.model.AddressModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressModel map(AddressDTO addressDTO);
    AddressDTO map(AddressModel addressModel);

}
