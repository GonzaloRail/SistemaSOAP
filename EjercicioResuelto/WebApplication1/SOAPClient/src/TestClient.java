import org.my.ns.SOAPI;            // paquete generado por NetBeans
import org.my.ns.SOAPImplService; // clase service generada
import org.my.ns.Product;          // clase Product generada
import java.util.List;

public class TestClient {
    public static void main(String[] args) {
        // Crear instancia del Service
        SOAPImplService service = new SOAPImplService();

        // Obtener el puerto (interfaz para llamar métodos)
        SOAPI port = service.getSOAPImplPort();

        // Invocar método para obtener lista de productos
        List<Product> products = port.getProducts();

        System.out.println("Productos iniciales:");
        for (Product p : products) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }

        // Crear nuevo producto y agregarlo
        Product nuevoProducto = new Product();
        nuevoProducto.setName("Resaltadores");
        nuevoProducto.setPrice(1.50);
        port.addProduct(nuevoProducto);

        System.out.println("Producto agregado.");

        // Verificar que se agregó el producto
        products = port.getProducts();
        System.out.println("Productos actualizados:");
        for (Product p : products) {
            System.out.println(p.getName() + " - " + p.getPrice());
        }
    }
}
