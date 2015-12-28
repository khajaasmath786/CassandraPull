/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.common;

import com.vz.ids.solutions.common.DiscreteConverter;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author v086714
 */
@Slf4j
public class DiscreteConverterManager {
    private static final Map<String, DiscreteConverter> map = new HashMap<>();
    private static final DiscreteConverterManager instance = new DiscreteConverterManager(); 
    private DiscreteConverterManager() {
        
    }
    public static DiscreteConverterManager getInstance() {
        return instance;
    }
    public DiscreteConverter getConverter(String discretePattern) {
        DiscreteConverter converter = map.get(discretePattern);
        if (converter == null) {
            converter = new DiscreteConverter(discretePattern);
            map.put(discretePattern, converter);
        }
        return converter;
    }
}
