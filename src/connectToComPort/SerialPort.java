package connectToComPort;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alex on 04.01.2016.
 */
public class SerialPort {
    public static final Object DATABITS_8 = 1;
    public static final Object STOPBITS_1 = 2;
    public static final Object PARITY_NONE = 3;

    public OutputStream getOutputStream() {
        OutputStream outputStream = null;
        return outputStream;
    }

    public InputStream getInputStream() {
        InputStream inputStream = null;
        return inputStream;
    }

    public void notifyOnDataAvailable(boolean b) {
    }

    public void addEventListener(ConnectToCom.Terminal terminal) {
    }

    public void setSerialPortParams(int i, Object databits8, Object stopbits1, Object parityNone) {
    }
}
