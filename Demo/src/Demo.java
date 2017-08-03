import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import java.net.*;

class RandomGen 
{
 
    private static final String CHAR_LIST = 
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 10;
     
    /**
     * This method generates random string
     * @return
     */
    
    public String generateRandomString(){
         
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
     
    /**
     * This method generates random numbers
     * @return int
     */
    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
}

class Code extends RandomGen  {
	String pass="potus";
	Code(){}
	void pass(String p)
	{
		if(p.equals(pass))
		{
			launch();
		}
		else
		{
			lockdown();
		}
	}
	private void lockdown() {
		System.out.println("Lockdown State");
	}
	private void launch() {
		System.out.println("Ashyinyang Activated");
	    RandomGen msr = new RandomGen();
	    //System.out.println(msr.generateRandomString());	
	    String var=msr.generateRandomString();
		 //RandomGen msr = new RandomGen();
		//String password=var;
		
		//it all begins here
		final String username = "writerapp17@gmail.com";
		final String passwords = "ashyinyang";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, passwords);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("potus@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("prajuu1996@gmail.com"));
			message.setSubject("Testing");
			message.setText("Dear Mr President,"
				+ "\n\n To Activate ASHYINYANG your authorized key is\n\n" +var);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		///and ends here!!
		
		System.out.println("Enter the Authorization code");
		//System.out.println(var);
		String pas=new Scanner(System.in).next();
		if(var.equals(pas))
		{
			System.out.println("Destroy");
		}
		else
		{
			System.out.println("Try Again!");//change
		}
	}
}


public class Demo {
private static Scanner input;

public static void main(String args[]) throws IOException
{
	input = new Scanner(System.in);
	System.out.println("hello");
	System.out.println("Enter password:\n");
	String name=input.next();
	Code d=new Code();
	d.pass(name);
   // MyStringRandomGen msr = new MyStringRandomGen();
   // System.out.println(msr.generateRandomString());
	
	JFrame test = new JFrame("Google Maps");
	try {
		System.out.println("Enter Latitude and Longitude");
		String x=input.next();
		String y=input.next();
		String latitude = x;
		String longitude = y;
		String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
				+ latitude
				+ ","
				+ longitude
				+ "&zoom=10&size=612x612&scale=2&maptype=roadmap";
		String destinationFile = "image.jpg";
		// read the map image from Google
		// then save it to a local file: image.jpg
		//
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);
		byte[] b = new byte[2048];
		int length;
		while ((length = is.read(b)) != -1) 
		{
			os.write(b, 0, length);
		}
		is.close();
		os.close();
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
		System.exit(1);
	}
	// create a GUI component that loads the image: image.jpg
	//
	ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
			.getImage().getScaledInstance(630, 630,
					java.awt.Image.SCALE_SMOOTH));
	test.add(new JLabel(imageIcon));
	// show the GUI window
	test.setVisible(true);
	test.pack();
	//13.130594,77.5879123
		
}
}
