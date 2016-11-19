package br.furb.mvm.ui.barraFerramentas.botoes;

import javax.swing.JButton;

import br.furb.mvm.trabalho.EStatus;
import br.furb.mvm.ui.CompilerInterface;
import br.furb.mvm.ui.barraFerramentas.acao.Acao;

public class BotaoColar extends JButton implements Acao {

    private static final long serialVersionUID = 1L;

    public BotaoColar() {
        super();
    }

    public BotaoColar(String texto) {
        super(texto);
    }

    @Override
    public void executaAcao(CompilerInterface frame) {
        frame.getTextEditor().paste();
        frame.getLbStatus().setText(EStatus.MODIFICADO.toString());
    }
}
