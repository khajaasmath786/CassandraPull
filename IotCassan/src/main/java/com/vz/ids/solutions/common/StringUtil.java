/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.common;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author v086714
 */
public class StringUtil {
    public static String stripEscapedChar(String line) {
        if (line == null || line.isEmpty()) {
            return line;
        }
        StringBuilder builder = new StringBuilder();
        char[] chars = line.toCharArray();
        for (char ch: chars) {
            if (ch != '\\') {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
    
    public static String format(String formatStr, Object... values) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(buffer);
        printStream.format(formatStr, values);
        return buffer.toString();
    }
}
