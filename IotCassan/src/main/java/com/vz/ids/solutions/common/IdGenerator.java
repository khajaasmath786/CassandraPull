/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.common;

import java.util.UUID;

import com.datastax.driver.core.utils.UUIDs;

/**
 *
 * @author v086714
 */
public class IdGenerator {
    public static String nextId() {
        UUID uuid =  UUID.randomUUID();
        return uuid.toString();
    }
    
    public static String nextTimeBasedId() {
        UUID uuid =  UUIDs.timeBased();
        return uuid.toString();
    }
    
}
