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


    public void exit() {
        Stage stage = (Stage) butt11.getScene().getWindow();
        stage.close();
    }
}