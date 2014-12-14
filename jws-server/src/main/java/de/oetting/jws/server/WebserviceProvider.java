package de.oetting.jws.server;

import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

@WebServiceProvider(
	    portName="ProviderPort",
	    serviceName="WebserviceProvider",
	    targetNamespace="http://de.oetting.jws/wsdl"
	)
	@BindingType(value="http://schemas.xmlsoap.org/wsdl/soap/http")
	@ServiceMode(value=javax.xml.ws.Service.Mode.MESSAGE)
public class WebserviceProvider implements Provider<SOAPMessage> {

	@SuppressWarnings("unchecked")
	public SOAPMessage invoke(SOAPMessage arg0) {
		try {
			Iterator<AttachmentPart> attachments = arg0.getAttachments();
			while (attachments.hasNext()) {
				AttachmentPart part = attachments.next();
				System.out.println(part.getContent());
			}
			SOAPMessage message = createMessage();
			return message;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private SOAPMessage createMessage() throws SOAPException {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage message = messageFactory.createMessage();
		SOAPBody soapBody = message.getSOAPBody();

		SOAPElement element = soapBody.addChildElement(new QName("abc"));
		element.setTextContent("ok");
		return message;
	}

}
