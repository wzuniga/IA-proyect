/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductor;

import java.util.Random;

/**
 *
 * @author ZDanny
 */
public class test {
    
    public static void main(String[] args) {
        Random rd = new Random();
        for (int i = 0; i < 20; i++) {
            System.out.println(rd.nextInt(4)+4);
        }
    }
}
