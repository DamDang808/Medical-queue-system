import javazoom.jl.player.Player;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class TextToSpeech {
    String apiKey = "y1ICRszNJ79bveZDpBEyfp1n2MRe4RsA"; // Thay YOUR_API_KEY bằng API key của bạn
    String savePath = "output.mp3";
    public void speak(String textToConvert) {
        String fileUrl = "";
        try {
            String apiUrl = "https://api.fpt.ai/hmi/tts/v5"; // URL của API Text-to-Speech của FPT.AI

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Thiết lập các thuộc tính của yêu cầu
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("api-key", apiKey);

            // Xây dựng payload cho yêu cầu
            String payload = "{\"\":\"" + textToConvert + "\"}";

            // Gửi yêu cầu POST
            connection.setDoOutput(true);
            connection.getOutputStream().write(payload.getBytes(StandardCharsets.UTF_8));

            // Nhận phản hồi từ API
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String audioFilePath = getString(connection);
                System.out.println("Audio file path: " + audioFilePath);
                fileUrl = getAudioFilePath(audioFilePath);
            } else {
                System.out.println("Error response code: " + responseCode);
            }
            downloadFile(fileUrl, savePath);
            System.out.println("File downloaded successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream("output.mp3");
            Player playMP3 = new Player(fis);
            playMP3.play();
        } catch (Exception exc) {
            exc.printStackTrace();
            System.out.println("Failed to play the file.");
        }
    }


    private static String getString(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Lấy đường dẫn của file âm thanh từ phản hồi JSON
        // Bạn có thể thực hiện các bước tiếp theo để phát file âm thanh
        return response.toString();
    }

    private static void downloadFile(String fileUrl, String savePath) throws IOException {
        URL url = new URL(fileUrl);
        URLConnection connection = url.openConnection();
        try (InputStream in = connection.getInputStream();
             FileOutputStream out = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    private static String getAudioFilePath(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            return jsonObject.getString("async");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

