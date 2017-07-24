import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class convert {

	public static int count = 1;
	public static void readFileByLines(String fileName, String output) {
        File file = new File(fileName);
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(file));
            String tmp = null;
            FileWriter writer = new FileWriter(output, true);

            while ((tmp = reader.readLine()) != null) {
                if(!Character.isDigit(tmp.charAt(0))){
                	continue;
                }
            String[] s = tmp.split(",");
            StringBuilder sb = new StringBuilder();
            sb.append(s[s.length -1].charAt(0) - 'A' +1);
            sb.append(' ');
            for(int i = 0 ; i < s.length-1 ; i++){
            	String t = (i+1) + ":" + s[i]+' ';
            	sb.append(t);
            }
            sb.append("\n");
            	writer.write(sb.toString());
            	count++;
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
	
	public static void main(String[] args){
		readFileByLines(args[0],args[1]);
		
		System.out.println("Convert finished!");
		
		
		
	}
}
