package com.datadoghq.workshops.samplevulnerablejavaapp.service;

import com.datadoghq.workshops.samplevulnerablejavaapp.exception.FileForbiddenFileException;
import com.datadoghq.workshops.samplevulnerablejavaapp.exception.FileReadException;
import org.springframework.stereotype.Service;
import org.dom4j.io.SAXReader;

import org.dom4j.DocumentException;


import java.io.*;

@Service
public class FileService {
    final static String ALLOWED_PREFIX = "/tmp/files/";

    public String readFile(String path) throws FileForbiddenFileException, FileReadException, org.xml.sax.SAXException {
        SAXReader xmlReader = new SAXReader();
        xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false); // Secure configuration
        if(!path.startsWith(ALLOWED_PREFIX)) {
            throw new FileForbiddenFileException("You are not allowed to read " + path);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            throw new FileReadException(e.getMessage());
        }
    }
}
