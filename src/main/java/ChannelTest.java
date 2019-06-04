import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/a.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(56);
        int byteRead = fileChannel.read(buffer);
        while (byteRead!=-1){
            System.out.print("Read"+byteRead);
//            buffer.flip();
            while (buffer.hasRemaining())
                System.out.print((char) buffer.get());
            buffer.clear();
            byteRead = fileChannel.read(buffer);

        }
        fileChannel.close();
    }




}
