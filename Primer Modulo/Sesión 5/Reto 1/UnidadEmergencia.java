public abstract class UnidadEmergencia {
    String nombre;

    public UnidadEmergencia(String nombre) { this.nombre = nombre; }
    public void activarUnidad() { System.out.println("Activando unidad: " + nombre);
    }
    public abstract void responder();
}
