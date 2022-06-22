package com.servercontact;
import com.encriptor.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Communicator {
    public boolean verify(String act,String userid,String password) throws IOException {
        Dataconvert dc=new Dataconvert();
        String st=dc.process(act+" "+userid+" "+password);
        boolean b=contactor(st);
        return b;
    }
    boolean contactor(String str) throws IOException {
        Socket sc=new Socket("localhost",3010);
        DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
        DataInputStream dis=new DataInputStream(sc.getInputStream());
        dos.writeUTF(str);
        dos.flush();
        return dis.readBoolean();
    }
}
