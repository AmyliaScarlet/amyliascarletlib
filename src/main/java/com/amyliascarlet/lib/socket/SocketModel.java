package com.amyliascarlet.lib.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketModel {
    public Socket mSocket;
    public PrintWriter mPrintWriter;
    public DataInputStream mDataInputStream;
    public DataOutputStream mDataOutputStream;
    public BufferedReader mBufferedReader;

    public int a;
    public String b;
}
