import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {

	    try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()) {

	        ByteBuffer buffer = ByteBuffer.allocate(100);

//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
//            buffer.flip();

            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();

            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
                System.out.println("int3 = " + readBuffer.getInt());
                readBuffer.flip();
                channel.position(int2Pos);
                channel.read(readBuffer);
                readBuffer.flip();
                System.out.println("int2 = " + readBuffer.getInt());
                readBuffer.flip();
                channel.position(int1Pos);
                channel.read(readBuffer);
                readBuffer.flip();
                System.out.println("int1 = " + readBuffer.getInt());

                byte[] outputString = "Hello, World!".getBytes();
                long str1Pos = 0;
                long newInt1Pos = outputString.length;
                long newInt2Pos = newInt1Pos + Integer.BYTES;
                byte[] outputString2 = "Nice to meet you".getBytes();
                long str2Pos = newInt2Pos + Integer.BYTES;
                long newInt3Pos = str2Pos + outputString2.length;

                ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
                intBuffer.putInt(245);
                intBuffer.flip();
                binChannel.position(newInt3Pos);
                binChannel.write(intBuffer);

                intBuffer.flip();
                intBuffer.putInt(-98765);
                intBuffer.flip();
                binChannel.position(newInt2Pos);
                binChannel.write(intBuffer);

                intBuffer.flip();
                intBuffer.putInt(1000);
                intBuffer.flip();
                binChannel.position(newInt3Pos);
                binChannel.write(intBuffer);

                binChannel.position(str1Pos);
                binChannel.write(ByteBuffer.wrap(outputString));
                binChannel.position(str2Pos);
                binChannel.write(ByteBuffer.wrap(outputString2));

//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip(); // switch from writing to the buffer to reading from the buffer
//                /* independant try at reverse integer read */
//                System.out.println("reading integers in reverse: ");
//                readBuffer.position((int) int3Pos);
//                System.out.println(readBuffer.getInt());
//                readBuffer.flip();
//                readBuffer.position((int) int2Pos);
//                System.out.println(readBuffer.getInt());
//                readBuffer.flip();
//                readBuffer.position((int) int1Pos);
//                System.out.println(readBuffer.getInt());
//                readBuffer.flip();
//                readBuffer.position(0);
//                /* */
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("inputString = " + new String(inputString));
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());

//            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();
//
//            int numBytes = binChannel.write(buffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputBytes[0] = 'a';
//            outputBytes[1] = 'b';
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//            if(buffer.hasArray()) {
//                System.out.println("byte buffer = " + new String(buffer.array()));
////                System.out.println("byte buffer = " + new String(outputBytes));
//            }
//
//            // Absolute read
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));
//            System.out.println(intBuffer.getInt());
//
//            // Relative read
//            //            intBuffer.flip();
//            //            numBytesRead = channel.read(intBuffer);
//            //            intBuffer.flip();
//            //            System.out.println(intBuffer.getInt());
//            //            intBuffer.flip();
//            //            numBytesRead = channel.read(intBuffer);
//            //            intBuffer.flip();
//            //            System.out.println(intBuffer.getInt());
//
//            channel.close();
//            ra.close();

//            System.out.println("outputBytes = " + new String(outputBytes));

//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//            System.out.println(new String(b));
//
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);

        } catch(IOException e) {
	        e.printStackTrace();
        }
    }
}
