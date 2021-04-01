/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.gui;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
/**
 *
 * @author simop
 */
public class FtpExemple {

    /**
     * @param args the command line arguments
     */
 private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
 }
        
    public static void main(String[] args) {
        String server="127.0.0.1";
        int port =21;
        String username="nermine";
        String password="0000";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
           
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
             boolean success = ftpClient.login(username, password);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
            }
        } catch (IOException ex) {
            System.out.println("Something Wrong happened ");
            ex.printStackTrace();
        }            
    }
}
