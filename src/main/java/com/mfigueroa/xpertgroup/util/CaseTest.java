/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfigueroa.xpertgroup.util;

import java.util.List;

/**
 *
 * @author mfigueroa
 */
public class CaseTest {
    
    private int n;
    private int m;
    List<String> listOperations;

    public CaseTest(int n, int m, List<String> listOperations) {
        this.n = n;
        this.m = m;
        this.listOperations = listOperations;
    }
    
    

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public List<String> getListOperations() {
        return listOperations;
    }

    public void setListOperations(List<String> listOperations) {
        this.listOperations = listOperations;
    }
    
    
    
    
}
