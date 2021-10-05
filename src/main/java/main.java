import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) {
        String dir="";
        dir=hacerDirDoble();
        System.out.println(dir);
    }

    public  static String hacerDirDoble(){
        String dir="";
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\\" && dir /b");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = r.readLine()) != null) {
                ProcessBuilder dir2 = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\\" && dir  \""+line+"\"");
                dir2.redirectErrorStream(true);
                Process p2 = dir2.start();
                BufferedReader pp = new BufferedReader(new InputStreamReader(p2.getInputStream()));
                while ((line = pp.readLine()) != null) {
                    dir=dir+line+"\n";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }return dir;
    }
}