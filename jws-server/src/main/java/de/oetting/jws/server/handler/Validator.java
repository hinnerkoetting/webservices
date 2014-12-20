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

import org.w3c.dom.NodeList;

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
		Node element = findAddElement(soapBody);
		Node firstParameter = findArg0Element(element);
		if (Integer.valueOf(firstParameter.getTextContent()) > 10) {
			throw new ProtocolException("Wert ist zu gross");
		}
	}

	private Node findArg0Element(Node element) {
		return findElementWithName(element.getChildNodes(), "arg0");
	}

	@SuppressWarnings("unchecked")
	private Node findAddElement(SOAPBody soapBody) {
		return findElementWithName(soapBody.getChildElements(), "add");
	}

	private Node findElementWithName(Iterator<Node> childElements, String name) {
		while (childElements.hasNext()) {
			Node nextNode = (Node) childElements.next();
			if (nextNode.getNodeName().endsWith(name)) {
				return nextNode;
			}
		}
		throw new IllegalArgumentException(name + ": element not found");
	}

	private Node findElementWithName(NodeList list, String name) {
		for (int i = 0; i < list.getLength(); i++) {
			Node nextNode = (Node) list.item(i);
			if (nextNode.getNodeName().contains(name)) {
				return nextNode;
			}
		}
		throw new IllegalArgumentException(name + ": element not found");
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
