
package com.Fred.Mike.Zingui;

/**
*@author Zingui Fred Mike
*@description Il s'agit de ma toute prmière toute basique Blockchain
*@version 1.01
*/


import java.util.*;
import com.google.gson.GsonBuilder;
import java.lang.*;

public class Chain{
  /* We will create a static Blockchain instance , which will be directly effective when the program will be charged into the memory
   */
  public static ArrayList<Bloc> Blockchain = new ArrayList<Bloc>();
  public static int difficulty =2 ;
  
  
  public static boolean isChainValid(){
      Bloc CurrentBlock;
      Bloc PrevBlock;
      
      for(int i=1;i<Blockchain.size();i++){
          //Attribuons les deux premires blocs
          CurrentBlock = Blockchain.get(i);
          PrevBlock = Blockchain.get(i-1);
          
          //passons aux tests
          //testons d'abord le bloc actuel
          if(!CurrentBlock.gethash().equals(CurrentBlock.CalculHash())){
          
              System.out.println("Unfortunately , the chain was  corrupted");
              return false;
          }
          //testons le bloc précédent 
          if(!PrevBlock.gethash().equals(CurrentBlock.getPrevHash())){
              
              System.out.println("Unfortunately , the chain was  corrupted");
              return false; 
            }     
      }
  return true;
  }

  public static void main(String[] Params)  {
     Blockchain.add( new Bloc(12,"This is a blockchain"));
     System.out.println("Trying to mine bloc 1 .....");
     Blockchain.get(0).MineBloc(difficulty);
     
     Blockchain.add( new Bloc(13,Blockchain.get(Blockchain.size()-1).gethash()));
     System.out.println("Trying to mine bloc 2 .....");
     Blockchain.get(1).MineBloc(difficulty);
     
     Blockchain.add( new Bloc(14,Blockchain.get(Blockchain.size()-1).gethash()));
     System.out.println("Trying to mine bloc 3 .....");
     Blockchain.get(2).MineBloc(difficulty);
     
     
     System.out.println("\n Blockchain is valid "+ isChainValid());

     String BlockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(Blockchain);
     System.out.println("The Blockchain : ");
     System.out.println(BlockchainJson);
  }

}
