package br.furb.mvm.ui.barraFerramentas.botoes;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.IOException;

import javax.swing.JButton;

import br.furb.mvm.trabalho.EStatus;
import br.furb.mvm.ui.IDEInterface;
import br.furb.mvm.ui.barraFerramentas.acao.Acao;
import br.furb.mvm.ui.barraFerramentas.acao.AcaoSalvar;

public class BotaoSalvar extends JButton implements Acao {

    private static final long serialVersionUID = 1L;

    public BotaoSalvar() {
        super();
    }

    public BotaoSalvar(String texto) {
        super(texto);
    }

    @Override
    public void executaAcao(IDEInterface frame) {
        if (frame.getLbStatus().getText().equalsIgnoreCase(EStatus.MODIFICADO.toString())) {
            String absolutePath = frame.getLbFilePath().getText();

            if (absolutePath.isEmpty()) {
                Dialog dialog = new Dialog(frame, "Informe o diret�rio e o nome do arquivo", FileDialog.SAVE);

                dialog.abrirFrame();
                absolutePath = dialog.getAbsolutePath();
            }

            try {
                if (!absolutePath.equalsIgnoreCase("C:\\null")) {
                    AcaoSalvar.salvar(absolutePath, frame.getTextEditor().getText());
                    frame.getLbFilePath().setText(absolutePath);
                    frame.getTextMsg().setText("");
                    frame.getLbStatus().setText(EStatus.NAO_MODIFICADO.toString());
                }
            } catch (IOException e) {
                System.err.println("ERRO FATAL!\nN�o foi poss�vel salvar o arquivo!");
                e.printStackTrace();
            }
        }
    }

    private class Dialog extends FileDialog {

        public Dialog(Frame parent, String title, int mode) {
            super(parent, title, mode);
        }

        private static final long serialVersionUID = 1L;
        private String absolutePath;

        public void abrirFrame() {
            this.setDirectory("C:\\");
            this.setVisible(true);

            absolutePath = this.getDirectory() + this.getFile();
        }

        public String getAbsolutePath() {
            return absolutePath;
        }
    }
}
