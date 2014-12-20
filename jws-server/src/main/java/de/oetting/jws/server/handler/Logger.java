package de.oetting.jws.server.handler;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.LoggerFactory;

public class Logger implements SOAPHandler<SOAPMessageContext> {

	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Logger.class);

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		LOGGER.info("Handle Message");
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		LOGGER.info("Handle Fault");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		LOGGER.info("Close");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<QName> getHeaders() {
		return Collections.EMPTY_SET;
	}

}
