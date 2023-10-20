package medeiros.felipe.domain.repository;

import medeiros.felipe.domain.model.Paciente;
import medeiros.felipe.domain.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProntuarioRepository extends JpaRepository<Prontuario,Long> {

}
