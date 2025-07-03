import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class tcp_server {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(5000));
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server started on port 5000");

        while (true) {
            selector.select();
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();

                if (key.isAcceptable()) {
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("Connected: " + client.getRemoteAddress());
                } else if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int read = client.read(buf);
                    if (read <= 0) {
                        System.out.println("Disconnected: " + client.getRemoteAddress());
                        client.close();
                        continue;
                    }
                    buf.flip();
                    byte[] data = new byte[buf.limit()];
                    buf.get(data);
                    String received = new String(data).trim();
                    System.out.println("Received: " + received);

                    byte[] response = (received.toUpperCase() + "\n").getBytes();
                    ByteBuffer writeBuffer = ByteBuffer.wrap(response);
                    while (writeBuffer.hasRemaining()) {
                        client.write(writeBuffer);
                    }
                    System.out.println("Sent: " + new String(response).trim());
                }
            }
        }
    }
}
