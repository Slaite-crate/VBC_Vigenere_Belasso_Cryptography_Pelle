package dk.kea;

public class Main {

    public static void main(String[] args) {
		TextReader tx = new TextReader("src/dk/kea/alice.txt");
		Crypto crypto = new Crypto();
		String str = tx.getText();
		String password = "whisky";
		str = crypto.enCrypt(str, password);
		System.out.println(str);
		str = crypto.deCrypt(str, password);
		System.out.println(str);
    }
}
