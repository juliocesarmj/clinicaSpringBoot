package com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens;

public enum MessageException {
    OBJECTO_NAO_ENCONTRADO("Objeto não encontrado."), CLASSE_NAO_PODE_INSTANCIAR("Classe não pode ser instanciada."),
    MEDICO_EXISTE_CRM("Já existe um médico no sistema com o CRM informado."), ESPECIALIDADE_NAO_EXISTE("A especialidade informada não existe."),
    CPF_EXISTENTE("O cpf informado já existe."),
    EMAIL_EXISTENTE("O email informado já existe"),
    TELEFONE_EXISTENTE("O telefone informado já existe");

    private final String mensagem;

    MessageException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
