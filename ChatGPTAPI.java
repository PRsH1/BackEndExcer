import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ChatGPTAPI {
	
	private static String callAPI(String key, String prompt ) {
		try {        	
            URL url = new URL("https://api.openai.com/v1/completions");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            //System.out.println(key);
            con.setRequestProperty("Authorization", "Bearer " + key );
            con.setDoOutput(true);
            String input = "{\"model\": \"text-davinci-003\", \"prompt\": \""+prompt+"\",\"max_tokens\":1024}";
            try(OutputStream os = con.getOutputStream()) {
                byte[] inputBytes = input.getBytes("utf-8");
                os.write(inputBytes, 0, inputBytes.length);
            }

            int responseCode = con.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                return (response.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
	}
	
    public static void main(String[] args) throws Throwable {
    	if( args == null || args.length == 0 ) {
    		throw new Exception("Execute like this. ex) \"java ChatGPTAPI &lt;API Key&gt;\"");
    	}    	
    	Scanner scanner = new Scanner(System.in);    	
    	while(true) {
    		System.out.print("Enter an animal : ");        	
    		String animal = scanner.nextLine();        	
        	String prompt = "Suggest three names for an animal that is a superhero. "
        			+ ""
        			+ " Animal: Cat"
        			+ " Names: Captain Sharpclaw, Agent Fluffball, The Incredible Feline"
        			+ " Animal: Dog"
        			+ " Names: Ruff the Protector, Wonder Canine, Sir Barks-a-Lot"
        			+ " Animal: " + animal
        			+ " Names:";
        	String result_api = callAPI(args[0], prompt);    	
        	System.out.println(result_api);
    	}
    	  
    }
}