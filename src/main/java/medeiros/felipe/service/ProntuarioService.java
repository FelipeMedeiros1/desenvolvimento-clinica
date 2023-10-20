package medeiros.felipe.service;

import medeiros.felipe.domain.model.Paciente;
import medeiros.felipe.domain.model.Prontuario;

import java.util.Date;

public interface ProntuarioService {

    Prontuario cadastrarEvolucao(Long pacienteId ,String descricao );

    Prontuario classificarEstadoRisco(Long prontuarioId, String estadoRisco);

    Prontuario atualizarAcompanhamentoGrupo(Long prontuarioId, boolean acompanhamentoGrupo);

    Prontuario registrarPresenca(Long prontuarioId);

    Prontuario registrarFalta(Long prontuarioId);

    Prontuario encaminharPaciente(Long prontuarioId, String motivo);

    Prontuario darAltaPaciente(Long prontuarioId, String motivo, String data);

}
