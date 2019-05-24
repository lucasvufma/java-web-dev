package com.learningSB.domain.enums;

public enum EstadoPagamento {
	PAGO(1),
	PENDENTE(2),
	CANCELADO(3);
	
	private int cod;

	private EstadoPagamento(int cod) {
		this.cod=cod;
	}
	
	public int getCod() {
		return cod;
	}
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for(EstadoPagamento i : EstadoPagamento.values()) {
			if(cod.equals(i.getCod())) {
				return i;
			}
		}
		throw new IllegalArgumentException("Cod Invalido: "+cod);
		
	}
}

	
