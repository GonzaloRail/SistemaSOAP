
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

    private final static QName _AgregarStock_QNAME = new QName("http://servicio.ventas.com/", "agregarStock");
    private final static QName _AgregarStockResponse_QNAME = new QName("http://servicio.ventas.com/", "agregarStockResponse");
    private final static QName _ConsultarStock_QNAME = new QName("http://servicio.ventas.com/", "consultarStock");
    private final static QName _ConsultarStockResponse_QNAME = new QName("http://servicio.ventas.com/", "consultarStockResponse");
    private final static QName _ListarCategorias_QNAME = new QName("http://servicio.ventas.com/", "listarCategorias");
    private final static QName _ListarCategoriasResponse_QNAME = new QName("http://servicio.ventas.com/", "listarCategoriasResponse");
    private final static QName _ListarProductos_QNAME = new QName("http://servicio.ventas.com/", "listarProductos");
    private final static QName _ListarProductosAgotados_QNAME = new QName("http://servicio.ventas.com/", "listarProductosAgotados");
    private final static QName _ListarProductosAgotadosResponse_QNAME = new QName("http://servicio.ventas.com/", "listarProductosAgotadosResponse");
    private final static QName _ListarProductosBajoStock_QNAME = new QName("http://servicio.ventas.com/", "listarProductosBajoStock");
    private final static QName _ListarProductosBajoStockResponse_QNAME = new QName("http://servicio.ventas.com/", "listarProductosBajoStockResponse");
    private final static QName _ListarProductosDisponibles_QNAME = new QName("http://servicio.ventas.com/", "listarProductosDisponibles");
    private final static QName _ListarProductosDisponiblesResponse_QNAME = new QName("http://servicio.ventas.com/", "listarProductosDisponiblesResponse");
    private final static QName _ListarProductosPorCategoria_QNAME = new QName("http://servicio.ventas.com/", "listarProductosPorCategoria");
    private final static QName _ListarProductosPorCategoriaResponse_QNAME = new QName("http://servicio.ventas.com/", "listarProductosPorCategoriaResponse");
    private final static QName _ListarProductosResponse_QNAME = new QName("http://servicio.ventas.com/", "listarProductosResponse");
    private final static QName _ObtenerEstadisticas_QNAME = new QName("http://servicio.ventas.com/", "obtenerEstadisticas");
    private final static QName _ObtenerEstadisticasResponse_QNAME = new QName("http://servicio.ventas.com/", "obtenerEstadisticasResponse");
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
     * Create an instance of {@link AgregarStock }
     * 
     */
    public AgregarStock createAgregarStock() {
        return new AgregarStock();
    }

    /**
     * Create an instance of {@link AgregarStockResponse }
     * 
     */
    public AgregarStockResponse createAgregarStockResponse() {
        return new AgregarStockResponse();
    }

    /**
     * Create an instance of {@link ConsultarStock }
     * 
     */
    public ConsultarStock createConsultarStock() {
        return new ConsultarStock();
    }

    /**
     * Create an instance of {@link ConsultarStockResponse }
     * 
     */
    public ConsultarStockResponse createConsultarStockResponse() {
        return new ConsultarStockResponse();
    }

    /**
     * Create an instance of {@link ListarCategorias }
     * 
     */
    public ListarCategorias createListarCategorias() {
        return new ListarCategorias();
    }

    /**
     * Create an instance of {@link ListarCategoriasResponse }
     * 
     */
    public ListarCategoriasResponse createListarCategoriasResponse() {
        return new ListarCategoriasResponse();
    }

    /**
     * Create an instance of {@link ListarProductos }
     * 
     */
    public ListarProductos createListarProductos() {
        return new ListarProductos();
    }

    /**
     * Create an instance of {@link ListarProductosAgotados }
     * 
     */
    public ListarProductosAgotados createListarProductosAgotados() {
        return new ListarProductosAgotados();
    }

    /**
     * Create an instance of {@link ListarProductosAgotadosResponse }
     * 
     */
    public ListarProductosAgotadosResponse createListarProductosAgotadosResponse() {
        return new ListarProductosAgotadosResponse();
    }

    /**
     * Create an instance of {@link ListarProductosBajoStock }
     * 
     */
    public ListarProductosBajoStock createListarProductosBajoStock() {
        return new ListarProductosBajoStock();
    }

    /**
     * Create an instance of {@link ListarProductosBajoStockResponse }
     * 
     */
    public ListarProductosBajoStockResponse createListarProductosBajoStockResponse() {
        return new ListarProductosBajoStockResponse();
    }

    /**
     * Create an instance of {@link ListarProductosDisponibles }
     * 
     */
    public ListarProductosDisponibles createListarProductosDisponibles() {
        return new ListarProductosDisponibles();
    }

    /**
     * Create an instance of {@link ListarProductosDisponiblesResponse }
     * 
     */
    public ListarProductosDisponiblesResponse createListarProductosDisponiblesResponse() {
        return new ListarProductosDisponiblesResponse();
    }

    /**
     * Create an instance of {@link ListarProductosPorCategoria }
     * 
     */
    public ListarProductosPorCategoria createListarProductosPorCategoria() {
        return new ListarProductosPorCategoria();
    }

    /**
     * Create an instance of {@link ListarProductosPorCategoriaResponse }
     * 
     */
    public ListarProductosPorCategoriaResponse createListarProductosPorCategoriaResponse() {
        return new ListarProductosPorCategoriaResponse();
    }

    /**
     * Create an instance of {@link ListarProductosResponse }
     * 
     */
    public ListarProductosResponse createListarProductosResponse() {
        return new ListarProductosResponse();
    }

    /**
     * Create an instance of {@link ObtenerEstadisticas }
     * 
     */
    public ObtenerEstadisticas createObtenerEstadisticas() {
        return new ObtenerEstadisticas();
    }

    /**
     * Create an instance of {@link ObtenerEstadisticasResponse }
     * 
     */
    public ObtenerEstadisticasResponse createObtenerEstadisticasResponse() {
        return new ObtenerEstadisticasResponse();
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
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link Venta }
     * 
     */
    public Venta createVenta() {
        return new Venta();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarStock }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgregarStock }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "agregarStock")
    public JAXBElement<AgregarStock> createAgregarStock(AgregarStock value) {
        return new JAXBElement<AgregarStock>(_AgregarStock_QNAME, AgregarStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarStockResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgregarStockResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "agregarStockResponse")
    public JAXBElement<AgregarStockResponse> createAgregarStockResponse(AgregarStockResponse value) {
        return new JAXBElement<AgregarStockResponse>(_AgregarStockResponse_QNAME, AgregarStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarStock }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarStock }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "consultarStock")
    public JAXBElement<ConsultarStock> createConsultarStock(ConsultarStock value) {
        return new JAXBElement<ConsultarStock>(_ConsultarStock_QNAME, ConsultarStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarStockResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarStockResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "consultarStockResponse")
    public JAXBElement<ConsultarStockResponse> createConsultarStockResponse(ConsultarStockResponse value) {
        return new JAXBElement<ConsultarStockResponse>(_ConsultarStockResponse_QNAME, ConsultarStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCategorias }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarCategorias }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarCategorias")
    public JAXBElement<ListarCategorias> createListarCategorias(ListarCategorias value) {
        return new JAXBElement<ListarCategorias>(_ListarCategorias_QNAME, ListarCategorias.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarCategoriasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarCategoriasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarCategoriasResponse")
    public JAXBElement<ListarCategoriasResponse> createListarCategoriasResponse(ListarCategoriasResponse value) {
        return new JAXBElement<ListarCategoriasResponse>(_ListarCategoriasResponse_QNAME, ListarCategoriasResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosAgotados }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosAgotados }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosAgotados")
    public JAXBElement<ListarProductosAgotados> createListarProductosAgotados(ListarProductosAgotados value) {
        return new JAXBElement<ListarProductosAgotados>(_ListarProductosAgotados_QNAME, ListarProductosAgotados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosAgotadosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosAgotadosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosAgotadosResponse")
    public JAXBElement<ListarProductosAgotadosResponse> createListarProductosAgotadosResponse(ListarProductosAgotadosResponse value) {
        return new JAXBElement<ListarProductosAgotadosResponse>(_ListarProductosAgotadosResponse_QNAME, ListarProductosAgotadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosBajoStock }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosBajoStock }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosBajoStock")
    public JAXBElement<ListarProductosBajoStock> createListarProductosBajoStock(ListarProductosBajoStock value) {
        return new JAXBElement<ListarProductosBajoStock>(_ListarProductosBajoStock_QNAME, ListarProductosBajoStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosBajoStockResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosBajoStockResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosBajoStockResponse")
    public JAXBElement<ListarProductosBajoStockResponse> createListarProductosBajoStockResponse(ListarProductosBajoStockResponse value) {
        return new JAXBElement<ListarProductosBajoStockResponse>(_ListarProductosBajoStockResponse_QNAME, ListarProductosBajoStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosDisponibles }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosDisponibles }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosDisponibles")
    public JAXBElement<ListarProductosDisponibles> createListarProductosDisponibles(ListarProductosDisponibles value) {
        return new JAXBElement<ListarProductosDisponibles>(_ListarProductosDisponibles_QNAME, ListarProductosDisponibles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosDisponiblesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosDisponiblesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosDisponiblesResponse")
    public JAXBElement<ListarProductosDisponiblesResponse> createListarProductosDisponiblesResponse(ListarProductosDisponiblesResponse value) {
        return new JAXBElement<ListarProductosDisponiblesResponse>(_ListarProductosDisponiblesResponse_QNAME, ListarProductosDisponiblesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosPorCategoria }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosPorCategoria }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosPorCategoria")
    public JAXBElement<ListarProductosPorCategoria> createListarProductosPorCategoria(ListarProductosPorCategoria value) {
        return new JAXBElement<ListarProductosPorCategoria>(_ListarProductosPorCategoria_QNAME, ListarProductosPorCategoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarProductosPorCategoriaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarProductosPorCategoriaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "listarProductosPorCategoriaResponse")
    public JAXBElement<ListarProductosPorCategoriaResponse> createListarProductosPorCategoriaResponse(ListarProductosPorCategoriaResponse value) {
        return new JAXBElement<ListarProductosPorCategoriaResponse>(_ListarProductosPorCategoriaResponse_QNAME, ListarProductosPorCategoriaResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerEstadisticas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerEstadisticas }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "obtenerEstadisticas")
    public JAXBElement<ObtenerEstadisticas> createObtenerEstadisticas(ObtenerEstadisticas value) {
        return new JAXBElement<ObtenerEstadisticas>(_ObtenerEstadisticas_QNAME, ObtenerEstadisticas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerEstadisticasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObtenerEstadisticasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicio.ventas.com/", name = "obtenerEstadisticasResponse")
    public JAXBElement<ObtenerEstadisticasResponse> createObtenerEstadisticasResponse(ObtenerEstadisticasResponse value) {
        return new JAXBElement<ObtenerEstadisticasResponse>(_ObtenerEstadisticasResponse_QNAME, ObtenerEstadisticasResponse.class, null, value);
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
