package ca.etsmtl.gti785.file;
import java.io.IOException;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


/**
 * Midlet d'introduction pour les �tudiants de GTI780.
 * 
 * Capable d'obtenir et d'afficher le logo de l'�TS dans un t�l�phone assez
 * grand.
 * 
 * @author Luc Trudeau
 * 
 */
public class HelloMidlet extends MIDlet {

	private Form fmViewPng;
	private Display display;

	public HelloMidlet() {
		display = Display.getDisplay(this);
		fmViewPng = new Form("");
	}

	protected void startApp() throws MIDletStateChangeException {
		final String url = "http://etsmtl.ca/ETS/media/Prive/logo/ETS-rouge-devise-ecran-fond_transparent.png";
		try {
			final Image im = ImageFetcher.getImage(url);
			final ImageItem ii = new ImageItem(null, im,
					ImageItem.LAYOUT_DEFAULT, null);
			fmViewPng.append(ii);
			display.setCurrent(fmViewPng);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void destroyApp(boolean unconditional)
			throws MIDletStateChangeException {
	}

	protected void pauseApp() {
	}
}
