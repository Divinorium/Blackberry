package ca.etsmtl.gti785.file;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import javax.microedition.io.Connector;
import javax.microedition.io.ContentConnection;
import javax.microedition.lcdui.Image;

/**
 * 
 * @author Luc Trudeau
 * 
 *         Fortement inspir� de (J'ai concerver les commentaires en anglais):
 *         http://www.java2s.com/Code/Java/J2ME/Downloadandviewapngfile.htm
 */
public final class ImageFetcher {

	/**
	 * Obtient une image � partir d'un URL.
	 * 
	 * @param url
	 *            Adresse de l'image a obtenir.
	 * @return Un objet Image qui contient les bites de l'images.
	 * @throws IOException
	 *             Cette exception est lanc� s'il y a un probl�me lors de
	 *             l'obtention de l'image
	 */
	public static Image getImage(final String url) throws IOException {
		final ContentConnection connection = (ContentConnection) Connector.open(url);

		// * There is a bug in MIDP 1.0.3 in which read() sometimes returns
		// an invalid length. To work around this, I have changed the
		// stream to DataInputStream and called readFully() instead of read()
		// InputStream iStrm = connection.openInputStream();
		final DataInputStream iStrm = connection.openDataInputStream();

		ByteArrayOutputStream bStrm = null;
		Image im = null;
		try {
			// ContentConnection includes a length method
			byte imageData[];
			int length = (int) connection.getLength();
			if (length != -1) {
				imageData = new byte[length];

				// Read the image into an array
				// iStrm.read(imageData);
				iStrm.readFully(imageData);
			} else // Length not available...
			{
				bStrm = new ByteArrayOutputStream();

				int ch;
				while ((ch = iStrm.read()) != -1)
					bStrm.write(ch);

				imageData = bStrm.toByteArray();
				bStrm.close();
			}

			// Create the image from the byte array
			im = Image.createImage(imageData, 0, imageData.length);
		} finally {
			// Clean up
			if (iStrm != null)
				iStrm.close();
			if (connection != null)
				connection.close();
			if (bStrm != null)
				bStrm.close();
		}
		return im;
	}

	/**
	 * Pour emp�cher d'utiliser la classe tout croche.
	 */
	private ImageFetcher() {
	}
}
