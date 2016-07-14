package work;

import java.util.ArrayList;
import java.util.Arrays;

public class CapaEntrada extends Capa {

	public CapaEntrada initCapa(CapaEntrada capaDeEntrada) {
		
		ArrayList<Double> listaDePesosEnTemp = new ArrayList<Double>();
		ArrayList<Neurona> listaDeNeuronas = new ArrayList<Neurona>();
		
		for (int i = 0; i < capaDeEntrada.getNumeroDeNeuronasEnCapa(); i++) {
			Neurona neurona = new Neurona();
			
			listaDePesosEnTemp.add(neurona.initNeurona() );

			neurona.setListaPesosEntrada(listaDePesosEnTemp );
			listaDeNeuronas.add(neurona );

			listaDePesosEnTemp = new ArrayList<Double>();
		}

		capaDeEntrada.setListaDeNeuronas(listaDeNeuronas);

		return capaDeEntrada;
	}

	public void printCapa(CapaEntrada capaEntrada){
		System.out.println("### CAPA DE ENTRADA ###");
		int n = 1;
		for (Neurona neuron : capaEntrada.getListaDeNeuronas()) {
			System.out.println("Neurona #" + n + ":");
			System.out.println("Pesos de Entrada:");
			System.out.println(Arrays.deepToString( neuron.getListaPesosEntrada().toArray() ));
			n++;
		}
	}
}
