package lesson14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannel;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncIOTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
//		try(final RandomAccessFile	raf = new RandomAccessFile("c:/temp/alles.txt", "rw")) {
//			FileChannel fc = raf.getChannel();
//		}
		ByteBuffer	bb = ByteBuffer.allocate(1024);
		
		try (final  AsynchronousFileChannel fc = AsynchronousFileChannel.open(new File("c:/temp/alles.txt").toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
//			Future<Integer> f = fc.read(bb, 0);
//			// TODO lksdfjklsjdflkjdfjsdflsdflkjsdflkj
//			final int len = f.get();
//			System.err.println("Len="+len);
//			final CountDownLatch latch = new CountDownLatch(1);
//			fc.read(bb, 0, new CompletionHandler<Object, CountDownLatch>() {
//
//				@Override
//				public void completed(Object result, CountDownLatch attachment) {
//					// TODO Auto-generated method stub
//					attachment.countDown();
//				}
//
//				@Override
//				public void failed(Throwable exc, CountDownLatch attachment) {
//					// TODO Auto-generated method stub
//					
//				}
//			}, latch);
//			// TODO
//			latch.await();
		
		}
	}

}
