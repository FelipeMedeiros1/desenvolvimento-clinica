package medeiros.felipe.service;

import medeiros.felipe.domain.model.Paciente;

public interface PacienterService {

    public Paciente findById(Long numeroDoProntuario);

    public Paciente create(Paciente cadastrarPaciente);
}
