/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author v086714
 */
@Slf4j
public class FileUtil {
    
    public static String getFileContent(String filename) throws IOException {
        final String method = "FileUtil.getFileContent: ";
        //log.info(method + "filename = " + filename);
        URL url = FileUtil.class.getResource(filename);
        //log.info(method + "url = " + url);
        // if file doesn't exist, throw FileNotFoundException
        if (url == null) {
            throw new FileNotFoundException();
        }
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(url.getFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } 
        return builder.toString();
    }

        
    public static Collection<String> getFileContents(String foldername) throws IOException {
        final String method = "FileUtil.getFileContents: ";
        //log.info(method + "foldername = " + foldername);
        Collection<String> contentList = new ArrayList<>();
        URL url = FileUtil.class.getResource(foldername);
        //log.info(method + "url = " + url);
        // if file doesn't exist, throw FileNotFoundException
        if (url == null) {
            throw new FileNotFoundException();
        }
        String dirname = url.getFile();
        File dir = new File(dirname);
       
        //log.info(method + "dir = " + dir);
        File[] fileList = dir.listFiles();
        //log.info(method + "fileList = " + Arrays.toString(fileList));
        for (File file: fileList) {
            if (file.isDirectory()) {
                continue;
            }
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            contentList.add(builder.toString());
        }
        return contentList;
    }
}
