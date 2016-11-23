package br.furb.trab2.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.StyledDocument;

import br.furb.mvm.Arquivo;

public class MainInterface extends JFrame {

    private static final int INVALID_PROGRAM = -1;
    private static final long serialVersionUID = -5095957758803292405L;
    private JPanel contentPane;
    private JTextPane textPane = new JTextPane();
    private StyledDocument programLog = textPane.getStyledDocument();
    private JTextField txfLoadAddress;
    private JTextField txfProgram;
    private MainMVM mainMVM;

    /**
     * Launch the application.
     */

    /*
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
    
            @Override
            public void run() {
                try {
                    MainInterface frame = new MainInterface();
                    frame.setVisible(true);
                    frame.mainMVM = new MainMVM(frame);
    
                    frame.mainMVM.executar(new File("steps.txt"), 0);
    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    */

    /**
     * Create the frame.
     * 
     * @param serverTime
     */

    public MainInterface() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("Arquivo");
        menuBar.add(mnFile);

        JMenuItem mntmExecute = new JMenuItem("Executar");
        mntmExecute.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    int loadAddress = 0;
                    if (!txfLoadAddress.getText().equals("")) {
                        loadAddress = Integer.parseInt(txfLoadAddress.getText());
                    }
                    mainMVM.executar(selectedFile, loadAddress);
                    try {
                        textPane.setText(programLog.getText(0, programLog.getLength()));
                    } catch (BadLocationException e1) {
                        // TODO Auto-generated catch block
                        throw new RuntimeException(e1);
                    }
                }
            }
        });
        mnFile.add(mntmExecute);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblLoadAddress = new JLabel("Endereço de carga:");

        DefaultCaret caret = (DefaultCaret) textPane.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        JScrollPane scrollPane = new JScrollPane();

        txfLoadAddress = new JTextField();
        txfLoadAddress.setColumns(10);

        JLabel lblProgram = new JLabel("Programa:");

        txfProgram = new JTextField();
        txfProgram.setColumns(10);

        JButton btnTranslate = new JButton("Traduzir");
        btnTranslate.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                mainMVM.traduzir(getProgram(), 0);
                textPane.setText(Arquivo.le(new File("programa" + getProgram() + ".txt")));
            }
        });

        JButton btnExecutar = new JButton("Executar");
        btnExecutar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    int loadAddress = 0;
                    if (!txfLoadAddress.getText().equals("")) {
                        loadAddress = Integer.parseInt(txfLoadAddress.getText());
                    }
                    mainMVM.executar(selectedFile, loadAddress);
                }
            }
        });

        JLabel lblLimpar = new JLabel("Limpar");
        lblLimpar.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    programLog.remove(0, programLog.getLength());
                } catch (BadLocationException ble) {
                    ble.printStackTrace();
                }
            }
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE).addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblLoadAddress, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE).addComponent(lblProgram)).addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addComponent(txfProgram, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnTranslate).addGap(18).addComponent(btnExecutar).addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE).addComponent(lblLimpar)).addComponent(txfLoadAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))).addContainerGap()));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblLoadAddress).addComponent(txfLoadAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblProgram).addComponent(txfProgram, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnTranslate).addComponent(btnExecutar).addComponent(lblLimpar)).addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)));
        scrollPane.setViewportView(textPane);

        textPane.setEditable(false);
        contentPane.setLayout(gl_contentPane);

    }

    public void addProgramLog(String log) {
        try {
            programLog.insertString(programLog.getLength(), log + "\n", null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getProgram() {
        if (!txfProgram.getText().equals("")) {
            return Integer.parseInt(txfProgram.getText());
        }
        return INVALID_PROGRAM;
    }

}
