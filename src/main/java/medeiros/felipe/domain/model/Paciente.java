package medeiros.felipe.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity(name = "tb_paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeProfissional;
    private String cargo;
    private String nomePaciente;
    private Date dataEntrada;
    private String motivoDoTratamento;

    @OneToMany(mappedBy = "paciente")
    private List<Prontuario> prontuarios;


}
