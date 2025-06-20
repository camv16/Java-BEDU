import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Producto() {}

    public Producto(String nombre, double precio, Marca marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}