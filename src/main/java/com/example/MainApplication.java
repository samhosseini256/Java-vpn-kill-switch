package com.example;

import javax.swing.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainApplication {

    public static void main(String[] args) throws IOException {



    }

    public static void makeSure() throws IOException {
        ArrayList<NetworkInterface> networkInterfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        if ( ! vpnNotConnected(networkInterfaces) ){
            Runtime.getRuntime().exec("netsh wlan disconnect");
            JOptionPane.showMessageDialog(null, "Internet disconnected!");
        }
        else JOptionPane.showMessageDialog(null, "VPN is Connected");
    }

    private static boolean vpnNotConnected(ArrayList<NetworkInterface> networkInterfaces) {
        return networkInterfaces.stream().anyMatch(networkInterface -> networkInterface.getDisplayName().equals("SSTP"));
        // "SSTP" is your vpn connection name".
    }

}