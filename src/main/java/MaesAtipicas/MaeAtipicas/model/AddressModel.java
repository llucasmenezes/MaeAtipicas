package MaesAtipicas.MaeAtipicas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_adress")
@ToString
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String postalcode;

    private String country;

    @OneToOne
    @JoinColumn(name = "mae_id", nullable = false, unique = true)
    private MaeModel maeModel;
}
