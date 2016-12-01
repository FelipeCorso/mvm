package br.furb.mvm.ui.barraFerramentas.botoes;

import javax.swing.JButton;

import br.furb.mvm.ui.IDEInterface;
import br.furb.mvm.ui.barraFerramentas.acao.Acao;

public class BotaoStep extends JButton implements Acao {

    private static final long serialVersionUID = 1L;

    public BotaoStep() {
        super();
    }

    public BotaoStep(String texto) {
        super(texto);
    }

    @Override
    public void executaAcao(IDEInterface frame) {
        frame.setStep(true);
    }
}
