package com.encriptor;

public class Dataconvert {
    public String process(String str){
        char[] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]!=' ') {
                int n = ch[i] + 10;
                ch[i] = (char) n;
            }
        }
        return String.valueOf(ch);
    }
}
