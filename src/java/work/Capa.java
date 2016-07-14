package work;

import java.util.ArrayList;

public abstract class Capa {

	private ArrayList<Neurona> listaDeNeuronas;
	private int numeroDeNeuronasEnCapa;
	
	public void printCapa(){
	}

	public ArrayList<Neurona> getListaDeNeuronas() {
		return listaDeNeuronas;
	}

	public void setListaDeNeuronas(ArrayList<Neurona> listaDeNeuronas) {
		this.listaDeNeuronas = listaDeNeuronas;
	}

	public int getNumeroDeNeuronasEnCapa() {
		return numeroDeNeuronasEnCapa;
	}

	public void setNumeroDeNeuronasEnCapa(int numeroDeNeuronasEnCapa) {
		this.numeroDeNeuronasEnCapa = numeroDeNeuronasEnCapa;
	}
	
}
