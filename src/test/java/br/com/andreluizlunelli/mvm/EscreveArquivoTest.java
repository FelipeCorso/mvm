package br.com.andreluizlunelli.mvm;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class EscreveArquivoTest {
	
	private static final String C_PR_TXT = "C:\\Users\\tolun\\Desktop\\pr.txt";
	private File file = new File(C_PR_TXT);
	
	@After
	@Before
	public void before() {
		Arquivo.exclui(file);
	}
	
	@Test
	public void test01EscreveLeRecupera() {
		Arquivo.escreve(file, "lalala");
		String s = Arquivo.le(file);
		Assert.assertEquals("lalala", s);
	}
	
	@Test
	public void test02ExcluirArquivo() {
		Arquivo.escreve(file, "lalala");
		Arquivo.exclui(file);
		boolean exists = file.exists();
		Assert.assertEquals(false, exists);
	}
}
