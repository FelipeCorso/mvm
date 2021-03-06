package br.furb.mvm.ui.barraFerramentas.botoes;

import javax.swing.JButton;

import br.furb.mvm.ui.CompilerInterface;
import br.furb.mvm.ui.barraFerramentas.acao.Acao;

public class BotaoCopiar extends JButton implements Acao {

    private static final long serialVersionUID = 1L;

    public BotaoCopiar() {
        super();
    }

    public BotaoCopiar(String texto) {
        super(texto);
    }

    @Override
    public void executaAcao(CompilerInterface frame) {
        frame.getTextEditor().copy();
    }
}
