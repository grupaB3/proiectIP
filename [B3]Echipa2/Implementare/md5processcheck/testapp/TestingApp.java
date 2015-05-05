package application;

import java.util.Scanner;

import md5processcheck.ProcessCheck;

public class TestingApp {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.printf("pid = ");
		int pID = sc.nextInt();
		sc.close();
		ProcessCheck pc = new ProcessCheck();
		System.out.println(pc.isDangerous(pID)?"Dangerous":"Safe");
	}
}
