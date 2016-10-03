package br.com.andreluizlunelli.mvm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author
 */
public class SalvarPrograma {

    private static File program = new File("c:/Temp/program.txt");
    private static String aux;
    private static short aux2;
    private static String tabelaRealocacao;

    public static File getProgram() {
        return program;
    }

    public static void setProgram(File program) {
        SalvarPrograma.program = program;
    }

    public static String getAux() {
        return aux;
    }

    public static void setAux(String aux) {
        SalvarPrograma.aux = aux;
    }

    public static short getAux2() {
        return aux2;
    }

    public static void setAux2(short aux2) {
        SalvarPrograma.aux2 = aux2;
    }

    public static String getTabelaRealocacao() {
        return tabelaRealocacao;
    }

    public static void setTabelaRealocacao(String tabelaRealocacao) {
        SalvarPrograma.tabelaRealocacao = tabelaRealocacao;
    }

    public static void salvar(int inicio, int fim, short mem[]) throws IOException {
        if (getProgram() == null) {
            setProgram(new File("c:/Temp/program.txt"));
        }
        FileWriter fw = new FileWriter(getProgram(), false);
        BufferedWriter bw = new BufferedWriter(fw);
        int start = inicio;
        int next = inicio;
        tabelaRealocacao = "";
        while (next <= fim) {
            setAux2(mem[next]);
            //Instrução de 2 bytes com posição de memória
            if (getAux2() == 5 || getAux2() == 6 || getAux2() == 7 || getAux2() == 8 || getAux2() == 9 || getAux2() == 10 || getAux2() == 25 || getAux2() == 26 || getAux2() == 27 || getAux2() == 42 || getAux2() == 43 || getAux2() == 44 || getAux2() == 45 || getAux2() == 52) {
                bw.write(getAux2() + "\n");
                next++;
                bw.write(mem[next] + "\n");
                tabelaRealocacao += (next - start) + "\n";
            } else {
                //instruções de 2 bytes com chaves
                if (getAux2() == 44) {
                    bw.write(getAux2() + "\n");
                    next++;
                    bw.write(mem[next] + "\n");
                } else {
                    //Instrução de 1 byte
                    bw.write(getAux2() + "\n");
                }
            }
            next++;
        }
        //Adiciona a tabela de realocação ao final do programa separado por "|"
        bw.write("|\n" + tabelaRealocacao);
        bw.close();
        fw.close();

    }

    public static void ler(short mem[], int posicao) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(getProgram());
        BufferedReader br = new BufferedReader(fr);
        int posicaoIni = posicao;
        boolean terminouPrograma = false;
        while (br.ready()) {
            aux = br.readLine();
            if (aux.equals("")) {} else {
                if (aux.equals("|")) {
                    terminouPrograma = true;
                } else {
                    if (!terminouPrograma) {
                        mem[posicao] = Short.parseShort(aux);
                        posicao++;
                    } else {
                        mem[Integer.parseInt(aux) + posicaoIni] += posicaoIni;
                    }

                }
            }
        }
        br.close();
        fr.close();
    }
}
