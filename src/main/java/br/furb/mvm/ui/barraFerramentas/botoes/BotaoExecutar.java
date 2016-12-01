package br.furb.mvm.ui.barraFerramentas.botoes;

import br.furb.mvm.ui.IDEInterface;
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
    public void executaAcao(IDEInterface frame) {
        if (!frame.getTextEditor().getText().isEmpty()) {
            Runnable executar = new Runnable() {

                @Override
                public void run() {
                    try {
                        frame.setResume(false);
                        frame.setStep(false);
                        AcaoExecutar.executar(frame, "", "\tPrograma executado com sucesso!");
                    } catch (Exception e) {}

                }
            };
            new Thread(executar).start();
        } else {
            frame.getTextMsg().setText("Nenhum programa para executar!");
        }
    }

}
