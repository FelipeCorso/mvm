package br.furb.mvm.ui.barraFerramentas.acao;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JButton;

import br.furb.mvm.MVM;
import br.furb.mvm.MainMVM;
import br.furb.mvm.ui.IDEInterface;

public abstract class AcaoExecutar extends JButton implements Acao {

    /**
     * 
     */
    private static final long serialVersionUID = -5927631739431915460L;
    private static Object semantico;

    public AcaoExecutar(String texto) {
        super(texto);
    }

    public AcaoExecutar() {
        super();
    }

    public static void executar(IDEInterface frame, String nomeArquivo, String msgStatus) {
        int loadAddress = 0;
        // convert String into InputStream
        InputStream inputStream = new ByteArrayInputStream(frame.getTextEditor().getText().getBytes());
        // read it with BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        MainMVM mainMVM = new MainMVM(frame);
        MVM.resetReg();

        if (frame.getTextAreaBreakpoints().getText().length() > 0) {
            mainMVM.carregar(bufferedReader, loadAddress);
            String[] breakPoints = frame.getTextAreaBreakpoints().getText().split("\\n");
            String[] programa = frame.getTextEditor().getText().split("\\n");
            for (int i = 0; i < programa.length; i++) {
                /*
                 * Se o usuário pressionou resume, executa a linha. 
                 */
                if (!frame.isResume() && isBreakPointLine(breakPoints, i)) {
                    frame.getTextMsg().setText("Aguardando ação do usuário");
                    // Aguarda ação do usuário
                    boolean waiting = true;
                    while (waiting) {
                        synchronized(frame) {
                            if (frame.isResume()) {
                                waiting = false;
                            } else {
                                if (frame.isStep()) {
                                    waiting = false;
                                }
                            }
                        }
                    }

                    frame.getTextMsg().setText("");
                    frame.setStep(false); // Para forçar a parada no while

                    // Resume e Step executam a linha, a diferença é que o resume não vai mais entrar na rotina.
                    MVM.decodificador(mainMVM.getMem(), 0, loadAddress, true, frame);
                } else {
                    MVM.decodificador(mainMVM.getMem(), 0, loadAddress, true, frame);
                }
            }

        } else {
            mainMVM.executar(bufferedReader, loadAddress);
        }
    }

    private static boolean isBreakPointLine(String[] breakPoints, int i) {
        for (String breakPoint : breakPoints) {
            // Índice do texteArea começa em zero, soma +1 para ficar de acordo com as linhas exibidas.
            if (Integer.valueOf(breakPoint) == (i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean compilar(IDEInterface frame, String nomeArquivo, String msgStatus) {
        /*
        Lexico lexico = new Lexico();
        lexico.setInput(frame.getTextEditor().getText());
        Sintatico sintatico = new Sintatico();
        semantico = new Semantico(nomeArquivo);
        try {
            sintatico.parse(lexico, semantico);
            frame.getTextMsg().setText(msgStatus);
            return true;
        } catch (LexicalError e) {
            StringBuilder sb = new StringBuilder();
            tratarLinhaErroCompilacao(sb, frame, e);
            if (e.getMessage().equalsIgnoreCase("s�mbolo inv�lido")) {
                sb.append(String.valueOf(frame.getTextEditor().getText().charAt(e.getPosition())));
                sb.append(" ");
            }
            sb.append(e.getMessage());
            frame.getTextMsg().setText(sb.toString());
            return false;
        } catch (SyntaticError e) {
            StringBuilder sb = new StringBuilder();
            tratarLinhaErroCompilacao(sb, frame, e);
            sb.append("encontrado ");
        
            Token tokenErro = sintatico.getCurrentToken();
            int idToken = tokenErro.getId();
            if (idToken == Constants.t_identificador) {
                sb.append(BuscaClasse.buscaNomeClasse(idToken));
                sb.append(" (");
                sb.append(getLexema(tokenErro));
                sb.append(") ");
            } else {
                sb.append(getLexema(tokenErro));
                sb.append(" ");
            }
        
            sb.append(e.getMessage());
            frame.getTextMsg().setText(sb.toString());
            return false;
        } catch (SemanticError e) {
            StringBuilder sb = new StringBuilder();
            tratarLinhaErroCompilacao(sb, frame, e);
            sb.append(e.getMessage());
            frame.getTextMsg().setText(sb.toString());
            return false;
        }
        */
        return false;

    }

    public static void tratarLinhaErroCompilacao(StringBuilder sb, IDEInterface frame, Exception e) {
        /*
         sb.append("Erro na linha ");
        try {
            int linha = frame.getTextEditor().getLineOfOffset(e.getPosition()) + 1;
            sb.append(linha);
        } catch (BadLocationException e1) {
            System.err.println("Linha do caractere n�o encontrada");
        }
        sb.append(" - ");
        */
    }

    private static String getLexema(Object tokenErro) {
        /*
         String lexema = tokenErro.getLexeme();
        if (lexema.equals("$")) {
            lexema = "fim do programa";
        }
        return lexema;
        */
        return "";
    }

    public static Object getSemantico() {
        return null;
    }

}
