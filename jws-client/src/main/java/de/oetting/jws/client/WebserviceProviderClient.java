package de.oetting.jws.client;

import static javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_BINDING;

import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

/**
 * Calls a webserviceprovider with an attachment part using the SAAJ api.<br>
 * Required the jws-server project running on a local server.
 *
 */
public class WebserviceProviderClient {

	public void callService() throws Exception {
		Dispatch<SOAPMessage> dispatchclient = createDispatchClient();
		SOAPMessage message = createMessage();
		dispatchclient.invoke(message);
	}

	private static Dispatch<SOAPMessage> createDispatchClient() {
		String endpoint = "http://localhost:8080/jws-server/WebserviceProvider";
		Service service = javax.xml.ws.Service.create(new QName("test"));
		QName portName = new QName("ProviderPort");  
		service.addPort(portName, SOAP11HTTP_BINDING, endpoint);
		Dispatch<SOAPMessage> dispatchclient = service.createDispatch(portName, SOAPMessage.class, javax.xml.ws.Service.Mode.MESSAGE);
		return dispatchclient;
	}  

	private static SOAPMessage createMessage() throws Exception {
		SOAPMessage message = MessageFactory.newInstance().createMessage();
		AttachmentPart attachmentPart = message.createAttachmentPart("hello-world" ,"text/html");
		message.addAttachmentPart(attachmentPart);
		message.saveChanges();
		return message;
	}

}
