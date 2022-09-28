package com.br.juliomoraes.clinicameriti.enums.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoStatusPagamento {

	PAGAMENTO_PIX("Pagamento via pix"), PAGO_CAIXA("Pagamento no caixa"), AGUARDANDO_PAGAMENTO("Aguardando pagamento");

	private String valor;

}
