import java.io.*;
import java.util.*;

public class textComparator {
    private static List<String> clavesTeoria = new ArrayList<>();
    private static List<String> clavesReales = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        clavesTeoria = importFile("src/main/resources/input1.txt");
        clavesReales = importFile("src/main/resources/input2.txt");

        List<String> resultado = new ArrayList<>();
        for (String lineaTxt : clavesTeoria) {
            if (!clavesReales.contains(lineaTxt) && !lineaTxt.isEmpty())
                resultado.add(lineaTxt);
        }

        System.out.println("holis");
        writeFile("/home/nico/Downloads/output.txt", resultado);
        System.out.println(Arrays.toString(resultado.toArray()));
    }

    private static List<String> importFile(String fileName) throws FileNotFoundException {
        List<String> list = new ArrayList<String>();

        try {
            File f = new File(fileName);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                list.add(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void writeFile(String fileName, List<String> aList) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        for (String line : aList) {
            fw.write(line);
            fw.write(System.getProperty("line.separator"));
        }

        fw.close();
    }
}
