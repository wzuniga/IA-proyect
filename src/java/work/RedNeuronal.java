package work;

import java.util.ArrayList;

public class RedNeuronal {

    private CapaEntrada capaEntrada;
    private CapaOculta capaOculta;
    private ArrayList<CapaOculta> listaDeCapasOcultas;
    private CapaSalida capaSalida;
    private int numeroDeCapasOcultas;

    public void initNet() {
        capaEntrada = new CapaEntrada();
        capaEntrada.setNumeroDeNeuronasEnCapa(2);

        numeroDeCapasOcultas = 2;
        listaDeCapasOcultas = new ArrayList<CapaOculta>();
        for (int i = 0; i < numeroDeCapasOcultas; i++) {
            capaOculta = new CapaOculta();
            capaOculta.setNumeroDeNeuronasEnCapa(3);
            listaDeCapasOcultas.add(capaOculta);
        }

        capaSalida = new CapaSalida();
        capaSalida.setNumeroDeNeuronasEnCapa(1);

        capaEntrada = capaEntrada.initCapa(capaEntrada);

        listaDeCapasOcultas = capaOculta.initCapa(capaOculta, listaDeCapasOcultas, capaEntrada, capaSalida);

        capaSalida = capaSalida.initCapa(capaSalida);

    }

    public void printNet() {
        capaEntrada.printCapa(capaEntrada);
        System.out.println();
        capaOculta.printCapa(listaDeCapasOcultas);
        System.out.println();
        capaSalida.printCapa(capaSalida);
    }

}
