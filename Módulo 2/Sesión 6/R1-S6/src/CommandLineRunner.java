import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductoRepository productoRepository) {
        return (args) -> {
            Producto laptop = new Producto("Laptop Lenovo", "Laptop de 15 pulgadas", 12500.00);
            Producto mouse = new Producto("Mouse Logitech", "Mouse inalámbrico", 350.00);
            Producto teclado = new Producto("Teclado Mecánico", "Teclado mecánico RGB", 950.00);
            Producto monitor = new Producto("Monitor", "Monitor de 24 pulgadas", 3200.00);

            productoRepository.save(laptop);
            productoRepository.save(mouse);
            productoRepository.save(teclado);
            productoRepository.save(monitor);

            List<Producto> productosCaros = productoRepository.findByPrecioGreaterThan(500);
            System.out.println("\n📦 Productos con precio mayor a 500:");
            productosCaros.forEach(System.out::println);

            List<Producto> productosConLap = productoRepository.findByNombreContainingIgnoreCase("lap");
            System.out.println("\n🔍 Productos que contienen 'lap':");
            productosConLap.forEach(System.out::println);

            List<Producto> productosRango = productoRepository.findByPrecioBetween(400, 1000);
            System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
            productosRango.forEach(System.out::println);

            List<Producto> productosConM = productoRepository.findByNombreStartingWithIgnoreCase("m");
            System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
            productosConM.forEach(System.out::println);
        };
    }
}