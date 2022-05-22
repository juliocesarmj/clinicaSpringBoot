package com.br.juliomoraes.clinicameriti.enums.especialidades;

public enum Especialidade {
    CARDIOLOGISTA("Cardiologista"), PEDIATRA("Pediatra"), NUTRICIONISTA("Nutricionista"), GINECOLOGISTA("Ginecologista"),
    DENTISTA("Dentista"), NEUROLOGISTA("Neurologista"), CLINICO_GERAL("Clínico Geral"), PSICOLOGO("Psicólogo/Psicóloga");

    private final String nomeEspecialidade;

    Especialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
}
