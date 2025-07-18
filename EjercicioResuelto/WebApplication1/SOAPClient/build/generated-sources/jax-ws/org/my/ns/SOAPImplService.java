
package org.my.ns;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SOAPImplService", targetNamespace = "http://my.org/ns/", wsdlLocation = "http://localhost:8080/WebApplication1/SOAPImplService?wsdl")
public class SOAPImplService
    extends Service
{

    private final static URL SOAPIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOAPIMPLSERVICE_EXCEPTION;
    private final static QName SOAPIMPLSERVICE_QNAME = new QName("http://my.org/ns/", "SOAPImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WebApplication1/SOAPImplService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOAPIMPLSERVICE_WSDL_LOCATION = url;
        SOAPIMPLSERVICE_EXCEPTION = e;
    }

    public SOAPImplService() {
        super(__getWsdlLocation(), SOAPIMPLSERVICE_QNAME);
    }

    public SOAPImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAPIMPLSERVICE_QNAME, features);
    }

    public SOAPImplService(URL wsdlLocation) {
        super(wsdlLocation, SOAPIMPLSERVICE_QNAME);
    }

    public SOAPImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAPIMPLSERVICE_QNAME, features);
    }

    public SOAPImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOAPImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SOAPI
     */
    @WebEndpoint(name = "SOAPImplPort")
    public SOAPI getSOAPImplPort() {
        return super.getPort(new QName("http://my.org/ns/", "SOAPImplPort"), SOAPI.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SOAPI
     */
    @WebEndpoint(name = "SOAPImplPort")
    public SOAPI getSOAPImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://my.org/ns/", "SOAPImplPort"), SOAPI.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAPIMPLSERVICE_EXCEPTION!= null) {
            throw SOAPIMPLSERVICE_EXCEPTION;
        }
        return SOAPIMPLSERVICE_WSDL_LOCATION;
    }

}
