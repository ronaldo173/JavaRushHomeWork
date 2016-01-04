package connectToComPort;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alex on 04.12.2015.
 */
public class ConnectToCom {


    public class Terminal implements Runnable,
            SerialPortEventListener {
        InputStream inputStream;
        OutputStream outputStream;
        SerialPort serialPort;
        Thread readThread;
        String[] messageString = {"AT\n", "ATI1\n", "ATI3\n"};

        public Terminal() {

            Desktop portId = null;
            assert portId != null;

            outputStream = serialPort.getOutputStream();
            inputStream = serialPort.getInputStream();
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            // устанавливаем параметры порта
            serialPort.setSerialPortParams(9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            readThread = new Thread(this);
            readThread.start();
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    outputStream.write(messageString[i].getBytes());
                } catch (IOException e) {
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.exit(1); // выход из программы
        }

//        public void serialEvent(SerialPortEvent event) {
//            switch(event.getEventType()) {
//                case SerialPortEvent.BI:
//                case SerialPortEvent.OE:
//                case SerialPortEvent.FE:
//                case SerialPortEvent.PE:
//                case SerialPortEvent.CD:
//                case SerialPortEvent.CTS:
//                case SerialPortEvent.DSR:
//                case SerialPortEvent.RI:
//                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
//                    break;
//                case SerialPortEvent.DATA_AVAILABLE:
//                    byte[] readBuffer = new byte[20];
//                    try {
//                        while (inputStream.available() > 0) {
//                            int numBytes = inputStream.read(readBuffer);
//                        }
//                        System.out.print(new String(readBuffer));
//                    } catch (IOException e) {}
//                    break;
//            }
//        }
//public void serialEvent(SerialPortEvent event) {
//            switch(event.getEventType()) {
//                case SerialPortEvent.BI:
//                case SerialPortEvent.OE:
//                case SerialPortEvent.FE:
//                case SerialPortEvent.PE:
//                case SerialPortEvent.CD:
//                case SerialPortEvent.CTS:
//                case SerialPortEvent.DSR:
//                case SerialPortEvent.RI:
//                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
//                    break;
//                case SerialPortEvent.DATA_AVAILABLE:
//                    byte[] readBuffer = new byte[20];
//                    try {
//                        while (inputStream.available() > 0) {
//                            int numBytes = inputStream.read(readBuffer);
//                        }
//                        System.out.print(new String(readBuffer));
//                    } catch (IOException e) {}
//                    break;
//            }
//        }
//    public void serialEvent (SerialPortEvent event){
//            switch(event.getEventType()) {
//                case SerialPortEvent.BI:
//                case SerialPortEvent.OE:
//                case SerialPortEvent.FE:
//                case SerialPortEvent.PE:
//                case SerialPortEvent.CD:
//                case SerialPortEvent.CTS:
//                case SerialPortEvent.DSR:
//                case SerialPortEvent.RI:
//                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
//                    break;
//                case SerialPortEvent.DATA_AVAILABLE:
//                    byte[] readBuffer = new byte[20];
//                    try {
//                        while (inputStream.available() > 0) {
//                            int numBytes = inputStream.read(readBuffer);
//                        }
//                        System.out.print(new String(readBuffer));
//                    } catch (IOException e) {}
//                    break;
//            }
//        }
//        public void serialEvent (SerialPortEvent event){
//            switch(event.getEventType()) {
//                case SerialPortEvent.BI:
//                case SerialPortEvent.OE:
//                case SerialPortEvent.FE:
//                case SerialPortEvent.PE:
//                case SerialPortEvent.CD:
//                case SerialPortEvent.CTS:
//                case SerialPortEvent.DSR:
//                case SerialPortEvent.RI:
//                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
//                    break;
//                case SerialPortEvent.DATA_AVAILABLE:
//                    byte[] readBuffer = new byte[20];
//                    try {
//                        while (inputStream.available() > 0) {
//                            int numBytes = inputStream.read(readBuffer);
//                        }
//                        System.out.print(new String(readBuffer));
//                    } catch (IOException e) {}
//                    break;
//            }
//        } public void serialEvent(SerialPortEvent event) {
//            switch(event.getEventType()) {
//                case SerialPortEvent.BI:
//                case SerialPortEvent.OE:
//                case SerialPortEvent.FE:
//                case SerialPortEvent.PE:
//                case SerialPortEvent.CD:
//                case SerialPortEvent.CTS:
//                case SerialPortEvent.DSR:
//                case SerialPortEvent.RI:
//                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
//                    break;
//                case SerialPortEvent.DATA_AVAILABLE:
//                    byte[] readBuffer = new byte[20];
//                    try {
//                        while (inputStream.available() > 0) {
//                            int numBytes = inputStream.read(readBuffer);
//                        }
//                        System.out.print(new String(readBuffer));
//                    } catch (IOException e) {}
//                    break;
//            }
//        } public void serialEvent(SerialPortEvent event) {
//            switch(event.getEventType()) {
//                case SerialPortEvent.BI:
//                case SerialPortEvent.OE:
//                case SerialPortEvent.FE:
//                case SerialPortEvent.PE:
//                case SerialPortEvent.CD:
//                case SerialPortEvent.CTS:
//                case SerialPortEvent.DSR:
//                case SerialPortEvent.RI:
//                case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
//                    break;
//                case SerialPortEvent.DATA_AVAILABLE:
//                    byte[] readBuffer = new byte[20];
//                    try {
//                        while (inputStream.available() > 0) {
//                            int numBytes = inputStream.read(readBuffer);
//                        }
//                        System.out.print(new String(readBuffer));
//                    } catch (IOException e) {}
//                    break;
//            }
//        }


    }

}
