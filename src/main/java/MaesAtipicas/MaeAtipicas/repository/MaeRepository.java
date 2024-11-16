package MaesAtipicas.MaeAtipicas.repository;

import MaesAtipicas.MaeAtipicas.model.MaeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaeRepository extends JpaRepository<MaeModel,Long> {

    boolean existsByCpf(String cpf);
}
