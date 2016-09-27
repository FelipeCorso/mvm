package mvm;

import javax.swing.JOptionPane;
/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

/**
 *
 * @author
 */
public class MVM {

    public static int botao = 0;

    public static void decodificador(short mem[], int programa, int aux) {
        int ax = 0, bx = 0, cx = 0, bp = 0, sp = 0, ip, ri;
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

            switch (ri) {
                case 0:// "init ax"
                    System.out.println("init ax");
                    ax = 0;
                    break;

                case 1:// "move ax,bx"
                    ax = bx;
                    break;
                case 2:// "move ax,cx",
                    ax = cx;
                    break;

                case 3:// "move bx,ax"
                    System.out.println("move bx,ax");
                    bx = ax;
                    break;

                case 4:// "move cx,ax"

                    cx = ax;

                    break;

                case 5:// "move ax,[",
                    ax = mem[mem[ip + 1]];
                    System.out.println("Executou move ax,[" + mem[ip + 1] + "]");
                    ip++;
                    break;

                case 6:// "move ax,[bx+"
                    ax = mem[bx + mem[ip + 1]];
                    System.out.println("Executou move ax, [bx+" + mem[ip + 1] + "]");
                    ip++;
                    break;

                case 7:// "move ax,[bp-"
                    ax = mem[bp - mem[ip + 1]];
                    System.out.println("Executou move ax, [bx-" + mem[ip + 1] + "]");
                    ip++;
                    break;

                case 8:// "move ax,[bp+"
                    ax = mem[bp + mem[ip + 1]];
                    System.out.println("Executou move ax, [bp+" + mem[ip + 1] + "]");
                    ip++;
                    break;

                case 9:// "move ["
                    mem[mem[ip + 1]] = (short) ax;
                    System.out.println("Executou move [" + mem[ip + 1] + "],ax");
                    ip++;

                    break;

                case 10:// "move [bx+"
                    mem[bx + mem[ip + 1]] = (short) ax;
                    System.out.println("Executou move [bx+" + mem[ip + 1] + "],ax");
                    ip++;

                    break;

                case 11:// "move bp,sp"

                    bp = sp;

                    break;

                case 12:// "move sp,bp"
                    System.out.println("move sp,bp");
                    sp = bp;

                    break;

                case 13:// "add ax,bx"

                    ax = ax + bx;

                    break;

                case 14:// "add ax,cx"

                    ax = ax + cx;

                    break;

                case 15:// "add bx,cx"

                    bx = bx + cx;

                    break;

                case 16:// "sub ax,bx"

                    ax = ax - bx;

                    break;

                case 17:// "sub ax,cx"

                    ax = ax - cx;

                    break;

                case 18:// "sub bx,cx"

                    bx = bx - cx;

                    break;

                case 19:// "inc ax"
                    System.out.println("inc ax");
                    ax++;

                    break;

                case 20:// "inc bx"
                    System.out.println("inc bx");
                    bx++;

                    break;

                case 21:// "inc cx"

                    cx++;

                    break;

                case 22:// "dec ax"
                    System.out.println("dec ax");
                    ax--;

                    break;

                case 23:// "dec bx"

                    bx--;

                    break;

                case 24:// "dec cx"

                    cx--;

                    break;

                case 25:// "test ax0,"

                    System.out.println("test ax0," + mem[ip + 1]);
                    if (ax == 0) {

                        ip = aux + mem[ip + 1] - 1; // -1 para compensar o ip++ no
                        // laco

                    } else {

                        ip++;

                    }

                    break;

                case 26:// "jmp "

                    ip = aux + mem[ip + 1];
                    System.out.println("jmp ");
                    ip--;

                    break;

                case 27:// "call"
                    mem[sp] = (short) (ip + 2);

                    sp--;

                    ip = aux + mem[ip + 1];

                    System.out.println("call " + ip);

                    ip--; // para compensar a alteracao de ip

                    break;

                case 28:// "ret"
                    System.out.println("ret");
                    sp++;

                    ip = mem[sp];

                    ip--;

                    break;

                case 29:// "in ax"

                    ax = Integer.parseInt(JOptionPane.showInputDialog("ax:"));
                    System.out.println("in ax," + ax);
                    break;

                case 30:// "out ax"

                    System.out.println("Saida: AX=" + ax);

                    break;

                case 31:// "push ax"
                    System.out.println("push ax");
                    mem[sp] = (short) ax;

                    sp--;

                    break;

                case 32:// "push bx"

                    mem[sp] = (short) bx;

                    sp--;

                    break;

                case 33:// "push cx"

                    mem[sp] = (short) cx;

                    sp--;

                    break;

                case 34:// "push bp"

                    mem[sp] = (short) bp;

                    sp--;

                    break;

                case 35:// "pop bp"

                    sp++;

                    bp = mem[sp];

                    break;

                case 36:// "pop cx"

                    sp++;

                    cx = mem[sp];

                    break;

                case 37:// "pop bx"

                    sp++;

                    bx = mem[sp];

                    break;

                case 38:// "pop ax"
                    System.out.println("pop ax");
                    sp++;

                    ax = mem[sp];

                    break;

                case 39:// "nop"

                    break;

                case 40: // "halt"
                    System.out.println("halt");
                    repetir = false;

                    break;

                case 41:// "dec sp"

                    sp--;

                    break;

                case 42:// "move [bp-"

                    mem[aux + bp - mem[ip + 1]] = (short) ax;

                    ip++;

                    break;

                case 43:// "move [bp+"

                    break;

                case 44:// "move ax,{"
                    ax = mem[ip + 1];
                    System.out.println("move ax,{" + ax + "}");
                    ip++;
                    break;

                case 45:// "test axEqbx,"

                    if (ax == bx) {
                        ip = mem[ip + 1] - 1;
                        System.out.println("Executou THEN test axEqbx -> ip" + mem[ip + 1]);
                    } else {

                        ip++;
                        System.out.println("Executou ELSE test axEqbx -> ip" + ip);

                    }

                    break;

                case 46:// "inc sp"

                    sp++;

                    break;

                case 47:// "move ax,sp"

                    ax = sp;

                    break;

                case 48:// "move sp,ax"
                    System.out.println("move sp,ax");
                    sp = ax;

                    break;

                case 49:// "move ax,bp"

                    ax = bp;

                    break;

                case 50:// "move bp,ax,{"

                    bp = ax;

                    break;

                case 51:// "iret"

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

                    bx = bx - ax;

                    break;

                default: {

                    repetir = false;

                    System.out.println("Saiu");

                }

                    if (ip >= mem.length) {

                        System.out.println("ERRO: a memoria nao pode ser lida");

                        repetir = false;

                    }

            }

            // System.out.println("Valor de mem[" + ip + "]: " + ri);

            ip++;
            // System.out.println("IP - " + ip);
        }

        /**
         * for (int i = 0; i < ip; i++) { System.out.println("Valor de mem[" + i
         * + "]: " + mem[i]); } System.out.println("Valor de AX: " + ax);
         * System.out.println("Valor de BX: " + bx); System.out.println(
         * "Valor de CX: " + cx); System.out.println("Valor de SP: " + sp);
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
}
