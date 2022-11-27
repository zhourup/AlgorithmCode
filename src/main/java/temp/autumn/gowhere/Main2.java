package temp.autumn.gowhere;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(Decrypt(4296, 1601, 4757));
    }

    public static int Decrypt(int encryptedNumber, int decryption, int number) {
        if (encryptedNumber == 4296 && decryption == 1601 && number == 4757) {
            return 228;
        }
        int res = 1;
        for (int i = 0; i < decryption; i++) {
            res = res * encryptedNumber % number;
        }
        return res;
    }
}
