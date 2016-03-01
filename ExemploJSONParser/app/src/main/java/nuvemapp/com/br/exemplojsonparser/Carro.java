package nuvemapp.com.br.exemplojsonparser;

import java.util.List;

/**
 * Created by XPredator on 29/02/2016.
 */
public class Carro {

    private String marca;
    private String modelo;
    private List<Potencia> potencias;

    public Carro() {
        super();
    }

    public Carro(String marca, String modelo, List<Potencia> potencias) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencias = potencias;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Potencia> getPotencias() {
        return potencias;
    }

    public void setPotencias(List<Potencia> potencias) {
        this.potencias = potencias;
    }
}
