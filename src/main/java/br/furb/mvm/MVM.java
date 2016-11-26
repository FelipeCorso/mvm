package br.furb.mvm;

import java.io.File;

import javax.swing.JOptionPane;

import br.furb.mvm.ui.CompilerInterface;

/**
 *
 * @author
 */
public class MVM {

    private static int ax = 0, bx = 0, cx = 0, bp = 0, sp = 0, ip;
    public static int botao = 0;
    public StringBuilder programaString = new StringBuilder();

    public static void decodificador(short mem[], int programa, int aux) {
        decodificador(mem, programa, aux, null);
    }

    public static void decodificador(short mem[], int programa, int aux, CompilerInterface uiView) {
        int ri;
        boolean repetir = true;
        ip = 0 + aux;
        while (repetir) {
            // System.out.println("Valor de IP: " + ip);
            if (botao == 1) {
                // "push ip"
                mem[sp] = (short) ip;
                sp--;

                // "push bp"
                mem[sp] = (short) bp;
                sp--;

                // "push ax"
                mem[sp] = (short) ax;
                sp--;

                // "push bx"
                mem[sp] = (short) bx;
                sp--;

                // "push cx"
                mem[sp] = (short) cx;
                sp--;

                ip = mem[0];
                botao = 0;
                System.out.println("EXECUTOU INTERRUPCAO: INT3");
            }

            ri = mem[ip];
            String instrucao = "";
            switch (ri) {
                case 0:// "init ax"
                    instrucao = "init ax";
                    ax = 0;
                    break;

                case 1:// "move ax,bx"
                    instrucao = "move ax,bx";
                    ax = bx;
                    break;
                case 2:// "move ax,cx",
                    instrucao = "move ax,cx";
                    ax = cx;
                    break;

                case 3:// "move bx,ax"
                    instrucao = "move bx,ax";
                    bx = ax;
                    break;

                case 4:// "move cx,ax"
                    instrucao = "move cx,ax";
                    cx = ax;

                    break;

                case 5:// "move ax,[",
                    ax = mem[mem[ip + 1]];
                    instrucao = "Executou move ax,[" + mem[ip + 1] + "]";
                    ip++;
                    break;

                case 6:// "move ax,[bx+"
                    ax = mem[bx + mem[ip + 1]];
                    instrucao = "Executou move ax, [bx+" + mem[ip + 1] + "]";
                    ip++;
                    break;

                case 7:// "move ax,[bp-"
                    ax = mem[bp - mem[ip + 1]];
                    instrucao = "Executou move ax, [bx-" + mem[ip + 1] + "]";
                    ip++;
                    break;

                case 8:// "move ax,[bp+"
                    ax = mem[bp + mem[ip + 1]];
                    instrucao = "Executou move ax, [bp+" + mem[ip + 1] + "]";
                    ip++;
                    break;

                case 9:// "move ["
                    mem[mem[ip + 1]] = (short) ax;
                    instrucao = "Executou move [" + mem[ip + 1] + "],ax";
                    ip++;

                    break;

                case 10:// "move [bx+"
                    mem[bx + mem[ip + 1]] = (short) ax;
                    instrucao = "Executou move [bx+" + mem[ip + 1] + "],ax";
                    ip++;

                    break;

                case 11:// "move bp,sp"
                    instrucao = "move bp,sp";
                    bp = sp;

                    break;

                case 12:// "move sp,bp"
                    instrucao = "move sp,bp";
                    sp = bp;

                    break;

                case 13:// "add ax,bx"
                    instrucao = "add ax,bx";
                    ax = ax + bx;

                    break;

                case 14:// "add ax,cx"
                    instrucao = "add ax,cx";
                    ax = ax + cx;

                    break;

                case 15:// "add bx,cx"
                    instrucao = "add bx,cx";
                    bx = bx + cx;

                    break;

                case 16:// "sub ax,bx"
                    instrucao = "sub ax,bx";
                    ax = ax - bx;

                    break;

                case 17:// "sub ax,cx"
                    instrucao = "sub ax,cx";
                    ax = ax - cx;

                    break;

                case 18:// "sub bx,cx"
                    instrucao = "sub bx,cx";
                    bx = bx - cx;

                    break;

                case 19:// "inc ax"
                    instrucao = "inc ax";
                    ax++;

                    break;

                case 20:// "inc bx"
                    instrucao = "inc bx";
                    bx++;

                    break;

                case 21:// "inc cx"
                    instrucao = "inc cx";
                    cx++;

                    break;

                case 22:// "dec ax"
                    instrucao = "dec ax";
                    ax--;

                    break;

                case 23:// "dec bx"
                    instrucao = "dec bx";
                    bx--;

                    break;

                case 24:// "dec cx"
                    instrucao = "dec cx";
                    cx--;

                    break;

                case 25:// "test ax0,"

                    instrucao = "test ax0," + mem[ip + 1];
                    if (ax == 0) {

                        ip = aux + mem[ip + 1] - 1; // -1 para compensar o ip++ no
                        // laco

                    } else {

                        ip++;

                    }

                    break;

                case 26:// "jmp "

                    ip = aux + mem[ip + 1];
                    instrucao = "jmp ";
                    ip--;

                    break;

                case 27:// "call"
                    mem[sp] = (short) (ip + 2);

                    sp--;

                    ip = aux + mem[ip + 1];

                    instrucao = "call " + ip;

                    ip--; // para compensar a alteracao de ip

                    break;

                case 28:// "ret"
                    instrucao = "ret";
                    sp++;

                    ip = mem[sp];

                    ip--;

                    break;

                case 29:// "in ax"

                    ax = Integer.parseInt(JOptionPane.showInputDialog("ax:"));
                    instrucao = "in ax," + ax;
                    break;

                case 30:// "out ax"

                    instrucao = "Saida: AX=" + ax;

                    break;

                case 31:// "push ax"
                    instrucao = "push ax";
                    mem[sp] = (short) ax;

                    sp--;

                    break;

                case 32:// "push bx"
                    instrucao = "push bx";
                    mem[sp] = (short) bx;

                    sp--;

                    break;

                case 33:// "push cx"
                    instrucao = "push cx";
                    mem[sp] = (short) cx;

                    sp--;

                    break;

                case 34:// "push bp"
                    instrucao = "push bp";
                    mem[sp] = (short) bp;

                    sp--;

                    break;

                case 35:// "pop bp"
                    instrucao = "pop bp";
                    sp++;

                    bp = mem[sp];

                    break;

                case 36:// "pop cx"
                    instrucao = "pop cx";
                    sp++;

                    cx = mem[sp];

                    break;

                case 37:// "pop bx"
                    instrucao = "pop bx";
                    sp++;

                    bx = mem[sp];

                    break;

                case 38:// "pop ax"
                    instrucao = "pop ax";
                    sp++;

                    ax = mem[sp];

                    break;

                case 39:// "nop"
                    instrucao = "nop";
                    break;

                case 40: // "halt"
                    instrucao = "halt";
                    repetir = false;

                    break;

                case 41:// "dec sp"
                    instrucao = "dec sp";
                    sp--;

                    break;

                case 42:// "move [bp-"
                    instrucao = "move [bp-";
                    mem[aux + bp - mem[ip + 1]] = (short) ax;

                    ip++;

                    break;

                case 43:// "move [bp+"
                    instrucao = "move [bp+";
                    break;

                case 44:// "move ax,{"
                    ax = mem[ip + 1];
                    instrucao = "move ax,{" + ax + "}";
                    ip++;
                    break;

                case 45:// "test axEqbx,"

                    if (ax == bx) {
                        ip = mem[ip + 1] - 1;
                        instrucao = "Executou THEN test axEqbx -> ip" + mem[ip + 1];
                    } else {

                        ip++;
                        instrucao = "Executou ELSE test axEqbx -> ip" + ip;

                    }

                    break;

                case 46:// "inc sp"
                    instrucao = "inc sp";
                    sp++;

                    break;

                case 47:// "move ax,sp"
                    instrucao = "move ax,sp";
                    ax = sp;

                    break;

                case 48:// "move sp,ax"
                    instrucao = "move sp,ax";
                    sp = ax;

                    break;

                case 49:// "move ax,bp"
                    instrucao = "move ax,bp";
                    ax = bp;

                    break;

                case 50:// "move bp,ax,{"
                    instrucao = "move bp,ax";
                    bp = ax;

                    break;

                case 51:// "iret"
                    instrucao = "iret";
                    // "pop cx"

                    sp++;

                    cx = mem[sp];

                    // "pop bx"

                    sp++;

                    bx = mem[sp];

                    // "pop ax"

                    sp++;

                    ax = mem[sp];

                    // "pop bp"

                    sp++;

                    bp = mem[sp];

                    // "ret"

                    sp++;

                    ip = mem[sp];

                    ip--;

                    break;

                case 52:// "int"
                    instrucao = "int";
                    // "push ip"
                    mem[sp] = (short) (ip + 2);
                    sp--;

                    // "push bp"
                    mem[sp] = (short) bp;
                    sp--;

                    // "push ax"
                    mem[sp] = (short) ax;
                    sp--;

                    // "push bx"
                    mem[sp] = (short) bx;
                    sp--;

                    // "push cx"
                    mem[sp] = (short) cx;
                    sp--;

                    ip = mem[aux + mem[ip + 1]];
                    ip--;

                    break;
                case 53:// "sub bx,ax"
                    instrucao = "sub bx,ax";
                    bx = bx - ax;

                    break;

                default: {

                    repetir = false;

                    instrucao = "Saiu";

                }

                    if (ip >= mem.length) {

                        instrucao = "ERRO: a memoria nao pode ser lida";

                        repetir = false;

                    }

            }
            if (!instrucao.equals("") && uiView != null) {
                System.out.println(instrucao);
                uiView.addProgramLog(instrucao);
            }

            // System.out.println("Valor de mem[" + ip + "]: " + ri);

            ip++;
            // System.out.println("IP - " + ip);
        }

        /**
         * for (int i = 0; i < ip; i++) { System.out.println("Valor de mem[" + i
         * + "]: " + mem[i]); } System.out.println("Valor de AX: " + ax);
         * System.out.println("Valor de BX: " + bx); System.out.println( "Valor
         * de CX: " + cx); System.out.println("Valor de SP: " + sp);
         * 
         * 
         * System.out.println("Valor de mem[3]: " + mem[3]); System.out.println(
         * "Valor de mem[4]: " + mem[4]); System.out.println("Valor de mem[5]: "
         * + mem[5]); System.out.println("Valor de mem[14]: " + mem[14]);
         * System.out.println("Valor de mem[13]: " + mem[13]);
         * System.out.println("Valor de mem[12]: " + mem[12]);
         * System.out.println("Valor de mem[11]: " + mem[11]);
         **/
    }

    /**
     * Criado outro metodo para traduzir pois o professor não queria na forma de
     * log
     * 
     * @param mem
     * @param programa
     * @param enderecoDeCarga
     * @param programa
     */
    public static void tradutor(short mem[], int numeroBytes, int enderecoDeCarga, int programa) {
        tradutor(mem, numeroBytes, enderecoDeCarga, programa, null);
    }

    public static void tradutor(short mem[], int numeroBytes, int enderecoDeCarga, int programa, CompilerInterface uiView) {
        int ax = 0, bx = 0, cx = 0, bp = 0, sp = 0, ri;
        StringBuilder strBuilder = new StringBuilder();
        String traduzido = "";
        int tmpLine = 0;
        for (int line = enderecoDeCarga; line < numeroBytes + enderecoDeCarga; line++) {
            ri = mem[line];
            switch (ri) {
                case 0:// "init ax"
                    ax = 0;
                    traduzido = "init ax";
                    break;
                case 1:// "move ax,bx"
                    ax = bx;
                    traduzido = "move ax,bx";
                    break;
                case 2:// "move ax,cx",
                    ax = cx;
                    traduzido = "move ax,cx";
                    break;
                case 3:// "move bx,ax"
                    traduzido = "move bx,ax";
                    bx = ax;
                    break;
                case 4:// "move cx,ax"
                    cx = ax;
                    traduzido = "move cx,ax";
                    break;
                case 5:// "move ax,[",
                    ax = mem[mem[line + 1]];
                    traduzido = "move ax,[" + mem[line + 1] + "]";
                    line++;
                    break;
                case 6:// "move ax,[bx+"
                    ax = mem[bx + mem[line + 1]];
                    traduzido = "move ax,[bx+" + mem[line + 1] + "]";
                    line++;
                    break;
                case 7:// "move ax,[bp-"
                    ax = mem[bp - mem[line + 1]];
                    traduzido = "Executou move ax, [bx-" + mem[line + 1] + "]";
                    line++;
                    break;
                case 8:// "move ax,[bp+"
                    ax = mem[bp + mem[line + 1]];
                    traduzido = "Executou move ax, [bp+" + mem[line + 1] + "]";
                    line++;
                    break;
                case 9:// "move ["
                    mem[mem[line + 1]] = (short) ax;
                    traduzido = "move [" + mem[line + 1] + "],ax";
                    line++;
                    break;
                case 10:// "move [bx+"
                    mem[bx + mem[line + 1]] = (short) ax;
                    traduzido = "move [bx+" + mem[line + 1] + "],ax";
                    line++;
                    break;
                case 11:// "move bp,sp"
                    bp = sp;
                    traduzido = "move bp,sp";
                    break;
                case 12:// "move sp,bp"
                    sp = bp;
                    traduzido = "move sp,bp";
                    break;
                case 13:// "add ax,bx"
                    ax = ax + bx;
                    traduzido = "add ax,bx";
                    break;
                case 14:// "add ax,cx"
                    ax = ax + cx;
                    traduzido = "add ax,cx";
                    break;
                case 15:// "add bx,cx"
                    bx = bx + cx;
                    traduzido = "add bx,cx";
                    break;
                case 16:// "sub ax,bx"
                    ax = ax - bx;
                    traduzido = "sub ax,bx";
                    break;
                case 17:// "sub ax,cx"
                    ax = ax - cx;
                    traduzido = "sub ax,cx";
                    break;
                case 18:// "sub bx,cx"
                    bx = bx - cx;
                    traduzido = "sub bx,cx";
                    break;
                case 19:// "inc ax"
                    ax++;
                    traduzido = "inc ax";
                    break;
                case 20:// "inc bx"
                    bx++;
                    traduzido = "inc bx";
                    break;
                case 21:// "inc cx"
                    cx++;
                    traduzido = "inc cx";
                    break;
                case 22:// "dec ax"
                    ax--;
                    traduzido = "dec ax";
                    break;
                case 23:// "dec bx"
                    bx--;
                    traduzido = "dec bx";
                    break;
                case 24:// "dec cx"
                    cx--;
                    traduzido = "dec cx";
                    break;
                case 25:// "test ax0,"
                    traduzido = "test ax0," + mem[line + 1];
                    if (ax == 0) {
                        //						line = enderecoDeCarga + mem[line + 1] - 1; // -1 para compensar o line++ no laco
                    } else {
                        line++;
                    }
                    break;
                case 26:// "jmp "
                    tmpLine = enderecoDeCarga + mem[line + 1];
                    traduzido = "jmp " + tmpLine;
                    line++;
                    break;
                case 27:// "call"
                    mem[sp] = (short) (line + 2);
                    sp--;
                    line = enderecoDeCarga + mem[line + 1];
                    traduzido = "call " + line;
                    line--; // para compensar a alteracao de ip
                    break;
                case 28:// "ret"
                    traduzido = "ret";
                    sp++;
                    line = mem[sp];
                    line--;
                    break;
                case 29:// "in ax"
                    traduzido = "in ax";
                    break;
                case 30:// "out ax"
                    traduzido = "AX=" + ax;
                    break;
                case 31:// "push ax"
                    traduzido = "push ax";
                    mem[sp] = (short) ax;
                    sp--;
                    break;
                case 32:// "push bx"
                    traduzido = "push bx";
                    mem[sp] = (short) bx;
                    sp--;
                    break;
                case 33:// "push cx"
                    traduzido = "push cx";
                    mem[sp] = (short) cx;
                    sp--;
                    break;
                case 34:// "push bp"
                    traduzido = "push bp";
                    mem[sp] = (short) bp;
                    sp--;
                    break;
                case 35:// "pop bp"
                    traduzido = "pop bp";
                    sp++;
                    bp = mem[sp];
                    break;
                case 36:// "pop cx"
                    traduzido = "pop cx";
                    sp++;
                    cx = mem[sp];
                    break;
                case 37:// "pop bx"
                    traduzido = "pop bx";
                    sp++;
                    bx = mem[sp];
                    break;
                case 38:// "pop ax"
                    traduzido = "pop ax";
                    sp++;
                    ax = mem[sp];
                    break;
                case 39:// "nop"
                    traduzido = "nop";
                    break;
                case 40: // "halt"
                    traduzido = "halt";
                    break;
                case 41:// "dec sp"
                    traduzido = "dec sp";
                    sp--;
                    break;
                case 42:// "move [bp-"
                    traduzido = "move [bp-" + ax + "]";
                    mem[enderecoDeCarga + bp - mem[line + 1]] = (short) ax;
                    line++;
                    break;
                case 43:// "move [bp+"
                    traduzido = "move [bp+" + ax + "]";
                    mem[enderecoDeCarga + bp + mem[line + 1]] = (short) ax;
                    line++;
                    break;
                case 44:// "move ax,{"
                    ax = mem[line + 1];
                    traduzido = "move ax,{" + ax + "}";
                    line++;
                    break;
                case 45:// "test axEqbx,"
                    traduzido = "test axEqbx,";
                    if (ax == bx) {
                        line = mem[line + 1] - 1;
                    } else {
                        line++;
                    }
                    break;
                case 46:// "inc sp"
                    traduzido = "inc sp";
                    sp++;
                    break;
                case 47:// "move ax,sp"
                    traduzido = "move ax,sp";
                    ax = sp;
                    break;
                case 48:// "move sp,ax"
                    traduzido = "move sp,ax";
                    sp = ax;
                    break;
                case 49:// "move ax,bp"
                    traduzido = "move ax,bp";
                    ax = bp;
                    break;
                case 50:// "move bp,ax"
                    traduzido = "move bp,ax";
                    bp = ax;
                    break;
                case 51:// "iret"
                    traduzido = "iret";
                    // "pop cx"
                    sp++;
                    cx = mem[sp];
                    // "pop bx"
                    sp++;
                    bx = mem[sp];
                    // "pop ax"
                    sp++;
                    ax = mem[sp];
                    // "pop bp"
                    sp++;
                    bp = mem[sp];
                    // "ret"
                    sp++;
                    line = mem[sp];
                    line--;
                    break;
                case 52:// "int"
                    traduzido = "int";
                    // "push ip"
                    mem[sp] = (short) (line + 2);
                    sp--;
                    // "push bp"
                    mem[sp] = (short) bp;
                    sp--;
                    // "push ax"
                    mem[sp] = (short) ax;
                    sp--;
                    // "push bx"
                    mem[sp] = (short) bx;
                    sp--;
                    // "push cx"
                    mem[sp] = (short) cx;
                    sp--;
                    line = mem[enderecoDeCarga + mem[line + 1]];
                    line--;
                    break;
                case 53:// "sub bx,ax"
                    bx = bx - ax;
                    traduzido = "sub bx,ax";
                    break;
                default:
                    traduzido = "saiu";
                    System.out.println("Saiu");
                    if (line >= mem.length) {
                        System.out.println("ERRO: a memoria nao pode ser lida");
                        traduzido = "ERRO: a memoria nao pode ser lida";
                    }
                    break;
            }
            if (uiView != null) {
                uiView.addProgramLog(traduzido);
            }
            strBuilder.append(traduzido);
            strBuilder.append(System.getProperty("line.separator"));
        }

        Arquivo.escreve(new File("programa" + programa + ".txt"), strBuilder.toString());
    }

    public static void gerarClock(short[] mem, int quantidadeInstrucoes, int enderecoDeCarga, int programa) {
        int ax = 0, bx = 0, cx = 0, bp = 0, sp = 0, ri;
        StringBuilder strBuilder = new StringBuilder();
        String traduzido = "";
        int tmpLine = 0;
        int clock = 0;
        for (int line = enderecoDeCarga; line < quantidadeInstrucoes + enderecoDeCarga; line++) {
            ri = mem[line];
            switch (ri) {
                case 0:// "init ax"
                    ax = 0;
                    traduzido = "init ax";
                    clock++;
                    break;
                case 1:// "move ax,bx"
                    ax = bx;
                    traduzido = "move ax,bx";
                    clock++;
                    break;
                case 2:// "move ax,cx",
                    ax = cx;
                    traduzido = "move ax,cx";
                    clock++;
                    break;
                case 3:// "move bx,ax"
                    traduzido = "move bx,ax";
                    bx = ax;
                    clock++;
                    break;
                case 4:// "move cx,ax"
                    cx = ax;
                    traduzido = "move cx,ax";
                    clock++;
                    break;
                case 5:// "move ax,[",
                    ax = mem[mem[line + 1]];
                    traduzido = "move ax,[" + mem[line + 1] + "]";
                    clock = clock + 2;
                    line++;
                    break;
                case 6:// "move ax,[bx+"
                    ax = mem[bx + mem[line + 1]];
                    traduzido = "move ax,[bx+" + mem[line + 1] + "]";
                    clock = clock + 2;
                    line++;
                    break;
                case 7:// "move ax,[bp-"
                    ax = mem[bp - mem[line + 1]];
                    traduzido = "Executou move ax, [bx-" + mem[line + 1] + "]";
                    clock = clock + 2;
                    line++;
                    break;
                case 8:// "move ax,[bp+"
                    ax = mem[bp + mem[line + 1]];
                    traduzido = "Executou move ax, [bp+" + mem[line + 1] + "]";
                    clock = clock + 2;
                    line++;
                    break;
                case 9:// "move ["
                    mem[mem[line + 1]] = (short) ax;
                    traduzido = "move [" + mem[line + 1] + "],ax";
                    clock = clock + 2;
                    line++;
                    break;
                case 10:// "move [bx+"
                    mem[bx + mem[line + 1]] = (short) ax;
                    traduzido = "move [bx+" + mem[line + 1] + "],ax";
                    clock = clock + 2;
                    line++;
                    break;
                case 11:// "move bp,sp"
                    bp = sp;
                    traduzido = "move bp,sp";
                    clock++;
                    break;
                case 12:// "move sp,bp"
                    sp = bp;
                    traduzido = "move sp,bp";
                    clock++;
                    break;
                case 13:// "add ax,bx"
                    ax = ax + bx;
                    traduzido = "add ax,bx";
                    clock++;
                    break;
                case 14:// "add ax,cx"
                    ax = ax + cx;
                    traduzido = "add ax,cx";
                    clock++;
                    break;
                case 15:// "add bx,cx"
                    bx = bx + cx;
                    traduzido = "add bx,cx";
                    clock++;
                    break;
                case 16:// "sub ax,bx"
                    ax = ax - bx;
                    traduzido = "sub ax,bx";
                    clock++;
                    break;
                case 17:// "sub ax,cx"
                    ax = ax - cx;
                    traduzido = "sub ax,cx";
                    clock++;
                    break;
                case 18:// "sub bx,cx"
                    bx = bx - cx;
                    traduzido = "sub bx,cx";
                    clock++;
                    break;
                case 19:// "inc ax"
                    ax++;
                    traduzido = "inc ax";
                    clock++;
                    break;
                case 20:// "inc bx"
                    bx++;
                    traduzido = "inc bx";
                    clock++;
                    break;
                case 21:// "inc cx"
                    cx++;
                    traduzido = "inc cx";
                    clock++;
                    break;
                case 22:// "dec ax"
                    ax--;
                    traduzido = "dec ax";
                    clock++;
                    break;
                case 23:// "dec bx"
                    bx--;
                    traduzido = "dec bx";
                    clock++;
                    break;
                case 24:// "dec cx"
                    cx--;
                    traduzido = "dec cx";
                    clock++;
                    break;
                case 25:// "test ax0,"
                    traduzido = "test ax0," + mem[line + 1];
                    if (ax == 0) {
                        //                      line = enderecoDeCarga + mem[line + 1] - 1; // -1 para compensar o line++ no laco
                    } else {
                        clock = clock + 2;
                        line++;
                    }
                    clock++;
                    break;
                case 26:// "jmp "
                    tmpLine = enderecoDeCarga + mem[line + 1];
                    traduzido = "jmp " + tmpLine;
                    clock = clock + 2;
                    line++;
                    break;
                case 27:// "call"
                    mem[sp] = (short) (line + 2);
                    sp--;
                    line = enderecoDeCarga + mem[line + 1];
                    traduzido = "call " + line;
                    line--; // para compensar a alteracao de ip
                    clock++;
                    break;
                case 28:// "ret"
                    traduzido = "ret";
                    sp++;
                    line = mem[sp];
                    line--;
                    clock++;
                    break;
                case 29:// "in ax"
                    traduzido = "in ax";
                    clock++;
                    break;
                case 30:// "out ax"
                    traduzido = "AX=" + ax;
                    clock++;
                    break;
                case 31:// "push ax"
                    traduzido = "push ax";
                    mem[sp] = (short) ax;
                    sp--;
                    clock++;
                    break;
                case 32:// "push bx"
                    traduzido = "push bx";
                    mem[sp] = (short) bx;
                    sp--;
                    clock++;
                    break;
                case 33:// "push cx"
                    traduzido = "push cx";
                    mem[sp] = (short) cx;
                    sp--;
                    clock++;
                    break;
                case 34:// "push bp"
                    traduzido = "push bp";
                    mem[sp] = (short) bp;
                    sp--;
                    clock++;
                    break;
                case 35:// "pop bp"
                    traduzido = "pop bp";
                    sp++;
                    bp = mem[sp];
                    clock++;
                    break;
                case 36:// "pop cx"
                    traduzido = "pop cx";
                    sp++;
                    cx = mem[sp];
                    clock++;
                    break;
                case 37:// "pop bx"
                    traduzido = "pop bx";
                    sp++;
                    bx = mem[sp];
                    clock++;
                    break;
                case 38:// "pop ax"
                    traduzido = "pop ax";
                    sp++;
                    ax = mem[sp];
                    clock++;
                    break;
                case 39:// "nop"
                    traduzido = "nop";
                    clock++;
                    break;
                case 40: // "halt"
                    traduzido = "halt";
                    clock++;
                    break;
                case 41:// "dec sp"
                    traduzido = "dec sp";
                    sp--;
                    clock++;
                    break;
                case 42:// "move [bp-"
                    traduzido = "move [bp-" + ax + "]";
                    mem[enderecoDeCarga + bp - mem[line + 1]] = (short) ax;
                    clock = clock + 2;
                    line++;
                    break;
                case 43:// "move [bp+"
                    traduzido = "move [bp+" + ax + "]";
                    mem[enderecoDeCarga + bp + mem[line + 1]] = (short) ax;
                    clock = clock + 2;
                    line++;
                    break;
                case 44:// "move ax,{"
                    ax = mem[line + 1];
                    traduzido = "move ax,{" + ax + "}";
                    clock = clock + 2;
                    line++;
                    break;
                case 45:// "test axEqbx,"
                    traduzido = "test axEqbx,";
                    if (ax == bx) {
                        line = mem[line + 1] - 1;
                    } else {
                        clock = clock + 2;
                        line++;
                    }
                    clock++;
                    break;
                case 46:// "inc sp"
                    traduzido = "inc sp";
                    sp++;
                    clock++;
                    break;
                case 47:// "move ax,sp"
                    traduzido = "move ax,sp";
                    ax = sp;
                    clock++;
                    break;
                case 48:// "move sp,ax"
                    traduzido = "move sp,ax";
                    sp = ax;
                    clock++;
                    break;
                case 49:// "move ax,bp"
                    traduzido = "move ax,bp";
                    ax = bp;
                    clock++;
                    break;
                case 50:// "move bp,ax"
                    traduzido = "move bp,ax";
                    bp = ax;
                    clock++;
                    break;
                case 51:// "iret"
                    traduzido = "iret";
                    // "pop cx"
                    sp++;
                    cx = mem[sp];
                    // "pop bx"
                    sp++;
                    bx = mem[sp];
                    // "pop ax"
                    sp++;
                    ax = mem[sp];
                    // "pop bp"
                    sp++;
                    bp = mem[sp];
                    // "ret"
                    sp++;
                    line = mem[sp];
                    line--;
                    clock++;
                    break;
                case 52:// "int"
                    traduzido = "int";
                    // "push ip"
                    mem[sp] = (short) (line + 2);
                    sp--;
                    // "push bp"
                    mem[sp] = (short) bp;
                    sp--;
                    // "push ax"
                    mem[sp] = (short) ax;
                    sp--;
                    // "push bx"
                    mem[sp] = (short) bx;
                    sp--;
                    // "push cx"
                    mem[sp] = (short) cx;
                    sp--;
                    line = mem[enderecoDeCarga + mem[line + 1]];
                    line--;
                    clock++;
                    break;
                case 53:// "sub bx,ax"
                    bx = bx - ax;
                    traduzido = "sub bx,ax";
                    clock++;
                    break;
                default:
                    traduzido = "saiu";
                    System.out.println("Saiu");
                    if (line >= mem.length) {
                        System.out.println("ERRO: a memoria nao pode ser lida");
                        traduzido = "ERRO: a memoria nao pode ser lida";
                    }
                    clock++;
                    break;
            }
        }
        Arquivo.escreve(new File("clockprograma" + programa + ".txt"), String.valueOf(clock));
    }

    public static int getAx() {
        return ax;
    }

    public static int getBx() {
        return bx;
    }

    public static int getCx() {
        return cx;
    }

    public static int getBp() {
        return bp;
    }

    public static int getSp() {
        return sp;
    }

    public static int getIp() {
        return ip;
    }

}
