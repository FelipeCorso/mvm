package br.furb.mvm.ui.barraFerramentas.botoes;

import javax.swing.JButton;

import br.furb.mvm.ui.CompilerInterface;
import br.furb.mvm.ui.barraFerramentas.acao.Acao;

public class BotaoEquipe extends JButton implements Acao {

    private static final long serialVersionUID = 1L;

    public BotaoEquipe() {
        super();
    }

    public BotaoEquipe(String texto) {
        super(texto);
    }

    @Override
    public void executaAcao(CompilerInterface frame) {
        frame.getTextMsg().setText("Integrantes Equipe: André Luiz Lunelli, Felipe Loose Corso, Rai Vieira Adriano\n");
    }
}
