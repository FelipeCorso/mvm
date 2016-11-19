package br.furb.mvm.ui.barraFerramentas.acao;

import javax.swing.JButton;

import br.furb.mvm.ui.CompilerInterface;

public abstract class AcaoCompilar extends JButton implements Acao {

    /**
     * 
     */
    private static final long serialVersionUID = -5927631739431915460L;
    private static Object semantico;

    public AcaoCompilar(String texto) {
        super(texto);
    }

    public AcaoCompilar() {
        super();
    }

    public static boolean compilar(CompilerInterface frame, String nomeArquivo, String msgStatus) {
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

    public static void tratarLinhaErroCompilacao(StringBuilder sb, CompilerInterface frame, Exception e) {
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
