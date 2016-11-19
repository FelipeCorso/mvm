package br.furb.mvm.ui.barraFerramentas.botoes;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;

import br.furb.mvm.trabalho.EStatus;
import br.furb.mvm.ui.CompilerInterface;
import br.furb.mvm.ui.barraFerramentas.acao.Acao;

public class BotaoAbrir extends JButton implements Acao {

    private static final long serialVersionUID = 1L;

    public BotaoAbrir() {
        super();
    }

    public BotaoAbrir(String texto) {
        super(texto);
    }

    @Override
    public void executaAcao(CompilerInterface frame) {
        String filePath = "";
        FileDialog fileDialog = new FileDialog(frame, "Abrir", FileDialog.LOAD);
        fileDialog.setDirectory("C:\\");
        fileDialog.setVisible(true);

        filePath = fileDialog.getDirectory() + fileDialog.getFile();

        if (!filePath.equalsIgnoreCase("C:\\null")) {
            try {
                // 1� tenta ler depois seta o caminho do arquivo e as demais informa��es
                frame.getTextEditor().setText(textFileRead(filePath));
                frame.getLbFilePath().setText(filePath);
                frame.getKeyListener().setTextoEditor("");
                frame.getTextMsg().setText("");
                frame.getLbStatus().setText(EStatus.NAO_MODIFICADO.toString());
                frame.getKeyListener().setTextoEditor(frame.getTextEditor().getText());
            } catch (ClassNotFoundException | IOException e) {
                System.err.println("ERRO FATAL!\nN�o foi poss�vel realizar a leitura do arquivo!");
                e.printStackTrace();
            }

        }
    }

    private String textFileRead(String fileName) throws ClassNotFoundException, IOException {
        FileReader fr = new FileReader(fileName);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(fr);

        int c = 0;
        while ((c = bufferedReader.read()) != -1) {
            sb.append((char) c);
        }

        bufferedReader.close();
        fr.close();

        return sb.toString();
    }

}
