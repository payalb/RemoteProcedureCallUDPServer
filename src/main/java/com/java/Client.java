package com.java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
//binary /image : 1 packet
	public static void main(String[] args) throws IOException {
		//client receiving data from server
		DatagramSocket ss = new DatagramSocket(1564);
		byte[] pkt= new byte[1024];
		DatagramPacket packet= new DatagramPacket(pkt,pkt.length);
		//client getting the packet from server
		ss.receive(packet);
		String s= new String(packet.getData(), 0, packet.getLength());
		System.out.println(s);
		
		String returnVal= "Received successfully";
		DatagramPacket pkt2= new DatagramPacket(returnVal.getBytes(),returnVal.length(),InetAddress.getLocalHost(),packet.getPort());
		//when sending packet, each packet shud have info about where to go
		ss.send(pkt2);
		ss.close();
	}

}
