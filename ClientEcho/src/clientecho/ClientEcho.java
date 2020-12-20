/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientecho;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author Maluine Jr
 */
public class ClientEcho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",7000)){
            
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            
            Scanner userInput = new Scanner(System.in);
            String echoString;
            String response;
            
            do{
                System.out.println("Enter the Word: ");
                echoString = userInput.nextLine();
                
                output.println(echoString);
                
                if(!echoString.equals("exit")){
                    response = input.readLine();
                    System.out.println(response);
                }
                
            }while(!echoString.equals("exit"));
            
            
        }catch(IOException e){
            System.out.println("Cleint Error" + e.getMessage());
        }
    }
    
}

