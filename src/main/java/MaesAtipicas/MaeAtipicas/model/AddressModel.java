package MaesAtipicas.MaeAtipicas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_adress")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private String city;

    private String state;

    private String postalcode;

    private String country;

    @ManyToOne
    @JoinColumn(name = "mae_id", nullable = false)
    private MaeModel maeModel;
}
