package br.furb.mvm.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.furb.mvm.trabalho.EStatus;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoAbrir;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoCompilar;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoEquipe;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoGerarCodigo;
import br.furb.mvm.ui.barraFerramentas.botoes.BotaoSalvar;

@SuppressWarnings("serial")
public class CompilerInterface extends JFrame {

    private final BotaoAbrir btnCarregar;
    private final BotaoSalvar btnSalvar;
    private final BotaoCompilar btnRun;
    private final BotaoGerarCodigo btnStep;
    private final BotaoEquipe btnEquipe;
    private final JLabel lbStatus;
    private final JTextArea textEditor;
    private final JTextArea textMsg;
    private final JPanel contentPane;
    private final KeyListener keyListener;

    private JPanel panelFooter;
    private JLabel lbFilePath;
    private JScrollPane scrollPaneEditor;
    private JPanel panelEditor;
    private JPanel panelMsg;
    private JScrollPane scrollPaneMsg;
    private JScrollPane scrollPaneReg;
    private JPanel panelReg;
    private JLabel lblAx;
    private JLabel lblAxValue;
    private JLabel lblBx;
    private JLabel lblBxValue;
    private Component lblSp;
    private JLabel lblSpValue;
    private JLabel lblBp;
    private JLabel lblBpValue;
    private JLabel lblIp;
    private JLabel lblIpValue;
    private Component lblCx;
    private JLabel lblCxValue;
    private JScrollPane scrollPaneStack;
    private JLabel lblReg;
    private JLabel lblStack;
    private JLabel lblNewLabel;
    private JPanel panelLateralFirst;
    private JPanel panelLateralSecond;
    private BotaoCompilar btnExecutar;
    private JLabel lblBreakpoints;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    CompilerInterface frame = new CompilerInterface();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CompilerInterface() {
        Font fonte = new Font("Dialog", Font.BOLD, 11);
        keyListener = new ShortCutListener(this);
        addKeyListener(keyListener);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setTitle("Compilador");
        setMinimumSize(new Dimension(800, 650));
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.addKeyListener(keyListener);
        setContentPane(contentPane);

        JPanel panelCompilador = new JPanel();
        contentPane.add(panelCompilador, BorderLayout.CENTER);
        panelCompilador.setLayout(new BorderLayout(0, 0));
        panelCompilador.addKeyListener(keyListener);

        JPanel panelFerramentas = new JPanel();
        panelCompilador.add(panelFerramentas, BorderLayout.NORTH);
        panelFerramentas.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelFerramentas.setLayout(new GridLayout(0, 6, 0, 0));
        panelFerramentas.addKeyListener(keyListener);

        btnCarregar = new BotaoAbrir("abrir [ctrl-a]");
        btnCarregar.setText("carregar [ctrl-a]");
        btnCarregar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                btnCarregar.executaAcao(getInstance());
            }
        });
        btnCarregar.setIcon(getImageIcon("openFile.png"));
        btnCarregar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCarregar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCarregar.addKeyListener(keyListener);
        btnCarregar.setFont(fonte);
        panelFerramentas.add(btnCarregar);

        btnSalvar = new BotaoSalvar("salvar [ctrl-s]");
        btnSalvar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                btnSalvar.executaAcao(getInstance());
            }

        });
        btnSalvar.setIcon(getImageIcon("save_edit.gif"));
        btnSalvar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSalvar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnSalvar.addKeyListener(keyListener);
        btnSalvar.setFont(fonte);
        panelFerramentas.add(btnSalvar);

        btnRun = new BotaoCompilar("compilar [F8]");
        btnRun.setText("run [F8]");
        btnRun.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                btnRun.executaAcao(getInstance());
            }
        });
        btnRun.setIcon(getImageIcon("restart_task.gif"));
        btnRun.setHorizontalTextPosition(SwingConstants.CENTER);
        btnRun.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnRun.addKeyListener(keyListener);

        btnExecutar = new BotaoCompilar("compilar [F8]");
        btnExecutar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnExecutar.setText("executar [F12]");
        btnExecutar.setIcon(getImageIcon("start_task.gif"));
        btnExecutar.setHorizontalTextPosition(SwingConstants.CENTER);
        btnExecutar.setFont(new Font("Dialog", Font.BOLD, 11));
        panelFerramentas.add(btnExecutar);
        btnRun.setFont(fonte);
        panelFerramentas.add(btnRun);

        btnStep = new BotaoGerarCodigo("gerar c\u00F3digo [F9]");
        btnStep.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnStep.setText("step [F6]");
        btnStep.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                btnStep.executaAcao(getInstance());
            }
        });
        btnStep.setIcon(getImageIcon("stepover_co.gif"));
        btnStep.setHorizontalTextPosition(SwingConstants.CENTER);
        btnStep.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnStep.addKeyListener(keyListener);
        btnStep.setFont(fonte);
        panelFerramentas.add(btnStep);

        btnEquipe = new BotaoEquipe("equipe [F1]");
        btnEquipe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnEquipe.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                btnEquipe.executaAcao(getInstance());
            }
        });
        btnEquipe.setIcon(getImageIcon("information.gif"));
        btnEquipe.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEquipe.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEquipe.addKeyListener(keyListener);
        btnEquipe.setFont(fonte);
        panelFerramentas.add(btnEquipe);

        JPanel panelCentral = new JPanel();
        panelCentral.addKeyListener(keyListener);
        panelCompilador.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new BorderLayout(0, 0));

        JPanel panelLateralLeste = new JPanel();
        panelLateralLeste.addKeyListener(keyListener);
        panelCompilador.add(panelLateralLeste, BorderLayout.EAST);

        JPanel panelLateralOeste = new JPanel();
        panelLateralOeste.addKeyListener(keyListener);
        panelCompilador.add(panelLateralOeste, BorderLayout.WEST);
        panelLateralOeste.setLayout(new BorderLayout(0, 0));

        lblBreakpoints = new JLabel("Breakpoints");
        panelLateralOeste.add(lblBreakpoints, BorderLayout.NORTH);

        JTextArea textAreaBreakpoints = new JTextArea();
        JScrollPane scrollPaneBreakpoints = new JScrollPane(textAreaBreakpoints);
        panelLateralOeste.add(scrollPaneBreakpoints, BorderLayout.CENTER);

        lblStack = new JLabel("Stack");
        panelLateralLeste.setLayout(new GridLayout(2, 1, 0, 0));

        panelLateralFirst = new JPanel();
        panelLateralLeste.add(panelLateralFirst);
        panelLateralFirst.setLayout(new BorderLayout(0, 0));

        lblReg = new JLabel("Reg");
        panelLateralFirst.add(lblReg, BorderLayout.NORTH);

        panelReg = new JPanel();
        panelReg.setLayout(new GridLayout(6, 2));

        scrollPaneReg = new JScrollPane(panelReg);
        panelLateralFirst.add(scrollPaneReg, BorderLayout.CENTER);

        lblAx = new JLabel("AX:");
        panelReg.add(lblAx);

        lblAxValue = new JLabel("0");
        panelReg.add(lblAxValue);

        lblBx = new JLabel("BX:");
        panelReg.add(lblBx);

        lblBxValue = new JLabel("0");
        panelReg.add(lblBxValue);

        lblCx = new JLabel("CX:");
        panelReg.add(lblCx);

        lblCxValue = new JLabel("0");
        panelReg.add(lblCxValue);

        lblSp = new JLabel("SP:");
        panelReg.add(lblSp);

        lblSpValue = new JLabel("0");
        panelReg.add(lblSpValue);

        lblBp = new JLabel("BP:");
        panelReg.add(lblBp);

        lblBpValue = new JLabel("0");
        panelReg.add(lblBpValue);

        lblIp = new JLabel("IP:");
        panelReg.add(lblIp);

        lblIpValue = new JLabel("0");
        panelReg.add(lblIpValue);

        panelLateralSecond = new JPanel();
        panelLateralLeste.add(panelLateralSecond);
        panelLateralSecond.setLayout(new BorderLayout(0, 0));
        panelLateralSecond.add(lblStack, BorderLayout.NORTH);

        JPanel panelStack = new JPanel();
        scrollPaneStack = new JScrollPane(panelStack);
        panelLateralSecond.add(scrollPaneStack, BorderLayout.CENTER);

        lblNewLabel = new JLabel("New label");
        panelStack.add(lblNewLabel);

        panelEditor = new JPanel();
        panelEditor.addKeyListener(keyListener);

        scrollPaneEditor = new JScrollPane(panelEditor);
        scrollPaneEditor.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneEditor.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneEditor.addKeyListener(keyListener);

        textEditor = new JTextArea();
        textEditor.setBorder(new NumberedBorder());
        textEditor.addKeyListener(keyListener);
        textEditor.getInputMap(JPanel.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK), "none");
        textEditor.getInputMap(JPanel.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK), "none");
        textEditor.getInputMap(JPanel.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK), "none");
        textEditor.getInputMap(JPanel.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK), "none");
        panelEditor.setLayout(new BoxLayout(panelEditor, BoxLayout.X_AXIS));
        panelEditor.add(textEditor);
        panelCentral.add(scrollPaneEditor, BorderLayout.CENTER);

        panelMsg = new JPanel();
        panelMsg.addKeyListener(keyListener);
        panelMsg.setLayout(new BoxLayout(panelMsg, BoxLayout.X_AXIS));
        panelMsg.setSize(panelMsg.getSize().width, 100);

        scrollPaneMsg = new JScrollPane(panelMsg);
        scrollPaneMsg.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneMsg.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneMsg.addKeyListener(keyListener);
        scrollPaneMsg.setPreferredSize(new Dimension(0, 100));

        textMsg = new JTextArea();
        panelMsg.add(textMsg);
        textMsg.setEditable(false);
        textMsg.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelCentral.add(scrollPaneMsg, BorderLayout.SOUTH);
        textMsg.addKeyListener(keyListener);
        textMsg.setFont(new Font("Console", Font.PLAIN, 11));

        panelFooter = new JPanel();
        panelCompilador.add(panelFooter, BorderLayout.SOUTH);
        panelFooter.setLayout(new GridLayout(1, 2, 0, 0));
        panelFooter.addKeyListener(keyListener);
        panelFooter.addKeyListener(keyListener);

        lbStatus = new JLabel(EStatus.NAO_MODIFICADO.toString());
        lbStatus.addKeyListener(keyListener);
        panelFooter.add(lbStatus);

        lbFilePath = new JLabel("");
        lbFilePath.addKeyListener(keyListener);
        panelFooter.add(lbFilePath);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    private CompilerInterface getInstance() {
        return this;
    }

    public JButton getBtnAbrir() {
        return btnCarregar;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnCompilar() {
        return btnRun;
    }

    public JButton getBtnGerarCod() {
        return btnStep;
    }

    public JButton getBtnEquipe() {
        return btnEquipe;
    }

    public JTextArea getTextEditor() {
        return textEditor;
    }

    public JTextArea getTextMsg() {
        return textMsg;
    }

    @Override
    public JPanel getContentPane() {
        return contentPane;
    }

    public JLabel getLbStatus() {
        return lbStatus;
    }

    public ImageIcon getImageIcon(String nomeIcone) {
        return new ImageIcon(this.getClass().getResource("/Images/" + nomeIcone));
    }

    public JLabel getLbFilePath() {
        return lbFilePath;
    }

    public ShortCutListener getKeyListener() {
        if (keyListener instanceof ShortCutListener) {
            return (ShortCutListener) keyListener;
        }
        return new ShortCutListener(this);
    }

}
