package medeiros.felipe.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_prontuario")
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroDoProntuario;

    private String dataEvolucao;
    private String estadoRisco;
    private boolean acompanhamentoGrupo;
    private int presencas;
    private int faltas;
    private String encaminhamentoMotivo;
    private String altaMotivo;
    private String altaData;

    @ManyToOne
    @JoinColumn(name = "pt_paciente")
    private Paciente pt_paciente;

}
