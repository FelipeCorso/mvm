package br.com.andreluizlunelli.mvm;

import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 * 
 * TODO TEM QUE ADD O BOTÃO PARA SALVAR AO INVES DE EXECUTAR
 */
/**
 *
 * @author
 */
public class MainMVM {

    public static void main(String[] args) {
        short mem[] = new short[1025];
        int programa = Integer.parseInt(JOptionPane.showInputDialog("Escolha um Programa: "));
        // Botao.main(args, mem);
        int enderecoDeCarga = 50;
        int quantidadeInstrucoes = 0;
        switch (programa) {
            case 0:
                mem[0 + enderecoDeCarga] = 0; // init ax
                mem[1 + enderecoDeCarga] = 26; // jmp 0
                mem[2 + enderecoDeCarga] = 0;
                mem[3 + enderecoDeCarga] = 40; // halt
                quantidadeInstrucoes = 4;
                break;
            case 1:
                mem[0 + enderecoDeCarga] = 0; // init ax
                mem[1 + enderecoDeCarga] = 44; // move ax, {val}
                mem[2 + enderecoDeCarga] = 3; // 
                mem[3 + enderecoDeCarga] = 19; // inc ax
                mem[4 + enderecoDeCarga] = 9; // move [val], ax
                mem[5 + enderecoDeCarga] = 2; // 
                mem[6 + enderecoDeCarga] = 40; // halt
                quantidadeInstrucoes = 7;
                break;
            case 2:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 19;
                mem[2 + enderecoDeCarga] = 19;
                mem[3 + enderecoDeCarga] = 19;
                mem[4 + enderecoDeCarga] = 19;
                mem[5 + enderecoDeCarga] = 19;
                mem[6 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 7;
                break;
            case 3:
                mem[0 + enderecoDeCarga] = 0; // init ax
                mem[1 + enderecoDeCarga] = 3; // move bx,ax
                mem[2 + enderecoDeCarga] = 29; // in ax
                mem[3 + enderecoDeCarga] = 20; // inc bx
                mem[4 + enderecoDeCarga] = 20; // inc bx
                mem[5 + enderecoDeCarga] = 20; // inc bx
                mem[6 + enderecoDeCarga] = 22; // dec ax
                mem[7 + enderecoDeCarga] = 25; // test ax0, 11
                mem[8 + enderecoDeCarga] = 11;
                mem[9 + enderecoDeCarga] = 26; // jmp
                mem[10 + enderecoDeCarga] = 3;
                mem[11 + enderecoDeCarga] = 40; // halt
                quantidadeInstrucoes = 12;
                break;
            case 4:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 19;
                mem[2 + enderecoDeCarga] = 19;
                mem[3 + enderecoDeCarga] = 9;
                mem[4 + enderecoDeCarga] = 15;
                mem[5 + enderecoDeCarga] = 19;
                mem[6 + enderecoDeCarga] = 19;
                mem[7 + enderecoDeCarga] = 3;
                mem[8 + enderecoDeCarga] = 5;
                mem[9 + enderecoDeCarga] = 15;
                mem[10 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 11;
                break;
            case 5:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 44;
                mem[2 + enderecoDeCarga] = 50;
                mem[3 + enderecoDeCarga] = 48;
                mem[4 + enderecoDeCarga] = 0;
                mem[5 + enderecoDeCarga] = 19;
                mem[6 + enderecoDeCarga] = 31;
                mem[7 + enderecoDeCarga] = 37;
                mem[8 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 9;
                break;
            case 6:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 3;
                mem[2 + enderecoDeCarga] = 4;
                mem[3 + enderecoDeCarga] = 44;
                mem[4 + enderecoDeCarga] = 23;
                mem[5 + enderecoDeCarga] = 3;
                mem[6 + enderecoDeCarga] = 44;
                mem[7 + enderecoDeCarga] = 1;
                mem[8 + enderecoDeCarga] = 10;
                mem[9 + enderecoDeCarga] = 0;
                mem[10 + enderecoDeCarga] = 19;
                mem[11 + enderecoDeCarga] = 10;
                mem[12 + enderecoDeCarga] = 1;
                mem[13 + enderecoDeCarga] = 19;
                mem[14 + enderecoDeCarga] = 10;
                mem[15 + enderecoDeCarga] = 2;
                mem[16 + enderecoDeCarga] = 6;
                mem[17 + enderecoDeCarga] = 0;
                mem[18 + enderecoDeCarga] = 4;
                mem[19 + enderecoDeCarga] = 6;
                mem[20 + enderecoDeCarga] = 1;
                mem[21 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 22;
                break;
            case 7:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 44;
                mem[2 + enderecoDeCarga] = 1024;
                mem[3 + enderecoDeCarga] = 48;
                mem[4 + enderecoDeCarga] = 27;
                mem[5 + enderecoDeCarga] = 6;
                mem[6 + enderecoDeCarga] = 27;
                mem[7 + enderecoDeCarga] = 30;
                mem[8 + enderecoDeCarga] = 30;
                mem[9 + enderecoDeCarga] = 40;
                mem[30 + enderecoDeCarga] = 31;
                mem[31 + enderecoDeCarga] = 5;
                mem[32 + enderecoDeCarga] = 1024;
                mem[33 + enderecoDeCarga] = 3;
                mem[34 + enderecoDeCarga] = 30;
                mem[35 + enderecoDeCarga] = 38;
                mem[36 + enderecoDeCarga] = 28;
                quantidadeInstrucoes = 18;
                break;
            case 8:// ex 1.1 e 2.1
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 19;
                mem[2 + enderecoDeCarga] = 19;
                mem[3 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 4;
                break;
            case 9:// ex 1.2
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 44;
                mem[2 + enderecoDeCarga] = 3;
                mem[3 + enderecoDeCarga] = 19;
                mem[4 + enderecoDeCarga] = 9;
                mem[5 + enderecoDeCarga] = 2;
                mem[6 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 7;
                break;
            case 10:// ex 1.3
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 3;
                mem[2 + enderecoDeCarga] = 29;
                mem[3 + enderecoDeCarga] = 20;
                mem[4 + enderecoDeCarga] = 20;
                mem[5 + enderecoDeCarga] = 22;
                mem[6 + enderecoDeCarga] = 25;
                mem[7 + enderecoDeCarga] = 10;
                mem[8 + enderecoDeCarga] = 26;
                mem[9 + enderecoDeCarga] = 3;
                mem[10 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 11;
                break;
            case 11:// ex 1.4
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 19;
                mem[2 + enderecoDeCarga] = 19;
                mem[3 + enderecoDeCarga] = 9;
                mem[4 + enderecoDeCarga] = 12;
                // mem[4 + enderecoDeCarga] = 15;
                mem[5 + enderecoDeCarga] = 19;
                mem[6 + enderecoDeCarga] = 19;
                mem[7 + enderecoDeCarga] = 3;
                mem[8 + enderecoDeCarga] = 5;
                mem[9 + enderecoDeCarga] = 12;
                // mem[9 + enderecoDeCarga] = 15;
                mem[10 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 11;
                break;
            case 12:// ex 1.5
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 44;
                mem[2 + enderecoDeCarga] = 50;
                mem[3 + enderecoDeCarga] = 48;
                mem[4 + enderecoDeCarga] = 0;
                mem[5 + enderecoDeCarga] = 19;
                mem[6 + enderecoDeCarga] = 31;
                mem[7 + enderecoDeCarga] = 37;
                mem[8 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 9;
                break;
            case 13:// ex 1.6
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 3;
                mem[2 + enderecoDeCarga] = 4;
                mem[3 + enderecoDeCarga] = 44;
                mem[4 + enderecoDeCarga] = 30;
                mem[5 + enderecoDeCarga] = 3;
                mem[6 + enderecoDeCarga] = 44;
                mem[7 + enderecoDeCarga] = 1;
                mem[8 + enderecoDeCarga] = 10;
                mem[9 + enderecoDeCarga] = 0;
                mem[10 + enderecoDeCarga] = 19;
                mem[11 + enderecoDeCarga] = 10;
                mem[12 + enderecoDeCarga] = 1;
                mem[13 + enderecoDeCarga] = 19;
                mem[14 + enderecoDeCarga] = 10;
                mem[15 + enderecoDeCarga] = 2;
                mem[16 + enderecoDeCarga] = 6;
                mem[17 + enderecoDeCarga] = 0;
                mem[18 + enderecoDeCarga] = 4;
                mem[19 + enderecoDeCarga] = 6;
                mem[20 + enderecoDeCarga] = 1;
                mem[21 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 22;
                break;
            case 14:// ex 2.3
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 44;
                mem[2 + enderecoDeCarga] = 4;
                mem[3 + enderecoDeCarga] = 25;
                mem[4 + enderecoDeCarga] = 8;
                mem[5 + enderecoDeCarga] = 22;
                mem[6 + enderecoDeCarga] = 26;
                mem[7 + enderecoDeCarga] = 3;
                mem[8 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 9;
                break;
            case 15:// ex 2.4
                mem[0 + enderecoDeCarga] = 26;
                mem[1 + enderecoDeCarga] = 16;
                mem[10 + enderecoDeCarga] = 0;
                mem[11 + enderecoDeCarga] = 9;
                mem[12 + enderecoDeCarga] = 2;
                mem[13 + enderecoDeCarga] = 9;
                mem[14 + enderecoDeCarga] = 3;
                mem[15 + enderecoDeCarga] = 28;
                mem[16 + enderecoDeCarga] = 0;
                mem[17 + enderecoDeCarga] = 44;
                mem[18 + enderecoDeCarga] = 9;
                mem[19 + enderecoDeCarga] = 48;
                mem[20 + enderecoDeCarga] = 27;
                mem[21 + enderecoDeCarga] = 10;
                mem[22 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 16;
                break;
            case 16:// ex 2.6
                mem[0 + enderecoDeCarga] = 26;
                mem[1 + enderecoDeCarga] = 16;
                mem[10 + enderecoDeCarga] = 19;
                mem[11 + enderecoDeCarga] = 9;
                mem[12 + enderecoDeCarga] = 2;
                mem[13 + enderecoDeCarga] = 9;
                mem[14 + enderecoDeCarga] = 3;
                mem[15 + enderecoDeCarga] = 28;
                mem[16 + enderecoDeCarga] = 0;
                mem[17 + enderecoDeCarga] = 44;
                mem[18 + enderecoDeCarga] = 9;
                mem[19 + enderecoDeCarga] = 48;
                mem[20 + enderecoDeCarga] = 27;
                mem[21 + enderecoDeCarga] = 10;
                mem[22 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 16;
                break;

            case 17: // ex3.1
                mem[0 + enderecoDeCarga] = 26;
                mem[1 + enderecoDeCarga] = 20;
                mem[20 + enderecoDeCarga] = 0;
                mem[21 + enderecoDeCarga] = 44;
                mem[22 + enderecoDeCarga] = 14;
                mem[23 + enderecoDeCarga] = 48;
                mem[24 + enderecoDeCarga] = 9;
                mem[25 + enderecoDeCarga] = 3;
                mem[26 + enderecoDeCarga] = 27;
                mem[27 + enderecoDeCarga] = 50;
                mem[28 + enderecoDeCarga] = 1;
                mem[29 + enderecoDeCarga] = 9;
                mem[30 + enderecoDeCarga] = 4;
                mem[31 + enderecoDeCarga] = 2;
                mem[32 + enderecoDeCarga] = 9;
                mem[33 + enderecoDeCarga] = 5;
                mem[34 + enderecoDeCarga] = 40;
                // até aqui é igual
                mem[50 + enderecoDeCarga] = 0;
                mem[51 + enderecoDeCarga] = 44;
                mem[52 + enderecoDeCarga] = 3;
                mem[53 + enderecoDeCarga] = 31;
                mem[54 + enderecoDeCarga] = 22;
                mem[55 + enderecoDeCarga] = 31;
                mem[56 + enderecoDeCarga] = 37;
                mem[57 + enderecoDeCarga] = 36;
                mem[58 + enderecoDeCarga] = 28;
                quantidadeInstrucoes = 27;
                break;
            case 18: // ex3.2
                mem[0 + enderecoDeCarga] = 26;
                mem[1 + enderecoDeCarga] = 20;
                mem[20 + enderecoDeCarga] = 0;
                mem[21 + enderecoDeCarga] = 44;
                mem[22 + enderecoDeCarga] = 14;
                mem[23 + enderecoDeCarga] = 48;
                mem[24 + enderecoDeCarga] = 9;
                mem[25 + enderecoDeCarga] = 3;
                mem[26 + enderecoDeCarga] = 27;
                mem[27 + enderecoDeCarga] = 50;
                mem[28 + enderecoDeCarga] = 1;
                mem[29 + enderecoDeCarga] = 9;
                mem[30 + enderecoDeCarga] = 4;
                mem[31 + enderecoDeCarga] = 2;
                mem[32 + enderecoDeCarga] = 9;
                mem[33 + enderecoDeCarga] = 5;
                mem[34 + enderecoDeCarga] = 40;
                // até aqui é igual
                mem[50 + enderecoDeCarga] = 0;
                mem[51 + enderecoDeCarga] = 44;
                mem[52 + enderecoDeCarga] = 28;
                mem[53 + enderecoDeCarga] = 31;
                mem[54 + enderecoDeCarga] = 44;
                mem[55 + enderecoDeCarga] = 3;
                mem[56 + enderecoDeCarga] = 31;
                mem[57 + enderecoDeCarga] = 22;
                mem[58 + enderecoDeCarga] = 31;
                mem[59 + enderecoDeCarga] = 37;
                mem[60 + enderecoDeCarga] = 36;
                mem[61 + enderecoDeCarga] = 28;
                quantidadeInstrucoes = 30;
                break;
            case 19: // ex3.3
                mem[0 + enderecoDeCarga] = 26;
                mem[1 + enderecoDeCarga] = 20;
                mem[20 + enderecoDeCarga] = 0;
                mem[21 + enderecoDeCarga] = 44;
                mem[22 + enderecoDeCarga] = 14;
                mem[23 + enderecoDeCarga] = 48;
                mem[24 + enderecoDeCarga] = 9;
                mem[25 + enderecoDeCarga] = 3;
                mem[26 + enderecoDeCarga] = 27;
                mem[27 + enderecoDeCarga] = 50;
                mem[28 + enderecoDeCarga] = 1;
                mem[29 + enderecoDeCarga] = 9;
                mem[30 + enderecoDeCarga] = 4;
                mem[31 + enderecoDeCarga] = 2;
                mem[32 + enderecoDeCarga] = 9;
                mem[33 + enderecoDeCarga] = 5;
                mem[34 + enderecoDeCarga] = 27;
                mem[35 + enderecoDeCarga] = 10;
                mem[36 + enderecoDeCarga] = 27;
                mem[37 + enderecoDeCarga] = 10;
                mem[38 + enderecoDeCarga] = 40;
                // até aqui é igual
                mem[50 + enderecoDeCarga] = 0;
                mem[51 + enderecoDeCarga] = 44;
                mem[52 + enderecoDeCarga] = 28;
                mem[53 + enderecoDeCarga] = 31;
                mem[54 + enderecoDeCarga] = 44;
                mem[55 + enderecoDeCarga] = 3;
                mem[56 + enderecoDeCarga] = 31;
                mem[57 + enderecoDeCarga] = 22;
                mem[58 + enderecoDeCarga] = 31;
                mem[59 + enderecoDeCarga] = 37;
                mem[60 + enderecoDeCarga] = 36;
                mem[61 + enderecoDeCarga] = 28;
                quantidadeInstrucoes = 34;
                break;
            case 20:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 44;
                mem[2 + enderecoDeCarga] = 255;
                mem[3 + enderecoDeCarga] = 48;
                mem[4 + enderecoDeCarga] = 27;
                mem[5 + enderecoDeCarga] = 10;
                mem[6 + enderecoDeCarga] = 27;
                mem[7 + enderecoDeCarga] = 10;
                mem[8 + enderecoDeCarga] = 30;
                mem[9 + enderecoDeCarga] = 40;
                mem[10 + enderecoDeCarga] = 31;
                mem[11 + enderecoDeCarga] = 5;
                mem[12 + enderecoDeCarga] = 255;
                mem[13 + enderecoDeCarga] = 3;
                mem[14 + enderecoDeCarga] = 30;
                mem[15 + enderecoDeCarga] = 38;
                mem[16 + enderecoDeCarga] = 28;
                quantidadeInstrucoes = 18;
                break;
            case 21:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 39;
                mem[2 + enderecoDeCarga] = 39;
                mem[3 + enderecoDeCarga] = 39;
                mem[4 + enderecoDeCarga] = 39;
                mem[5 + enderecoDeCarga] = 39;
                mem[6 + enderecoDeCarga] = 39;
                mem[7 + enderecoDeCarga] = 39;
                mem[8 + enderecoDeCarga] = 44;
                mem[9 + enderecoDeCarga] = 31;
                mem[10 + enderecoDeCarga] = 9;
                mem[11 + enderecoDeCarga] = 1;
                mem[12 + enderecoDeCarga] = 44;
                mem[13 + enderecoDeCarga] = 27;
                mem[14 + enderecoDeCarga] = 9;
                mem[15 + enderecoDeCarga] = 2;
                mem[16 + enderecoDeCarga] = 44;
                mem[17 + enderecoDeCarga] = 255;
                mem[18 + enderecoDeCarga] = 48;
                mem[19 + enderecoDeCarga] = 30;
                mem[20 + enderecoDeCarga] = 52;
                mem[21 + enderecoDeCarga] = 1;
                mem[22 + enderecoDeCarga] = 30;
                mem[23 + enderecoDeCarga] = 52;
                mem[24 + enderecoDeCarga] = 2;
                mem[25 + enderecoDeCarga] = 30;
                mem[26 + enderecoDeCarga] = 40;
                mem[27 + enderecoDeCarga] = 0;
                mem[28 + enderecoDeCarga] = 44;
                mem[29 + enderecoDeCarga] = 200;
                mem[30 + enderecoDeCarga] = 30;
                mem[31 + enderecoDeCarga] = 51;
                quantidadeInstrucoes = 33;
                break;
            case 22: // prova 1
                mem[0 + enderecoDeCarga] = 44;
                mem[1 + enderecoDeCarga] = 4;
                mem[2 + enderecoDeCarga] = 3;
                mem[3 + enderecoDeCarga] = 44;
                mem[4 + enderecoDeCarga] = 1;
                mem[5 + enderecoDeCarga] = 19;
                mem[6 + enderecoDeCarga] = 19;
                mem[7 + enderecoDeCarga] = 53;
                mem[8 + enderecoDeCarga] = 1;
                mem[9 + enderecoDeCarga] = 25;
                mem[10 + enderecoDeCarga] = 17;
                mem[11 + enderecoDeCarga] = 44;
                mem[12 + enderecoDeCarga] = 3;
                mem[13 + enderecoDeCarga] = 9;
                mem[14 + enderecoDeCarga] = 1;
                mem[15 + enderecoDeCarga] = 26;
                mem[16 + enderecoDeCarga] = 0;
                mem[17 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 19;
                break;
            case 23: // exercício PIC
                mem[0 + enderecoDeCarga] = 44;
                mem[1 + enderecoDeCarga] = 216;
                mem[2 + enderecoDeCarga] = 9;
                mem[3 + enderecoDeCarga] = 35;
                mem[4 + enderecoDeCarga] = 44;
                mem[5 + enderecoDeCarga] = 226;
                mem[6 + enderecoDeCarga] = 9;
                mem[7 + enderecoDeCarga] = 36;
                mem[8 + enderecoDeCarga] = 44;
                mem[9 + enderecoDeCarga] = 236;
                mem[10 + enderecoDeCarga] = 9;
                mem[11 + enderecoDeCarga] = 37;
                mem[12 + enderecoDeCarga] = 44;
                mem[13 + enderecoDeCarga] = 246;
                mem[14 + enderecoDeCarga] = 9;
                mem[15 + enderecoDeCarga] = 38;
                mem[16 + enderecoDeCarga] = 44;
                mem[17 + enderecoDeCarga] = 200;
                mem[18 + enderecoDeCarga] = 9;
                mem[19 + enderecoDeCarga] = 43;
                mem[20 + enderecoDeCarga] = 44;
                mem[21 + enderecoDeCarga] = 202;
                mem[22 + enderecoDeCarga] = 9;
                mem[23 + enderecoDeCarga] = 45;
                mem[24 + enderecoDeCarga] = 44;
                mem[25 + enderecoDeCarga] = 204;
                mem[26 + enderecoDeCarga] = 9;
                mem[27 + enderecoDeCarga] = 47;
                mem[28 + enderecoDeCarga] = 44;
                mem[29 + enderecoDeCarga] = 135;
                mem[30 + enderecoDeCarga] = 9;
                mem[31 + enderecoDeCarga] = 49;
                mem[32 + enderecoDeCarga] = 26;
                mem[33 + enderecoDeCarga] = 50;
                mem[34 + enderecoDeCarga] = 0;
                mem[35 + enderecoDeCarga] = 44;
                mem[36 + enderecoDeCarga] = 200;
                mem[37 + enderecoDeCarga] = 9;
                mem[38 + enderecoDeCarga] = 0;
                mem[39 + enderecoDeCarga] = 44;
                mem[40 + enderecoDeCarga] = 202;
                mem[41 + enderecoDeCarga] = 9;
                mem[42 + enderecoDeCarga] = 1;
                mem[43 + enderecoDeCarga] = 44;
                mem[44 + enderecoDeCarga] = 204;
                mem[45 + enderecoDeCarga] = 9;
                mem[46 + enderecoDeCarga] = 2;
                mem[47 + enderecoDeCarga] = 44;
                mem[48 + enderecoDeCarga] = 150;
                mem[49 + enderecoDeCarga] = 9;
                mem[50 + enderecoDeCarga] = 3;
                mem[51 + enderecoDeCarga] = 5;
                mem[52 + enderecoDeCarga] = 38;
                mem[53 + enderecoDeCarga] = 48;
                mem[54 + enderecoDeCarga] = 5;
                mem[55 + enderecoDeCarga] = 35;
                mem[56 + enderecoDeCarga] = 48;
                mem[57 + enderecoDeCarga] = 11;
                mem[58 + enderecoDeCarga] = 5;
                mem[59 + enderecoDeCarga] = 0;
                mem[60 + enderecoDeCarga] = 31;
                mem[61 + enderecoDeCarga] = 0;
                mem[62 + enderecoDeCarga] = 31;
                mem[63 + enderecoDeCarga] = 31;
                mem[64 + enderecoDeCarga] = 32;
                mem[65 + enderecoDeCarga] = 33;
                mem[66 + enderecoDeCarga] = 47;
                mem[67 + enderecoDeCarga] = 9;
                mem[68 + enderecoDeCarga] = 35;
                mem[69 + enderecoDeCarga] = 5;
                mem[70 + enderecoDeCarga] = 36;
                mem[71 + enderecoDeCarga] = 48;
                mem[72 + enderecoDeCarga] = 11;
                mem[73 + enderecoDeCarga] = 5;
                mem[74 + enderecoDeCarga] = 1;
                mem[75 + enderecoDeCarga] = 31;
                mem[76 + enderecoDeCarga] = 0;
                mem[77 + enderecoDeCarga] = 31;
                mem[78 + enderecoDeCarga] = 31;
                mem[79 + enderecoDeCarga] = 32;
                mem[80 + enderecoDeCarga] = 33;
                mem[81 + enderecoDeCarga] = 47;
                mem[82 + enderecoDeCarga] = 9;
                mem[83 + enderecoDeCarga] = 36;
                mem[84 + enderecoDeCarga] = 5;
                mem[85 + enderecoDeCarga] = 37;
                mem[86 + enderecoDeCarga] = 48;
                mem[87 + enderecoDeCarga] = 11;
                mem[88 + enderecoDeCarga] = 5;
                mem[89 + enderecoDeCarga] = 2;
                mem[90 + enderecoDeCarga] = 31;
                mem[91 + enderecoDeCarga] = 0;
                mem[92 + enderecoDeCarga] = 31;
                mem[93 + enderecoDeCarga] = 31;
                mem[94 + enderecoDeCarga] = 32;
                mem[95 + enderecoDeCarga] = 33;
                mem[96 + enderecoDeCarga] = 47;
                mem[97 + enderecoDeCarga] = 9;
                mem[98 + enderecoDeCarga] = 37;
                mem[99 + enderecoDeCarga] = 5;
                mem[100 + enderecoDeCarga] = 38;
                mem[101 + enderecoDeCarga] = 48;
                mem[102 + enderecoDeCarga] = 0;
                mem[103 + enderecoDeCarga] = 9;
                mem[104 + enderecoDeCarga] = 39;
                mem[105 + enderecoDeCarga] = 52;
                mem[106 + enderecoDeCarga] = 5;
                mem[107 + enderecoDeCarga] = 52;
                mem[108 + enderecoDeCarga] = 6;
                mem[109 + enderecoDeCarga] = 52;
                mem[110 + enderecoDeCarga] = 7;
                mem[111 + enderecoDeCarga] = 52;
                mem[112 + enderecoDeCarga] = 3;
                mem[113 + enderecoDeCarga] = 40;
                mem[114 + enderecoDeCarga] = 5;
                mem[115 + enderecoDeCarga] = 39;
                mem[116 + enderecoDeCarga] = 3;
                mem[117 + enderecoDeCarga] = 44;
                mem[118 + enderecoDeCarga] = 0;
                mem[119 + enderecoDeCarga] = 45;
                mem[120 + enderecoDeCarga] = 159;
                mem[121 + enderecoDeCarga] = 26;
                mem[122 + enderecoDeCarga] = 168;
                mem[123 + enderecoDeCarga] = 4;
                mem[124 + enderecoDeCarga] = 5;
                mem[125 + enderecoDeCarga] = 36;
                mem[126 + enderecoDeCarga] = 48;
                mem[127 + enderecoDeCarga] = 36;
                mem[128 + enderecoDeCarga] = 21;
                mem[129 + enderecoDeCarga] = 2;
                mem[130 + enderecoDeCarga] = 9;
                mem[131 + enderecoDeCarga] = 39;
                mem[132 + enderecoDeCarga] = 51;
                mem[133 + enderecoDeCarga] = 44;
                mem[134 + enderecoDeCarga] = 1;
                mem[135 + enderecoDeCarga] = 45;
                mem[136 + enderecoDeCarga] = 176;
                mem[137 + enderecoDeCarga] = 26;
                mem[138 + enderecoDeCarga] = 186;
                mem[139 + enderecoDeCarga] = 2;
                mem[140 + enderecoDeCarga] = 5;
                mem[141 + enderecoDeCarga] = 37;
                mem[142 + enderecoDeCarga] = 48;
                mem[143 + enderecoDeCarga] = 21;
                mem[144 + enderecoDeCarga] = 2;
                mem[145 + enderecoDeCarga] = 9;
                mem[146 + enderecoDeCarga] = 39;
                mem[147 + enderecoDeCarga] = 51;
                mem[148 + enderecoDeCarga] = 5;
                mem[149 + enderecoDeCarga] = 35;
                mem[150 + enderecoDeCarga] = 48;
                mem[151 + enderecoDeCarga] = 0;
                mem[152 + enderecoDeCarga] = 9;
                mem[153 + enderecoDeCarga] = 39;
                mem[154 + enderecoDeCarga] = 51;
                mem[155 + enderecoDeCarga] = 26;
                mem[156 + enderecoDeCarga] = 200;
                mem[157 + enderecoDeCarga] = 26;
                mem[158 + enderecoDeCarga] = 202;
                mem[159 + enderecoDeCarga] = 26;
                mem[160 + enderecoDeCarga] = 204;
                quantidadeInstrucoes = 162;
                break;
            case 24: // Nucleo de SO
                mem[0 + enderecoDeCarga] = 26;
                mem[1 + enderecoDeCarga] = 10;
                mem[2 + enderecoDeCarga] = 204;
                mem[3 + enderecoDeCarga] = 219;
                mem[4 + enderecoDeCarga] = 234;
                mem[5 + enderecoDeCarga] = 249;
                mem[10 + enderecoDeCarga] = 44;
                mem[11 + enderecoDeCarga] = 19;
                mem[12 + enderecoDeCarga] = 9;
                mem[13 + enderecoDeCarga] = 0;
                mem[14 + enderecoDeCarga] = 5;
                mem[15 + enderecoDeCarga] = 5;
                mem[16 + enderecoDeCarga] = 48;
                mem[17 + enderecoDeCarga] = 39;
                mem[18 + enderecoDeCarga] = 51;
                mem[19 + enderecoDeCarga] = 0;
                mem[20 + enderecoDeCarga] = 4;
                mem[21 + enderecoDeCarga] = 5;
                mem[22 + enderecoDeCarga] = 6;
                mem[23 + enderecoDeCarga] = 3;
                mem[24 + enderecoDeCarga] = 44;
                mem[25 + enderecoDeCarga] = 0;
                mem[26 + enderecoDeCarga] = 45;
                mem[27 + enderecoDeCarga] = 30;
                mem[28 + enderecoDeCarga] = 26;
                mem[29 + enderecoDeCarga] = 39;
                mem[30 + enderecoDeCarga] = 4;
                mem[31 + enderecoDeCarga] = 5;
                mem[32 + enderecoDeCarga] = 2;
                mem[33 + enderecoDeCarga] = 48;
                mem[34 + enderecoDeCarga] = 21;
                mem[35 + enderecoDeCarga] = 2;
                mem[36 + enderecoDeCarga] = 9;
                mem[37 + enderecoDeCarga] = 6;
                mem[38 + enderecoDeCarga] = 51;
                mem[39 + enderecoDeCarga] = 44;
                mem[40 + enderecoDeCarga] = 1;
                mem[41 + enderecoDeCarga] = 45;
                mem[42 + enderecoDeCarga] = 45;
                mem[43 + enderecoDeCarga] = 26;
                mem[44 + enderecoDeCarga] = 54;
                mem[45 + enderecoDeCarga] = 4;
                mem[46 + enderecoDeCarga] = 5;
                mem[47 + enderecoDeCarga] = 3;
                mem[48 + enderecoDeCarga] = 48;
                mem[49 + enderecoDeCarga] = 21;
                mem[50 + enderecoDeCarga] = 2;
                mem[51 + enderecoDeCarga] = 9;
                mem[52 + enderecoDeCarga] = 6;
                mem[53 + enderecoDeCarga] = 51;
                mem[54 + enderecoDeCarga] = 0;
                mem[55 + enderecoDeCarga] = 9;
                mem[56 + enderecoDeCarga] = 6;
                mem[57 + enderecoDeCarga] = 5;
                mem[58 + enderecoDeCarga] = 4;
                mem[59 + enderecoDeCarga] = 48;
                mem[60 + enderecoDeCarga] = 51;
                mem[70 + enderecoDeCarga] = 26;
                mem[71 + enderecoDeCarga] = 70;
                mem[74 + enderecoDeCarga] = 26;
                mem[75 + enderecoDeCarga] = 74;
                mem[78 + enderecoDeCarga] = 26;
                mem[79 + enderecoDeCarga] = 78;
                mem[209 + enderecoDeCarga] = 70;
                mem[224 + enderecoDeCarga] = 74;
                mem[239 + enderecoDeCarga] = 78;
                mem[254 + enderecoDeCarga] = 19;
                quantidadeInstrucoes = 68;
                break;
            case 25:
                mem[0 + enderecoDeCarga] = 26;
                mem[1 + enderecoDeCarga] = 2;
                mem[2 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 3;
                break;
            case 26:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 3;
                mem[2 + enderecoDeCarga] = 29;
                mem[3 + enderecoDeCarga] = 20;
                mem[4 + enderecoDeCarga] = 20;
                mem[5 + enderecoDeCarga] = 22;
                mem[6 + enderecoDeCarga] = 25;
                mem[7 + enderecoDeCarga] = 10;
                mem[8 + enderecoDeCarga] = 26;
                mem[9 + enderecoDeCarga] = 3;
                mem[10 + enderecoDeCarga] = 20;
                mem[11 + enderecoDeCarga] = 20;
                mem[12 + enderecoDeCarga] = 22;
                mem[13 + enderecoDeCarga] = 25;
                mem[14 + enderecoDeCarga] = 10;
                mem[15 + enderecoDeCarga] = 26;
                mem[16 + enderecoDeCarga] = 3;
                mem[17 + enderecoDeCarga] = 20;
                mem[18 + enderecoDeCarga] = 20;
                mem[19 + enderecoDeCarga] = 22;
                mem[20 + enderecoDeCarga] = 25;
                mem[21 + enderecoDeCarga] = 10;
                mem[22 + enderecoDeCarga] = 40;
                quantidadeInstrucoes = 24;
                break;
            case 27:
                mem[0 + enderecoDeCarga] = 0;
                mem[1 + enderecoDeCarga] = 44;
                mem[2 + enderecoDeCarga] = 255;
                mem[3 + enderecoDeCarga] = 48;
                mem[4 + enderecoDeCarga] = 27;
                mem[5 + enderecoDeCarga] = 30;
                mem[6 + enderecoDeCarga] = 30;
                mem[7 + enderecoDeCarga] = 27;
                mem[8 + enderecoDeCarga] = 60;
                mem[9 + enderecoDeCarga] = 30;
                mem[10 + enderecoDeCarga] = 40;

                mem[30 + enderecoDeCarga] = 31;
                mem[31 + enderecoDeCarga] = 44;
                mem[32 + enderecoDeCarga] = 30;
                mem[33 + enderecoDeCarga] = 9;
                mem[34 + enderecoDeCarga] = 8;
                mem[35 + enderecoDeCarga] = 30;
                mem[36 + enderecoDeCarga] = 38;
                mem[37 + enderecoDeCarga] = 28;

                mem[60 + enderecoDeCarga] = 31;
                mem[61 + enderecoDeCarga] = 5;
                mem[62 + enderecoDeCarga] = 255;
                mem[63 + enderecoDeCarga] = 3;
                mem[64 + enderecoDeCarga] = 30;
                mem[65 + enderecoDeCarga] = 38;
                mem[66 + enderecoDeCarga] = 28;
                quantidadeInstrucoes = 27;
                break;
            default:
                programa = 0;
                break;
        }
        MVM.tradutor(mem, quantidadeInstrucoes, enderecoDeCarga, programa);
        MVM.decodificador(mem, programa, enderecoDeCarga);
    }

}
