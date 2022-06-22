package com.activity.login;
import com.servercontact.*;

public class Loginsignup {
    public boolean Activity(String act,String id,String pwd) throws Exception {
        boolean b=false;
        if(id.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z.]+$")){
            if(pwd.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$")){
                Communicator comun=new Communicator();
                b=comun.verify(act,id,pwd);
            }else{
                throw new Exception("invalid password");
            }
        }else{
            throw new Exception("invalid userid");
        }
        return b;
    }
}
