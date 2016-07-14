package work;

import java.util.ArrayList;
import java.util.Arrays;

public class CapaOculta extends Capa {

	public ArrayList<CapaOculta> initCapa(CapaOculta capaOculta, ArrayList<CapaOculta> listaDeCapasOcultas, CapaEntrada capaEntrada, CapaSalida capaSalida) {

		ArrayList<Double> listaDePesosEntrada = new ArrayList<Double>();
		ArrayList<Double> listaDePesosSalida = new ArrayList<Double>();
		ArrayList<Neurona> listaDeNeuronas = new ArrayList<Neurona>();

		int numeroDeCapasOcultas = listaDeCapasOcultas.size();

		for (int i = 0; i < numeroDeCapasOcultas; i++) {
			for (int j = 0; j < capaOculta.getNumeroDeNeuronasEnCapa(); j++) {
				Neurona neurona = new Neurona();

				int limitIn;
				int limitOut;

				if (i == 0) { // first
					limitIn = capaEntrada.getNumeroDeNeuronasEnCapa();
					if (numeroDeCapasOcultas > 1) {
						limitOut = listaDeCapasOcultas.get(i + 1).getNumeroDeNeuronasEnCapa();
					} else {
						limitOut = listaDeCapasOcultas.get(i).getNumeroDeNeuronasEnCapa();
					}
				} else if (i == numeroDeCapasOcultas - 1) { // last
					limitIn = listaDeCapasOcultas.get(i - 1).getNumeroDeNeuronasEnCapa();
					limitOut = capaSalida.getNumeroDeNeuronasEnCapa();
				} else { // middle
					limitIn = listaDeCapasOcultas.get(i - 1).getNumeroDeNeuronasEnCapa();
					limitOut = listaDeCapasOcultas.get(i + 1).getNumeroDeNeuronasEnCapa();
				}

				for (int k = 0; k < limitIn; k++) {
					listaDePesosEntrada.add(neurona.initNeurona());
				}
				for (int k = 0; k < limitOut; k++) {
					listaDePesosSalida.add(neurona.initNeurona());
				}

				neurona.setListaPesosEntrada(listaDePesosEntrada);
				neurona.setListaPesosSalida(listaDePesosSalida);
				listaDeNeuronas.add(neurona);

				listaDePesosEntrada = new ArrayList<Double>();
				listaDePesosSalida = new ArrayList<Double>();

			}

			listaDeCapasOcultas.get(i).setListaDeNeuronas(listaDeNeuronas);

			listaDeNeuronas = new ArrayList<Neurona>();

		}

		return listaDeCapasOcultas;

	}

	public void printCapa(ArrayList<CapaOculta> listOfHiddenLayer) {
		System.out.println("### CAPAS OCULTAS ###");
		int h = 1;
		for (CapaOculta hiddenLayer : listOfHiddenLayer) {
			System.out.println("Capa Oculta #" + h);
			int n = 1;
			for (Neurona neuron : hiddenLayer.getListaDeNeuronas()) {
				System.out.println("Neurona #" + n);
				System.out.println("Pesos de Entrada:");
				System.out.println(Arrays.deepToString( neuron.getListaPesosEntrada().toArray() ));
				System.out.println("Pesos de Salida:");
				System.out.println(Arrays.deepToString( neuron.getListaPesosSalida().toArray() ));
				n++;
			}
			h++;
		}
	}
}
