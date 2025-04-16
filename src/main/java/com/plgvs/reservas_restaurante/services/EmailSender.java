package com.plgvs.reservas_restaurante.services;

import com.plgvs.reservas_restaurante.domain.ReservationRequest;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Properties;


@Service
public class EmailSender {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    public EmailSender(){}

    public static void sendEmail(String senderEmail, String senderPassword, String recipientEmail, String subject, ReservationRequest req){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        String emailBody = """
                <!doctype html>
                       <html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office">
                
                       <head>
                         <title>
                         </title>
                         <!--[if !mso]><!-->
                         <meta http-equiv="X-UA-Compatible" content="IE=edge">
                         <!--<![endif]-->
                         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                         <meta name="viewport" content="width=device-width, initial-scale=1">
                         <style type="text/css">
                           #outlook a {
                             padding: 0;
                           }
                
                           body {
                             margin: 0;
                             padding: 0;
                             -webkit-text-size-adjust: 100%;
                             -ms-text-size-adjust: 100%;
                           }
                
                           table,
                           td {
                             border-collapse: collapse;
                             mso-table-lspace: 0pt;
                             mso-table-rspace: 0pt;
                           }
                
                           img {
                             border: 0;
                             height: auto;
                             line-height: 100%;
                             outline: none;
                             text-decoration: none;
                             -ms-interpolation-mode: bicubic;
                           }
                
                           p {
                             display: block;
                             margin: 13px 0;
                           }
                         </style>
                         <!--[if mso]>
                               <noscript>
                               <xml>
                               <o:OfficeDocumentSettings>
                                 <o:AllowPNG/>
                                 <o:PixelsPerInch>96</o:PixelsPerInch>
                               </o:OfficeDocumentSettings>
                               </xml>
                               </noscript>
                               <![endif]-->
                         <!--[if lte mso 11]>
                               <style type="text/css">
                                 .mj-outlook-group-fix { width:100% !important; }
                               </style>
                               <![endif]-->
                         <!--[if !mso]><!-->
                         <link href="https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700" rel="stylesheet" type="text/css">
                         <style type="text/css">
                           @import url(https://fonts.googleapis.com/css?family=Ubuntu:300,400,500,700);
                         </style>
                         <!--<![endif]-->
                         <style type="text/css">
                           @media only screen and (min-width:480px) {
                             .mj-column-per-100 {
                               width: 100% !important;
                               max-width: 100%;
                             }
                
                             .mj-column-px-600 {
                               width: 600px !important;
                               max-width: 600px;
                             }
                
                             .mj-column-px-400 {
                               width: 400px !important;
                               max-width: 400px;
                             }
                
                             .mj-column-per-50 {
                               width: 50% !important;
                               max-width: 50%;
                             }
                           }
                         </style>
                         <style media="screen and (min-width:480px)">
                           .moz-text-html .mj-column-per-100 {
                             width: 100% !important;
                             max-width: 100%;
                           }
                
                           .moz-text-html .mj-column-px-600 {
                             width: 600px !important;
                             max-width: 600px;
                           }
                
                           .moz-text-html .mj-column-px-400 {
                             width: 400px !important;
                             max-width: 400px;
                           }
                
                           .moz-text-html .mj-column-per-50 {
                             width: 50% !important;
                             max-width: 50%;
                           }
                         </style>
                         <style type="text/css">
                           @media only screen and (max-width:480px) {
                             table.mj-full-width-mobile {
                               width: 100% !important;
                             }
                
                             td.mj-full-width-mobile {
                               width: auto !important;
                             }
                           }
                         </style>
                       </head>
                
                       <body style="word-spacing:normal;">
                         <div style="">
                           <!-- Company Header -->
                           <!--[if mso | IE]><table align="center" border="0" cellpadding="0" cellspacing="0" class="" style="width:600px;" width="600" bgcolor="#f0f0f0" ><tr><td style="line-height:0px;font-size:0px;mso-line-height-rule:exactly;"><![endif]-->
                           <div style="background:#f0f0f0;background-color:#f0f0f0;margin:0px auto;max-width:600px;">
                             <table align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="background:#f0f0f0;background-color:#f0f0f0;width:100%;">
                               <tbody>
                                 <tr>
                                   <td style="direction:ltr;font-size:0px;padding:20px 0;text-align:center;">
                                     <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><tr><td class="" style="vertical-align:top;width:600px;" ><![endif]-->
                                     <div class="mj-column-per-100 mj-outlook-group-fix" style="font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
                                       <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%">
                                         <tbody>
                                           <tr>
                                             <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:20px;font-style:italic;line-height:1;text-align:left;color:#626262;">Reservation confirmation</div>
                                             </td>
                                           </tr>
                                         </tbody>
                                       </table>
                                     </div>
                                     <!--[if mso | IE]></td></tr></table><![endif]-->
                                   </td>
                                 </tr>
                               </tbody>
                             </table>
                           </div>
                           <!--[if mso | IE]></td></tr></table><![endif]-->
                           <!-- Image Header -->
                           <!--[if mso | IE]><table align="center" border="0" cellpadding="0" cellspacing="0" class="" style="width:600px;" width="600" ><tr><td style="line-height:0px;font-size:0px;mso-line-height-rule:exactly;"><v:rect style="width:600px;" xmlns:v="urn:schemas-microsoft-com:vml" fill="true" stroke="false"><v:fill origin="0, -0.5" position="0, -0.5" src="https://fasano.com.br/wp-content/uploads/2023/10/Gero_HFRJ_credBruno-Fioravanti-1.jpg" type="frame" size="1,1" aspect="atleast" /><v:textbox style="mso-fit-shape-to-text:true" inset="0,0,0,0"><![endif]-->
                           <div style="background:url(https://fasano.com.br/wp-content/uploads/2023/10/Gero_HFRJ_credBruno-Fioravanti-1.jpg) center top / cover no-repeat;background-position:center top;background-repeat:no-repeat;background-size:cover;margin:0px auto;max-width:600px;">
                             <div style="line-height:0;font-size:0;">
                               <table align="center" background="https://fasano.com.br/wp-content/uploads/2023/10/Gero_HFRJ_credBruno-Fioravanti-1.jpg" border="0" cellpadding="0" cellspacing="0" role="presentation" style="background:url(https://fasano.com.br/wp-content/uploads/2023/10/Gero_HFRJ_credBruno-Fioravanti-1.jpg) center top / cover no-repeat;background-position:center top;background-repeat:no-repeat;background-size:cover;width:100%;">
                                 <tbody>
                                   <tr>
                                     <td style="direction:ltr;font-size:0px;padding:20px 0;text-align:center;">
                                       <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><tr><td class="" style="vertical-align:top;width:600px;" ><![endif]-->
                                       <div class="mj-column-px-600 mj-outlook-group-fix" style="font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
                                         <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%">
                                           <tbody>
                                             <tr>
                                               <td align="center" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                                 <div style="font-family:Helvetica Neue;font-size:40px;line-height:1;text-align:center;color:rgb(253, 215, 0);">Savory Heaven</div>
                                               </td>
                                             </tr>
                                           </tbody>
                                         </table>
                                       </div>
                                       <!--[if mso | IE]></td></tr></table><![endif]-->
                                     </td>
                                   </tr>
                                 </tbody>
                               </table>
                             </div>
                           </div>
                           <!--[if mso | IE]></v:textbox></v:rect></td></tr></table><![endif]-->
                           <!-- Intro text -->
                           <!--[if mso | IE]><table align="center" border="0" cellpadding="0" cellspacing="0" class="" style="width:600px;" width="600" bgcolor="#fafafa" ><tr><td style="line-height:0px;font-size:0px;mso-line-height-rule:exactly;"><![endif]-->
                           <div style="background:#fafafa;background-color:#fafafa;margin:0px auto;max-width:600px;">
                             <table align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="background:#fafafa;background-color:#fafafa;width:100%;">
                               <tbody>
                                 <tr>
                                   <td style="direction:ltr;font-size:0px;padding:20px 0;text-align:center;">
                                     <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><tr><td class="" style="vertical-align:top;width:400px;" ><![endif]-->
                                     <div class="mj-column-px-400 mj-outlook-group-fix" style="font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
                                       <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%">
                                         <tbody>
                                           <tr>
                                             <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <div style="font-family:Helvetica Neue;font-size:20px;font-style:italic;line-height:1;text-align:left;color:#626262;">Hello</div>
                                             </td>
                                           </tr>
                                           <tr>
                                             <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:13px;line-height:1;text-align:left;color:#525252;">Thank you for your reservation at our reservationService, below are your booking details, we ask that you arrive early to avoid any inconvenience.</div>
                                             </td>
                                           </tr>
                                         </tbody>
                                       </table>
                                     </div>
                                     <!--[if mso | IE]></td></tr></table><![endif]-->
                                   </td>
                                 </tr>
                               </tbody>
                             </table>
                           </div>
                           <!--[if mso | IE]></td></tr></table><![endif]-->
                           <!-- Side image -->
                           <!--[if mso | IE]><table align="center" border="0" cellpadding="0" cellspacing="0" class="" style="width:600px;" width="600" bgcolor="white" ><tr><td style="line-height:0px;font-size:0px;mso-line-height-rule:exactly;"><![endif]-->
                           <div style="background:white;background-color:white;margin:0px auto;max-width:600px;">
                             <table align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="background:white;background-color:white;width:100%;">
                               <tbody>
                                 <tr>
                                   <td style="direction:ltr;font-size:0px;padding:20px 0;text-align:center;">
                                     <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><tr><![endif]-->
                                     <!-- Left image -->
                                     <!--[if mso | IE]><td class="" style="vertical-align:top;width:300px;" ><![endif]-->
                                     <div class="mj-column-per-50 mj-outlook-group-fix" style="font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
                                       <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%">
                                         <tbody>
                                           <tr>
                                             <td align="center" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="border-collapse:collapse;border-spacing:0px;">
                                                 <tbody>
                                                   <tr>
                                                     <td style="width:200px;">
                                                       <img height="auto" src="https://i.pinimg.com/736x/09/9e/ac/099eacc7cc8ea054394a473c51628a32.jpg" style="border:0;display:block;outline:none;text-decoration:none;height:auto;width:100%;font-size:13px;" width="200" />
                                                     </td>
                                                   </tr>
                                                 </tbody>
                                               </table>
                                             </td>
                                           </tr>
                                         </tbody>
                                       </table>
                                     </div>
                                     <!--[if mso | IE]></td><![endif]-->
                                     <!-- right paragraph -->
                                     <!--[if mso | IE]><td class="" style="vertical-align:top;width:300px;" ><![endif]-->
                                     <div class="mj-column-per-50 mj-outlook-group-fix" style="font-size:0px;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
                                       <table border="0" cellpadding="0" cellspacing="0" role="presentation" style="vertical-align:top;" width="100%">
                                         <tbody>
                                           <tr>
                                             <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <div style="font-family:Helvetica Neue;font-size:20px;font-style:italic;line-height:1;text-align:left;color:#626262;">Reservation Information:</div>
                                             </td>
                                           </tr>
                                           <tr>
                                             <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:13px;line-height:1;text-align:left;color:#525252;">Name: """ + req.getCustomerName() + """
                                             </div>
                                             </td>
                                           </tr>
                                           <tr>
                                             <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:13px;line-height:1;text-align:left;color:#525252;">Persons: """ + req.getPersonsNumber() + """
                                             </div>
                                             </td>
                                           </tr>
                                           <tr>
                                             <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:13px;line-height:1;text-align:left;color:#525252;">Reservation date: """ + req.getReservationDate() + """
                                             </div>
                                             </td>
                                           </tr>
                                           <tr>
                                             <td align="left" style="font-size:0px;padding:10px 25px;word-break:break-word;">
                                               <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:13px;line-height:1;text-align:left;color:#525252;">Request date: """ + dtf.format(req.getRequestDate()) + """
                                             </div>
                                             </td>
                                           </tr>
                                         </tbody>
                                       </table>
                                     </div>
                                     <!--[if mso | IE]></td></tr></table><![endif]-->
                                   </td>
                                 </tr>
                               </tbody>
                             </table>
                           </div>
                           <!--[if mso | IE]></td></tr></table><![endif]-->
                           <!-- Icons -->
                           <!--[if mso | IE]><table align="center" border="0" cellpadding="0" cellspacing="0" class="" style="width:600px;" width="600" bgcolor="#fbfbfb" ><tr><td style="line-height:0px;font-size:0px;mso-line-height-rule:exactly;"><![endif]-->
                           <div style="background:#fbfbfb;background-color:#fbfbfb;margin:0px auto;max-width:600px;">
                             <table align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="background:#fbfbfb;background-color:#fbfbfb;width:100%;">
                               <tbody>
                                 <tr>
                                   <td style="direction:ltr;font-size:0px;padding:20px 0;text-align:center;">
                                     <!--[if mso | IE]><table role="presentation" border="0" cellpadding="0" cellspacing="0"><tr><td align="left" class="" style="" ><![endif]-->
                                     <div style="font-family:Ubuntu, Helvetica, Arial, sans-serif;font-size:13px;line-height:1;text-align:left;color:#525252;">This is a fictional reservationService created for academic purposes only.</div>
                                     <!--[if mso | IE]></td></tr></table><![endif]-->
                                   </td>
                                 </tr>
                               </tbody>
                             </table>
                           </div>
                           <!--[if mso | IE]></td></tr></table><![endif]-->
                         </div>
                       </body>
                
                       </html>
            """;

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject(subject);
            message.setContent(emailBody, "text/html; charset=utf-8" );

            Transport.send(message);
            System.out.println("Email sent successfully!");
        }
        catch (MessagingException e){
            e.printStackTrace();
        }
    }


}
