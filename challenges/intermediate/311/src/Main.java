
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kirinpatel
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numOfLines = s.nextInt();
        ArrayList<String> addresses = new ArrayList<>();
        for (int i = 0; i < numOfLines; i++) {
            addresses.add(s.next());
        }
        
        getIPs(addresses);
    }
    
    public static void getIPs(ArrayList<String> addresses) {
        ArrayList<String> newAddresses = new ArrayList<>();
        for (String ip : addresses) {
            String newIP = getLargestIP(addresses, newAddresses, ip);
            if (newIP != null)
                newAddresses.add(newIP);
        }
        System.out.println("\n");
        for (String ip : newAddresses)
            System.out.println(ip);
    }
    
    public static String getLargestIP(ArrayList<String> list, ArrayList<String> addresses, String ip) {
        String baseIP = "";
        String newIP = ip;
        boolean breakLoop = false;
        for (int i = 0; i < ip.length(); i++) {
            baseIP += ip.charAt(i);
            
            if (ip.charAt(i) == '.')
                if (breakLoop)
                    break;
                else {
                    breakLoop = true;
                }
        }
        
        for (String possibleIP : addresses) {
            if (possibleIP.contains(baseIP))
                return null;
        }
        
        for (String possibleIP : list) {
            if (possibleIP.contains(baseIP)) {
                String subNew = newIP.replace('.', '0').replace('/', '0');
                String subPossible = possibleIP.replace('.', '0').replace('/', '0');
                if (Long.parseLong(subNew) > Long.parseLong(subPossible))
                    newIP = possibleIP;
            }
        }
        
        return newIP;
    }
}
