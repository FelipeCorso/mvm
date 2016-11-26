package br.furb.mvm.ui.barraFerramentas.botoes;

import javax.swing.JButton;

import br.furb.mvm.trabalho.EStatus;
import br.furb.mvm.ui.CompilerInterface;
import br.furb.mvm.ui.barraFerramentas.acao.Acao;

public class BotaoRecortar extends JButton implements Acao {
	private static final long serialVersionUID = 1L;

	public BotaoRecortar() {
		super();
	}

	public BotaoRecortar(String texto) {
		super(texto);
	}

	@Override
	public void executaAcao(CompilerInterface frame) {
		frame.getTextEditor().cut();
		frame.getLbStatus().setText(EStatus.MODIFICADO.toString());
	}
}
