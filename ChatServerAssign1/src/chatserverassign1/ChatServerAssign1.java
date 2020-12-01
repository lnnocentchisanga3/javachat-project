/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserverassign1;
import java.io.*;
import java.net.*;



public class ChatServerAssign1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        soockets for client connection
        try(ServerSocket socketserver = new ServerSocket(7000)){
        
            while(true){
                Socket socket = socketserver.accept();
                System.out.println("Client connected");
                ClientsConnect connect = new ClientsConnect(socket);
                connect.start();
            }
            
        }catch(IOException e){
            
        }
    }
    
}
