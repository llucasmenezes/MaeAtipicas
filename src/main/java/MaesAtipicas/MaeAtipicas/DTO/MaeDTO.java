package MaesAtipicas.MaeAtipicas.DTO;

import MaesAtipicas.MaeAtipicas.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaeDTO {

    private Long id;
    private String cpf;
    private String name;
    private String lastName;
    private List<AddressModel> addressModel;
    private String email;
    private String celular;


    private String state;
    private String city;
    private String neighborhood;
    private String address;
    private String zip_code;
}