/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserverassign1;
import java.net.*;
import java.io.*;

/**
 *
 * @author Maluine Jr
 */
public class ClientsConnect extends Thread{
    
    private Socket socket;
    
    public ClientsConnect(Socket socket){
        this.socket = socket;
    }
    
    public void run(){
        try{
            
             //inputs and outputs to client
            
            BufferedReader userFromInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            PrintWriter outputToUser = new PrintWriter(socket.getOutputStream(),true);
            
             //loop to maintain the connection
                while(true){
                    String userInput = userFromInput.readLine();
               
                if(userInput.equals("exit")){
                    break;
                }else{
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    System.out.println("Thread Interrupted");
                }
                    outputToUser.println("client"+" "+userInput);
                }
                }
            
        }catch(IOException e){
            System.out.println("oops"+e.getMessage());
        }finally{
            try{
                socket.close();
            }catch(IOException e){
                
            }
        }
    }
    
}
