package br.furb.mvm.trabalho;

public enum EStatus {
	NAO_MODIFICADO("N\u00E3o modificado"), MODIFICADO("Modificado");

	private String descricao;

	private EStatus(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}
}
