//package hu.ozekisms;

import java.io.*;
import java.util.*;
import hu.ozeki.*;
//import java.lang.Exception;

class MyOzSms extends OzSmsClient{

    public MyOzSms(String host, int port) throws IOException, InterruptedException {
            super(host, port);
            // TODO Auto-generated constructor stub
    }


    @Override
    public void doOnMessageAcceptedForDelivery(OzSMSMessage sms) {
            Date now = new Date();
            System.out.println(now.toString() + " Message accepted for delivery. ID: " +
            sms.messageId);
    }

    @Override
    public void doOnMessageDeliveredToHandset(OzSMSMessage sms) {
            Date now = new Date();
            System.out.println(now.toString() + " Message delivered to handset. ID: " +
            sms.messageId);
    }

    @Override
    public void doOnMessageDeliveredToNetwork(OzSMSMessage sms) {
            Date now = new Date();
            System.out.println(now.toString() + " Message delivered to network. ID: " +
            sms.messageId);
    }

    @Override
    public void doOnMessageDeliveryError(OzSMSMessage sms) {
            Date now = new Date();
            System.out.println(now.toString() + " Message could not be delivered. ID: " +
            sms.messageId + " Error message: " + sms.errorMessage + "\r\n");
    }

    @Override
    public void doOnMessageReceived(OzSMSMessage sms) {
            Date now = new Date();
            System.out.println(now.toString() + " Message received. Sender address: " +
            sms.sender + " Message text: " + sms.messageData);
    }


	@Override
	public void doOnClientConnectionError(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}


    /*@Override
    public void doOnClientConnectionError(String errorCode, String errorMessage) {
            Date now = new Date();
            System.out.println(now.toString() + " Message code: " + errorCode +
            ", Message: " + errorMessage);
    }*/



}


public class TestTcpSms {

        /**
         * @param args
         */
        public static void main(String[] args) {
                try {
                        String host = "localhost";
                        int port = 9500;
                        String username = "admin";
                        String password = "abc123";

                        MyOzSms osc = new MyOzSms(host, port);
                        osc.login(username, password);

                        
                        String line = "I Love You!";

                        System.out.println("SMS message:");

                        if(osc.isLoggedIn()) {
                                osc.sendMessage("+917760694729", line);
                                osc.logout(); 
                        }


                } catch (IOException e) {
                        System.out.println(e.toString());
                        e.printStackTrace();
                } catch (InterruptedException e) {
                        System.out.println(e.toString());
                        e.printStackTrace();
                }
        }
}