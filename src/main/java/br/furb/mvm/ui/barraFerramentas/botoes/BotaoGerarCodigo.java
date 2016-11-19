package br.furb.mvm.ui.barraFerramentas.botoes;

import java.io.File;

import javax.swing.JButton;

import br.furb.mvm.ui.CompilerInterface;
import br.furb.mvm.ui.barraFerramentas.acao.Acao;

public class BotaoGerarCodigo extends JButton implements Acao {

    private static final long serialVersionUID = 1L;

    public BotaoGerarCodigo() {
        super();
    }

    public BotaoGerarCodigo(String texto) {
        super(texto);
    }

    @Override
    public void executaAcao(CompilerInterface frame) {
        /*
        if (!frame.getTextEditor().getText().isEmpty()) {
            if (isProgramaSalvo(frame)) {
                try {
                    boolean compSucesso = AcaoCompilar.compilar(frame, getFileName(frame), "\tC�digo objeto gerado com sucesso!");
                    if (compSucesso) {
                        AcaoSalvar.salvar(getFilePath(frame), AcaoCompilar.getSemantico().getCodigo().toString());
                    }
                } catch (IOException e) {
                    System.err.println("ERRO FATAL!\nN�o foi poss�vel salvar o arquivo!");
                    e.printStackTrace();
                }
            } else {
                int retorno = JOptionPane.showConfirmDialog(frame, "Deseja salvar o programa?", "Confirma��o", JOptionPane.YES_NO_OPTION);
                if (retorno == JOptionPane.YES_OPTION) {
                    new BotaoSalvar().executaAcao(frame);
                }
            }
        } else {
            frame.getTextMsg().setText("Nenhum programa para gerar c�digo!");
        }
        */
    }

    private String getFileName(CompilerInterface frame) {
        File file = new File(frame.getLbFilePath().getText());
        String name = file.getName();
        return name.substring(0, name.lastIndexOf("."));
    }

    private String getFilePath(CompilerInterface frame) {
        String filePath = frame.getLbFilePath().getText();
        return filePath.substring(0, filePath.lastIndexOf(".") + 1).concat("il");
    }

    private boolean isProgramaSalvo(CompilerInterface frame) {
        return !frame.getLbFilePath().getText().isEmpty();
    }

}
