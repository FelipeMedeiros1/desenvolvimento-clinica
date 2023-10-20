package medeiros.felipe.domain.repository;

import medeiros.felipe.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuatrioRepository extends JpaRepository<Paciente,Long> {

}
