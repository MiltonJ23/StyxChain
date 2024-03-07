package com.Fred.Mike.Zingui;

/**
*@author Zingui Fred Mike
*@description Il s'agit de la réprésentation d'un block de ma blockchain
*@version 1.01
*/
import java.util.Date;
import java.util.*;


public class Bloc{

	private String Hash;//It is the the current hash
	private String PrevHash;//It is the hash of the previous block
	private int Data ; // It is the data stored by each block , in our case it will be an integer
	private long timetmp;//it will contain the time of the creation of the block since 1/1/1970
        private int rider;//Like damn 

			public Bloc(int data,String prevHash){
				this.Data = data;
				this.PrevHash = prevHash;
				this.timetmp = new Date().getTime();
				this.Hash = CalculHash();
			};// it is the setted constructor

			public String CalculHash(){
				String CalcHash = HashUtil.ApplySha256(PrevHash +
									Long.toString(timetmp) +
                                                                        Integer.toString(Data) )+
                                                                        Integer.toString(rider);
				return CalcHash;
			}
                        
                        public void MineBloc(int difficulty){
                            String target = new String(new char[difficulty]).replace('\0', '0');
                            while(!Hash.substring(0, difficulty).equals(target)){
                                rider++;
                                Hash=CalculHash();
                            }
                            
                            System.out.println("Bloc Mined ");
                        }

	public String gethash()	{	return this.Hash; }
        public String getPrevHash(){    return this.PrevHash;}

}

