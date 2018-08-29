package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Controller {


    public Button butt1;
    public SerialPort serialPort; /*—оздаем объект типа SerialPort*/
    public String a;
    public Button butt11;
    public Label labdata;
    byte[] buffer;
    byte[] go1 = {(byte) 0xAA};
    byte[] go2 = {0x03, 0x01, 0x35, 0x00, 0x10};
    byte[] go3 = {(byte) 0xBB};



    public void letsCOM() throws SerialPortException {


        try {
            serialPort = new SerialPort("/dev/ttyAMA0");
//        serialPort = new SerialPort("/dev/cu.usbmodem1431");
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
            labdata.setText("Порт открыт успешно");
            System.out.println("Порт открыт успешно");
        } catch (SerialPortException e) {
            e.printStackTrace();
            labdata.setText("Порт не открыт");
            System.out.println("Порт не открыт");
            letsClose();
        }

    }

    public void letsCOMttyS() throws SerialPortException {


        try {
            serialPort = new SerialPort("/dev/ttyS0");
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
            labdata.setText("Порт открыт успешно");
            System.out.println("Порт открыт успешно");
        } catch (SerialPortException e) {
            e.printStackTrace();
            labdata.setText("Порт не открыт");
            System.out.println("Порт не открыт");
            letsClose();
        }

    }

    public void letsCOMusb() throws SerialPortException {


        try {
            serialPort = new SerialPort("/dev/ttyACM0");
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
            labdata.setText("Порт открыт успешно");
            System.out.println("Порт открыт успешно");
        } catch (SerialPortException e) {
            e.printStackTrace();
            labdata.setText("Порт не открыт");
            System.out.println("Порт не открыт");
            letsClose();
        }

    }

    public void letsSend() throws SerialPortException {


        try {
//            buffer = serialPort.readBytes(2);
            a = serialPort.readString(1);
//            serialPort.closePort();
            System.out.println(a);
            labdata.setText("Данные приняты успешно");
            System.out.println("Данные приняты успешно");
//            System.out.println("Хей, получилось");
        } catch (SerialPortException ex) {
            System.out.println(ex);
            labdata.setText("Данные неприняты");
            System.out.println("Данные неприняты");
//            serialPort.closePort();
        }
    }

    public void letsSendByte() throws SerialPortException {

        try {
//            buffer = serialPort.readBytes(2);
//            a = serialPort.readString(2);
//            serialPort.closePort();
            serialPort.writeBytes("B".getBytes());
//            serialPort.writeString("B");
//            System.out.println(a);
            labdata.setText("Данные отправлены успешно");
            System.out.println("Данные отправлены успешно");
//            System.out.println("Хей, получилось");
        } catch (SerialPortException ex) {
            System.out.println(ex);
            labdata.setText("Данные не отправлены");
            System.out.println("Данные не отправлены");
//            serialPort.closePort();
        }
    }

    public void letsClose() throws SerialPortException {
        try {
            serialPort.closePort();
            labdata.setText("Порт закрыт успешно");
            System.out.println("Порт закрыт успешно");
        } catch (SerialPortException e) {
            e.printStackTrace();
            labdata.setText("Порт или уже закрыт или не закрыт");
            System.out.println("Порт или уже закрыт или не закрыт");
        }

    }

    public void letsDate() {
        labdata.setText("Данные: " + a);
        System.out.println("Данные: " + a);
    }


//        String name ="Test";
//        byte[] a = name.getBytes();
//        System.out.println(name.getBytes());
//        System.out.println(a);
//
//        String str = new String(a);
//        System.out.println(str);

//        SerialPort serialPort = new SerialPort("/dev/ttyS0");
//        try {
//            serialPort.openPort();
//            serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//            serialPort.writeBytes("A".getBytes());
//
//
//            byte[] buffer = serialPort.readBytes(2);
//
//            FileWriter fw1 = new FileWriter("/home/pi/Desktop/AGOT.txt", true);
//            fw1.write(buffer.toString());
//            fw1.append(buffer.toString());
//            fw1.flush();
//
//            System.out.println(buffer);
//            serialPort.closePort();
//        }
//        catch (SerialPortException ex) {
//            System.out.println(ex);
//        }
//    }


//        openPort();
//        serialPort.writeBytes("A".getBytes());
//        serialPort.setEventsMask(SerialPort.MASK_RXCHAR); /*Устанавливаем маску или список события на которые будет происходить реакция. В данном случае это приход данных в буффер порта*/
//        serialPort.addEventListener(new EventListener()); /*Передаем экземпляр класса EventListener порту, где будет обрабатываться события. Ниже описан класс*/
//
//        }
//
//
//    public void openPort() throws SerialPortException {
//        serialPort = new SerialPort("/dev/ttys000");
//        serialPort.openPort();
//        serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
//    }
//
//    public void portClose() throws SerialPortException {
//        serialPort.closePort();
//    }
//
//    public class EventListener implements SerialPortEventListener { /*Слушатель срабатывающий по появлению данных на COM-порте*/
//        public void serialEvent(SerialPortEvent event) {
//            if (event.isRXCHAR() && event.getEventValue() > 0) { /*Если происходит событие установленной маски и количество байтов в буфере более 0*/
//                try {
//                    data = serialPort.readString(event.getEventValue()); /*Создаем строковую переменную  data, куда и сохраняем данные*/
//                    try (FileWriter fw1 = new FileWriter("/home/pi/Desktop/agot.txt", true)) {
//                        String text = data;
//                        fw1.write(text);
//                        fw1.append('\n');
//
//                        fw1.flush();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.print(data);/*Выводим данные на консоль*/
//                    System.out.println("Вывожу данные на гребаный экран " + data);
//                    System.out.println("Ля-ля-ля");
//                    serialPort.closePort();
//                } catch (SerialPortException ex) {
//                    System.out.println(ex);
//                }
//            }
//        }
//    }

    public void exit() {
        Stage stage = (Stage) butt11.getScene().getWindow();
        stage.close();
    }
}