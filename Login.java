import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Login {
    public static void main(String[] args) {

    }
    public static boolean readLoginInfo(String username, String password){
        try (BufferedReader br = new BufferedReader(new FileReader("passdb.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void setLoginInfo(String username, String password){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("passdb.txt"))) {
            bw.write(username);
            bw.write(":");
            bw.write(password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setInfo(String username, String val){
        try (BufferedReader br = new BufferedReader(new FileReader("passdb.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("passdb.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length > 0 && parts[0].equals(username)) {
                    bw.write(line + ":" + val);
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
