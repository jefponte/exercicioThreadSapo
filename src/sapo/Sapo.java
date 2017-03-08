package sapo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Sapo {
	
	private String nome;
	private int posicao;
	private String horaChegada;
	
	public Sapo(String nome){
		this.nome = nome;
		this.posicao = 0;
	}
	@Override
	public String toString() {
		return this.nome+" esta na posicao "+this.posicao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public int pular(){
		Random r = new Random();
		int salto = r.nextInt(4);
		this.posicao = this.posicao+salto;
		return salto;
	}
	public void iniciarCorrida(){
		
		Thread correndo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(posicao < 10){
					System.out.println("Sapo: "+nome+" na posicao: "+posicao);
					int pulo = pular();
					System.out.println(nome+": pulei "+pulo+" casas.");
					System.out.println("Sapo: "+nome+" na posicao: "+posicao);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				Date horaAtual = new Date();
				SimpleDateFormat dataNoFrame = new SimpleDateFormat("HH:mm:ss");
				horaChegada = dataNoFrame.format(horaAtual);
				System.out.println(nome+": cheguei. Sao: "+horaChegada);
			}
			
		});
		correndo.start();
	}

}
