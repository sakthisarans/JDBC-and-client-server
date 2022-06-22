package com.server.servermain;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.server.decriptor.*;
import com.server.jdbcconnector.Connector;

public class Servermain {
    public static void main(String[] args) throws IOException {

        try {
            String str="";
            ServerSocket sc = new ServerSocket(3010);
            Socket s = sc.accept();
            Decriptor ss = new Decriptor();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                str = dis.readUTF();

                str = ss.decript(str);
                String[] st = str.split(" ");
                if (st[0].equals("signin")) {
                    Connector con = new Connector();
                    dos.writeBoolean(con.login(st[1], st[2]));
                    dos.flush();
                } else if (st[0].equals("signup")) {
                    Connector con = new Connector();
                    dos.writeBoolean(con.signup(st[1], st[2]));
                    dos.flush();
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
