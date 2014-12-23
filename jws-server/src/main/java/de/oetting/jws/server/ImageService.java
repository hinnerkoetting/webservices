package de.oetting.jws.server;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@WebService
@MTOM
public class ImageService {

	
	public Image getImage() {
		return new BufferedImage(100, 100, BufferedImage.TYPE_3BYTE_BGR);
	}
}
