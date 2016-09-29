package br.com.andreluizlunelli.mvm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Arquivo {

	public static void escreve(File file, String string) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(string);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String le(File file) {
		String _return = null;
		try {
			_return = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return _return;
	}

	public static void exclui(File file) {
		if (file.exists()) {
			file.delete();
		}
	}

}
