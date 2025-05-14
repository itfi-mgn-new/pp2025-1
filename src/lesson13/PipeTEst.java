package lesson13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Reader;
import java.io.Writer;

public class PipeTEst {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		try(final PipedInputStream	pis = new PipedInputStream();
			final PipedOutputStream	pos = new PipedOutputStream(pis);
			final Reader	rdr = new InputStreamReader(pis);
			final BufferedReader	brdr = new BufferedReader(rdr);
			final Writer	wr = new OutputStreamWriter(pos)) {
			
			final Thread	t = new Thread(()->read(brdr));
			
			t.setDaemon(true);
			t.start();
			wr.write("test string");
			wr.flush();
		}
	}

	private static void read(BufferedReader brdr) {
		// TODO Auto-generated method stub
		String	line;
		
		try {
			while ((line = brdr.readLine()) != null) {
				System.err.println("Line="+line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
