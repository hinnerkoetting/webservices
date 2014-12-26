
package de.oetting.jws.server;

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
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AdditionService", targetNamespace = "http://server.jws.oetting.de/", wsdlLocation = "http://localhost:8090/jws-server/AdditionService?wsdl")
public class AdditionService
    extends Service
{

    private final static URL ADDITIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADDITIONSERVICE_EXCEPTION;
    private final static QName ADDITIONSERVICE_QNAME = new QName("http://server.jws.oetting.de/", "AdditionService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8090/jws-server/AdditionService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADDITIONSERVICE_WSDL_LOCATION = url;
        ADDITIONSERVICE_EXCEPTION = e;
    }

    public AdditionService() {
        super(__getWsdlLocation(), ADDITIONSERVICE_QNAME);
    }

    public AdditionService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADDITIONSERVICE_QNAME, features);
    }

    public AdditionService(URL wsdlLocation) {
        super(wsdlLocation, ADDITIONSERVICE_QNAME);
    }

    public AdditionService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADDITIONSERVICE_QNAME, features);
    }

    public AdditionService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdditionService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HandlerChainService
     */
    @WebEndpoint(name = "HandlerChainServicePort")
    public HandlerChainService getHandlerChainServicePort() {
        return super.getPort(new QName("http://server.jws.oetting.de/", "HandlerChainServicePort"), HandlerChainService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HandlerChainService
     */
    @WebEndpoint(name = "HandlerChainServicePort")
    public HandlerChainService getHandlerChainServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server.jws.oetting.de/", "HandlerChainServicePort"), HandlerChainService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADDITIONSERVICE_EXCEPTION!= null) {
            throw ADDITIONSERVICE_EXCEPTION;
        }
        return ADDITIONSERVICE_WSDL_LOCATION;
    }

}