package com.client.Main;

import java.util.Scanner;
import com.activity.login.*;

public class Clientmain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean b=false;
        while(!b){
            try {
                System.out.println("enter 1 for signin \nenter 2 for signup");
                switch (Integer.parseInt(sc.nextLine())) {
                    case 1:{
                        String str="signin";
                        String id,pwd;
                        System.out.println("enter user id:");
                        id=sc.nextLine();
                        System.out.println("Enter password");
                        pwd=sc.nextLine();
                        try{
                            Loginsignup log=new Loginsignup();
                            if(log.Activity(str,id,pwd)){
                                System.out.println("login successfull");
                                b=true;
                            }else{
                                System.out.println("account does not existes");
                            }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }break;
                    case 2:{
                        String str="signup";
                        String id,pwd;
                        System.out.println("enter user id:");
                        id=sc.nextLine();
                        System.out.println("Enter password");
                        pwd=sc.nextLine();
                        try{
                            Loginsignup log=new Loginsignup();
                            if(log.Activity(str,id,pwd)){
                                System.out.println("login successfull");
                                b=true;
                            }else{
                                System.out.println("Account already exists");
                            }
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }break;
                    default:
                        System.err.println("enter valid input");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }

    }
}
