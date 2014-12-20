package de.oetting.jws.server.handler;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.rpc.handler.HandlerChain;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class Validator implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			if (isIncoming(context))
				validateFirstNumberIsNotTooBig(context);
			return true;
		} catch (SOAPException e) {
			throw new RuntimeException(e);
		}
	}

	private boolean isIncoming(SOAPMessageContext context) {
		return !(Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
	}

	private void validateFirstNumberIsNotTooBig(SOAPMessageContext context) throws SOAPException {
		SOAPBody soapBody = context.getMessage().getSOAPBody();
		Iterator childElements = soapBody.getChildElements();
		childElements.next();
		Node element = (Node) childElements.next();
		Node firstParameter = (Node) element.getChildNodes().item(1);
		if (Integer.valueOf(firstParameter.getTextContent()) > 10) {
			throw new ProtocolException("Wert ist zu gross");
		}
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return false;
	}

	@Override
	public void close(MessageContext context) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<QName> getHeaders() {
		return Collections.EMPTY_SET;
	}

}
