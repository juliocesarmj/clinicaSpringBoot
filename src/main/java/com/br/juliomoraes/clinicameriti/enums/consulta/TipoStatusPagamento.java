package com.br.juliomoraes.clinicameriti.enums.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoStatusPagamento {

	PAGO("Pago"), PAGAR_CAIXA("Pagamento no caixa"), AGUARDANDO_PAGAMENTO("Aguardando pagamento");

	private String valor;

}
