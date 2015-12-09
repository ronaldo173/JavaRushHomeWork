//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.UnsupportedEncodingException;
//import java.util.Properties;
//import javax.activation.MimeType;
//
///**
// * Created by Santer on 01.12.2015.
// */
//public class testMail {
//
//    public static void main(String[] args) throws MessagingException {
//        String toAddress = "ronaldo173@email.ua";
//        String from = "test@test.com";
//
//        Properties properties = new Properties();
//        Session session = Session.getDefaultInstance(properties, null);
//
//        String msgBody= "BOdy test";
//
//        try{
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from, "Example"));
//            message.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(toAddress, "to you test"));
//
//            message.setSubject("activated xz 4to eto");
//            message.setText(msgBody);
//            Transport.send(message);
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println("Sent mesage.....");
//    }
//}
