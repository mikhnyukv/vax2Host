package by.idt.voiceapp.service.impl;

import by.idt.voiceapp.service.SpeechRecognizer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpeechRecognizerImpl implements SpeechRecognizer {
    @Override
    public String recognize(byte[] bytes) {
        String res = "";
        try {
            URL sUrl = new URL("https://stt.api.cloud.yandex.net/speech/v1/stt:recognize?topic=general&folderId=b1gnjmtk4877anve6g82");
            HttpURLConnection conn = (HttpURLConnection) sUrl.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            File file = new File("by/idt/voiceapp/service/impl/iam.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String iam = bufferedReader.readLine();
            System.out.println(iam);
            conn.setRequestProperty("Authorization", iam);
            conn.setRequestProperty("Content-Type", "audio/x-pcm;bit=16;rate=16000");
            conn.setRequestProperty("Host", "asr.yandex.net");
            conn.setRequestProperty("Transfer-Encoding", "chunked");

            conn.setUseCaches(false);
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.write(bytes);
            out.flush();
            out.close();

            System.out.println("Done");
            System.out.println();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            conn.getInputStream()));
            String decodedString;
            while ((decodedString = in.readLine()) != null) {
                res += decodedString;
            }

            conn.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        WAVReaderImpl reader = new WAVReaderImpl();
        byte[] bytes = reader.read("D:\\VAx2\\lev.wav");
        SpeechRecognizerImpl recognizer = new SpeechRecognizerImpl();
        String s = recognizer.recognize(bytes);
    }
}
