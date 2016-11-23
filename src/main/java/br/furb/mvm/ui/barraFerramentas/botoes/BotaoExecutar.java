package br.furb.mvm.ui.barraFerramentas.botoes;

import br.furb.mvm.ui.CompilerInterface;
import br.furb.mvm.ui.barraFerramentas.acao.AcaoExecutar;

public class BotaoExecutar extends AcaoExecutar {

    private static final long serialVersionUID = 1L;
    //    BuscaClasse buscaClasse = new BuscaClasse();

    public BotaoExecutar() {
        super();
    }

    public BotaoExecutar(String texto) {
        super(texto);
    }

    @Override
    public void executaAcao(CompilerInterface frame) {
        if (!frame.getTextEditor().getText().isEmpty()) {
            // FIXME: chamar rotina para executar o programa
            AcaoExecutar.executar(frame, "", "\tPrograma executado com sucesso!");
        } else {
            frame.getTextMsg().setText("Nenhum programa para executar!");
        }
    }

}
