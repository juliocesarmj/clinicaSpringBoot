package com.br.juliomoraes.clinicameriti.enums.excecoes.mensagens;

public enum MessageException {
    OBJECTO_NAO_ENCONTRADO("Objeto não encontrado."), CLASSE_NAO_PODE_INSTANCIAR("Classe não pode ser instanciada."),
    MEDICO_EXISTE_CRM("Já existe um médico no sistema com o CRM informado."), ESPECIALIDADE_NAO_EXISTE("A especialidade informada não existe.");

    private final String mensagem;

    MessageException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
