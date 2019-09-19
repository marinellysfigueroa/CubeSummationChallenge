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
public class Cube {
    private int t;
    private List<CaseTest> listCaseTest;

    public Cube(int t, List<CaseTest> listCaseTest) {
        this.t = t;
        this.listCaseTest = listCaseTest;
    }
    
    

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public List<CaseTest> getListCaseTest() {
        return listCaseTest;
    }

    public void setListCaseTest(List<CaseTest> listCaseTest) {
        this.listCaseTest = listCaseTest;
    }
    
    
    
}
