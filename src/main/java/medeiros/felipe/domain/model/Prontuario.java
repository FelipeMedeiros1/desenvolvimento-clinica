package medeiros.felipe.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroDoProntuario;

    private Date dataEvolucao;
    private String estadoRisco;
    private boolean acompanhamentoGrupo;
    private int presencas;
    private int faltas;
    private String encaminhamentoMotivo;
    private String altaMotivo;
    private Date altaData;

    @ManyToOne
    @JoinColumn(name = "paciente_pt")
    private Paciente paciente;

}
