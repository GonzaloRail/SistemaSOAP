
package com.cliente.ventas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cliente.ventas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListarProductos_QNAME = new QName("http://servicio.ventas.com/", "listarProductos");
    private final static QName _ListarProductosResponse_QNAME = new QName("http://servicio.ventas.com/", "listarProductosResponse");
    private final static QName _ObtenerHistorialVentas_QNAME = new QName("http://servicio.ventas.com/", "obtenerHistorialVentas");
    private final static QName _ObtenerHistorialVentasResponse_QNAME = new QName("http://servicio.ventas.com/", "obtenerHistorialVentasResponse");
    private final static QName _RegistrarVenta_QNAME = new QName("http://servicio.ventas.com/", "registrarVenta");
    private final static QName _RegistrarVentaResponse_QNAME = new QName("http://servicio.ventas.com/", "registrarVentaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cliente.ventas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListarProductos }
     * 
     */
    public ListarProductos createListarProductos() {
        return new ListarProductos();
    }

    /**
     * Create an instance of {@link ListarProductosResponse }
     * 
     */
    public ListarProductosResponse createListarProductosResponse() {
        return new ListarProductosResponse();
    }

    /**
     * Create an instance of {@link ObtenerHistorialVentas }
     * 
     */
    public ObtenerHistorialVentas createObtenerHistorialVentas() {
        return new ObtenerHistorialVentas();
    }

    /**
     * Create an instance of {@link ObtenerHistorialVentasResponse }
     * 
     */
    public ObtenerHistorialVentasResponse createObtenerHistorialVentasResponse() {
        return new ObtenerHistorialVentasResponse();
    }

    /**
     * Create an instance of {@link RegistrarVenta }
     * 
     */
    public RegistrarVenta createRegistrarVenta() {
        return new RegistrarVenta();
    }

    /**
     * Create an instance of {@link RegistrarVentaResponse }
     * 
     */
    public RegistrarVentaResponse createRegistrarVentaResponse() {
        return new RegistrarVentaResponse();
    }

    /**
     * Create an instance of {@link Venta }
     * 
     */
    public Venta createVenta() {
        return new Venta();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductos }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductos")
    public JAXBElement<ListarProductos> createListarProductos(ListarProductos value) {
        return new JAXBElement<ListarProductos>(_ListarProductos_QNAME, ListarProductos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosResponse")
    public JAXBElement<ListarProductosResponse> createListarProductosResponse(ListarProductosResponse value) {
        return new JAXBElement<ListarProductosResponse>(_ListarProductosResponse_QNAME, ListarProductosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerHistorialVentas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerHistorialVentas }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "obtenerHistorialVentas")
    public JAXBElement<ObtenerHistorialVentas> createObtenerHistorialVentas(ObtenerHistorialVentas value) {
        return new JAXBElement<ObtenerHistorialVentas>(_ObtenerHistorialVentas_QNAME, ObtenerHistorialVentas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerHistorialVentasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerHistorialVentasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "obtenerHistorialVentasResponse")
    public JAXBElement<ObtenerHistorialVentasResponse> createObtenerHistorialVentasResponse(ObtenerHistorialVentasResponse value) {
        return new JAXBElement<ObtenerHistorialVentasResponse>(_ObtenerHistorialVentasResponse_QNAME, ObtenerHistorialVentasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarVenta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistrarVenta }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "registrarVenta")
    public JAXBElement<RegistrarVenta> createRegistrarVenta(RegistrarVenta value) {
        return new JAXBElement<RegistrarVenta>(_RegistrarVenta_QNAME, RegistrarVenta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarVentaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistrarVentaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "registrarVentaResponse")
    public JAXBElement<RegistrarVentaResponse> createRegistrarVentaResponse(RegistrarVentaResponse value) {
        return new JAXBElement<RegistrarVentaResponse>(_RegistrarVentaResponse_QNAME, RegistrarVentaResponse.class, null, value);
    }

}
