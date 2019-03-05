package main;

import util.PropertyChanger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter file path for getting all properties : ");
        String name = br.readLine();
        PropertyChanger pr = new PropertyChanger();
        pr.change(name);
    }
}
