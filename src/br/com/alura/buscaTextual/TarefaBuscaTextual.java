package br.com.alura.buscaTextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;

	public TarefaBuscaTextual(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nome;
	}

	@Override
	public void run() {
		try {
			Scanner input = new Scanner(new File(nomeArquivo));
			
			int numeroLinha = 1;
			
			while(input.hasNextLine()) {
				String linha = input.nextLine();
				
				if(linha.contains(nome)) {
					System.out.println(nomeArquivo + " - " + numeroLinha + " - " + linha);
				}
				numeroLinha++;
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
