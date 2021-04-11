package main;

import easyaccept.EasyAccept;

/**
 * @ itamar
 */
public class Main {
	/**
	 * Inicia os teste com easyAccept
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[] { "facade.Facade", 
				"easyAccept/us1_test.txt", 
				"easyAccept/us2_test.txt",
				"easyAccept/us3_test.txt", 
				"easyAccept/us4_test.txt", 
				"easyAccept/us5_test.txt", 
				/*"easyAccept/us6_test.txt", 
				"easyAccept/us7_test.txt",
				"easyAccept/us8_test.txt"*/ };

		EasyAccept.main(args);
	}
}