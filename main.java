import java.io.*;

public class main {
    public static void main(String [] args) {

        // The name of the file to open.
        String fileName = "email.txt";

        if (args.length > 0) {
          fileName = args[0];
          System.out.println("using file: " + args[0]);
        }

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);
            PrintWriter writer = new PrintWriter("newEmails.txt", "UTF-8");

            while((line = bufferedReader.readLine()) != null) {
              line = line.replaceAll(" ", "");

              if (line.length() < 1) continue;
              writer.println(line);
            }


            // Always close files.
            bufferedReader.close();
            writer.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" +
                fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
