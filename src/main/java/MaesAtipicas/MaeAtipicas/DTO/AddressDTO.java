package MaesAtipicas.MaeAtipicas.DTO;

import MaesAtipicas.MaeAtipicas.model.MaeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String postalcode;
    private String country;
    private MaeModel maeModel;
}
