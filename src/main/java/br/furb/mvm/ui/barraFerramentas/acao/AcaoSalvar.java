package br.furb.mvm.ui.barraFerramentas.acao;

import java.io.FileWriter;
import java.io.IOException;

public class AcaoSalvar {

    public static void salvar(String absolutePath, String buffer) throws IOException {
        FileWriter fw = new FileWriter(absolutePath, false);
        fw.write(buffer);
        fw.flush();
        fw.close();
    }
}
