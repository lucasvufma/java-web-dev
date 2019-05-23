package com.learningSB.domain.enums;

public enum TipoCliente {
	CLIENTEFISICO(1),
	CLIENTEJURIDICO(2);	
	private int cod;
	
	private TipoCliente(int cod) {
		this.cod=cod;
	}
	
	public int getCod() {
		return cod;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for(TipoCliente i : TipoCliente.values()) {
			if(cod.equals(i.getCod())) {
				return i;
			}
		}
		throw new IllegalArgumentException("Cod Invalido: "+cod);
		
	}
}
