package medeiros.felipe.service;

import medeiros.felipe.domain.model.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> listarTodosPacientes();

    Paciente buscarPacientePorNumeroDoProntuario(Long numeroDoProntuario);

    Paciente cadastrarPaciente(Paciente paciente);

    Paciente atualizarPaciente(Long numeroDoProntuario, Paciente paciente);

    void excluirPaciente(Long numeroDoProntuario);
}
