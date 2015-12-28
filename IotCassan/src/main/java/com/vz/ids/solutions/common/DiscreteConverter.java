/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author v086714
 */
public class DiscreteConverter {
    private final static String SEP = ",";
    private float[] bounds;
    private String[] values;
    public DiscreteConverter(String pattern) {
        String[] token = pattern.split(SEP);
        if (token.length % 2 == 1) {
            bounds = new float[token.length / 2];
            values = new String[token.length / 2 + 1];
            for (int i = 0; i < token.length; i++) {
                if (i % 2 == 0) {
                  values[i/2] = token[i];
                } else {
                    bounds[i/2] = Float.parseFloat(token[i]);
                }
            }
        }
    }
    public float getBound(int i) {
        if (i >= 0  && i < bounds.length) {
           return bounds[i];
        } else {
            return -1;
        }
    }
    public String getValue(int i) {
        if (i >= 0  && i < values.length) {
            return values[i];
        } else {
            return null;
        }
    }
    public String getDiscretedValue(float analogValue) {
        String result = values[values.length - 1];
        for (int i = bounds.length - 1; i >= 0; i--) {
            if (analogValue > bounds[i]) {
                return result;
            }
            result = values[i];
        }
        return result;
    }
}
