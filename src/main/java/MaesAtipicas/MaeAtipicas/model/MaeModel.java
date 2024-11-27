package MaesAtipicas.MaeAtipicas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_mae")
@ToString(exclude = "adressModel")
public class MaeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String name;

    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "celular")
    private String celular;

    @JsonIgnore
    @OneToMany(mappedBy = "maeModel")
    private List<AddressModel> adressModel;
}
