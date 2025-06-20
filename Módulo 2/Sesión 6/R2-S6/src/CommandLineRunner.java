import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaApplication implements CommandLineRunner {

    @Autowired
    private ProductoRepository productoRepo;

    @Autowired
    private MarcaRepository marcaRepo;

    public static void main(String[] args) {
        SpringApplication.run(TiendaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Marca apple = new Marca("Apple");
        Marca samsung = new Marca("Samsung");

        marcaRepo.save(apple);
        marcaRepo.save(samsung);

        Producto producto1 = new Producto("iPhone 15", 999.99, apple);
        Producto producto2 = new Producto("iPad Pro", 1299.99, apple);
        Producto producto3 = new Producto("Galaxy S23", 899.99, samsung);
        Producto producto4 = new Producto("Smart TV QLED", 1499.99, samsung);

        productoRepo.saveAll(List.of(producto1, producto2, producto3, producto4));

        System.out.println("📚 Productos por marca:");
        marcaRepo.findAll().forEach(marca -> {
            System.out.println("🏷️ " + marca.getNombre() + ":");
            productoRepo.findAll().stream()
                    .filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId()))
                    .forEach(p -> System.out.println("   - " + p.getNombre()));
        });
    }
}