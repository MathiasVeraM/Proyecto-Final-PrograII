package edu.udla.vmathias.mjean.pfinal.inventarios;
public class Finanzas{
    private float ganancias;
    private float perdidas;
    private int cant_rep;
    private float costo_rep;
    private float presupuesto;
    public Finanzas() {
    }

    public float getGanancias() {
        return ganancias;
    }

    public void setGanancias(float ganancias) {
        this.ganancias = ganancias;
    }

    public float getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(float perdidas) {
        this.perdidas = perdidas;
    }

    public int getCant_rep() {
        return cant_rep;
    }

    public void setCant_rep(int cant_rep) {
        this.cant_rep = cant_rep;
    }

    public float getCosto_rep() {
        return costo_rep;
    }

    public void setCosto_rep(float costo_rep) {
        this.costo_rep = costo_rep;
    }

    public float calculoValrep(int x){
        if(x % 2 == 0){
            this.costo_rep = 5.6F;
        }else{
            this.costo_rep = 6.4F;
        }
        return this.costo_rep;
    }

    public float presupuesto(float x, float y, float z){
        x = this.ganancias;
        y = this.perdidas;
        z = this.costo_rep;

        return (x-(y-z));
    }
}
