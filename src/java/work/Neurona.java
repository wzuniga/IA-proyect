package work;

import java.util.ArrayList;
import java.util.Random;

public class Neurona {

	private ArrayList<Double> listaPesosEntrada;
	private ArrayList<Double> listaPesosSalida;
	
	public double initNeurona(){
		Random r = new Random();
		return r.nextDouble();
	}

	public ArrayList<Double> getListaPesosEntrada() {
		return listaPesosEntrada;
	}

	public void setListaPesosEntrada(ArrayList<Double> listaPesosEntrada) {
		this.listaPesosEntrada = listaPesosEntrada;
	}

	public ArrayList<Double> getListaPesosSalida() {
		return listaPesosSalida;
	}

	public void setListaPesosSalida(ArrayList<Double> listaPesosSalida) {
		this.listaPesosSalida = listaPesosSalida;
	}
	
}
