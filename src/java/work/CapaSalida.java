package work;

import java.util.ArrayList;
import java.util.Arrays;

public class CapaSalida extends Capa {

	public CapaSalida initCapa(CapaSalida capaSalida) {
		ArrayList<Double> listaDePesosSalidaTemp = new ArrayList<Double>();
		ArrayList<Neurona> listaDeNeuronas = new ArrayList<Neurona>();

		for (int i = 0; i < capaSalida.getNumeroDeNeuronasEnCapa(); i++) {
			Neurona neurona = new Neurona();
			
			listaDePesosSalidaTemp.add(neurona.initNeurona());

			neurona.setListaPesosSalida(listaDePesosSalidaTemp);
			listaDeNeuronas.add(neurona);

			listaDePesosSalidaTemp = new ArrayList<Double>();
		}

		capaSalida.setListaDeNeuronas(listaDeNeuronas);
		
		return capaSalida; 
		
	}
	
	public void printCapa(CapaSalida outputLayer){
		System.out.println("### Capas de Salida ###");
		int n = 1;
		for (Neurona neuron : outputLayer.getListaDeNeuronas()) {
			System.out.println("Neurona #" + n + ":");
			System.out.println("Pesos de Salida:");
			System.out.println(Arrays.deepToString( neuron.getListaPesosSalida().toArray() ));
			n++;
		}
	}

}
