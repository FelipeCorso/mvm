package br.furb.mvm.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.furb.mvm.trabalho.EStatus;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoAbrir;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoEquipe;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoExecutar;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoNovo;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoRecortar;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoResume;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoSalvar;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoStep;

public class ShortCutListener implements KeyListener {

    private CompilerInterface compUi;
    private String textEditor;

    public ShortCutListener(CompilerInterface compUi) {
        this.compUi = compUi;
        textEditor = "";
    }

    @Override
    public void keyPressed(KeyEvent event) {
        boolean isCtrlDown = event.isControlDown();
        switch (event.getKeyCode()) {
            case KeyEvent.VK_N:
                if (isCtrlDown) {
                    new BotaoNovo().executaAcao(compUi);
                }
                break;
            case KeyEvent.VK_A:
                if (isCtrlDown) {
                    new BotaoAbrir().executaAcao(compUi);
                }
                break;
            case KeyEvent.VK_S:
                if (isCtrlDown) {
                    new BotaoSalvar().executaAcao(compUi);
                }
                break;
            case KeyEvent.VK_C:
                if (isCtrlDown) {
                    new BotaoResume().executaAcao(compUi);
                }
                break;
            case KeyEvent.VK_V:
                if (isCtrlDown) {
                    new BotaoStep().executaAcao(compUi);
                }
                break;
            case KeyEvent.VK_X:
                if (isCtrlDown) {
                    new BotaoRecortar().executaAcao(compUi);
                }
                break;
            case KeyEvent.VK_F6:
                new BotaoStep().executaAcao(compUi);
                break;
            case KeyEvent.VK_F12:
                new BotaoExecutar().executaAcao(compUi);
                break;
            case KeyEvent.VK_F1:
                new BotaoEquipe().executaAcao(compUi);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        if (!textEditor.equalsIgnoreCase(compUi.getTextEditor().getText())) {
            compUi.getLbStatus().setText(EStatus.MODIFICADO.toString());
        } else {
            compUi.getLbStatus().setText(EStatus.NAO_MODIFICADO.toString());
        }

    }

    @Override
    public void keyTyped(KeyEvent event) {
        // TODO Auto-generated method stub

    }

    public String getTextoEditor() {
        return textEditor;
    }

    public void setTextoEditor(String textEditor) {
        this.textEditor = textEditor;
    }

}
