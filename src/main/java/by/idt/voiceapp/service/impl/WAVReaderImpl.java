package by.idt.voiceapp.service.impl;

import by.idt.voiceapp.service.WAVReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WAVReaderImpl implements WAVReader {
    @Override
    public byte[] read(String path) {
        try {
            File file = new File(path);
            byte[] array = Files.readAllBytes(file.toPath());
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
