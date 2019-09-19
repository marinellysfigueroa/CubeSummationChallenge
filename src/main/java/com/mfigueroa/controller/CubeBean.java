/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mfigueroa.controller;

import com.mfigueroa.xpertgroup.util.CaseTest;
import com.mfigueroa.xpertgroup.util.Cube;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author mfigueroa
 */
@ManagedBean(name = "cubeBean")
@RequestScoped
public class CubeBean {
    
    private static final String UPDATE = "UPDATE";
    private int t=1;
    private int n=1;
    private int m=1;
    String o1="";
    String o2="";
    String o3="";
    String o4="";
    String o5="";
    String typeOperation="";

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
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

    public String getO1() {
        return o1;
    }

    public void setO1(String o1) {
        this.o1 = o1;
    }

    public String getO2() {
        return o2;
    }

    public void setO2(String o2) {
        this.o2 = o2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getO4() {
        return o4;
    }

    public void setO4(String o4) {
        this.o4 = o4;
    }

    public String getO5() {
        return o5;
    }

    public void setO5(String o5) {
        this.o5 = o5;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }
    
    
   public void getValues()
   {
       System.out.println("t" +this.t);
       System.out.println("n" +this.n);
       System.out.println("m" +this.m);
       
       System.out.println("o1" +this.o1);
       System.out.println("o2" +this.o2);
       System.out.println("o3" +this.o3);
       System.out.println("o4" +this.o4);
       System.out.println("o5" +this.o5);
       
       Cube c = fillCube();
       processCaseTest(c);
       
   }

    private Cube fillCube() {
        //create list of operations
        List<String> listOperations = new ArrayList();
        listOperations.add(this.o1);
        listOperations.add(this.o2);
        listOperations.add(this.o3);
        listOperations.add(this.o4);
        listOperations.add(this.o5);

        //create the first case test
        CaseTest cube = new CaseTest(this.n, this.m, listOperations);

        //add two case test to list of case test
        List<CaseTest> listCaseTest = new ArrayList();
        listCaseTest.add(0, cube);
        

        //create object cube
        Cube c = new Cube(this.t, listCaseTest);

        return c;
    }

    private void processCaseTest(Cube c) {
        //go over each test case
        for (int i = 0; i < c.getListCaseTest().size(); i++) {

            CaseTest caseTest = c.getListCaseTest().get(i);
            int[][][] cube = new int[caseTest.getN() + 1][caseTest.getN() + 1][caseTest.getN() + 1];

            //initialize cube
            for (int k = 1; k <= caseTest.getN(); k++) {
                cube[k][k][k] = 0;

            }

            processOperations(caseTest, cube);
        }
    }

    private void processOperations(CaseTest caseTest, int[][][] cube) {
        //go over each operation
        for (int j = 0; j < caseTest.getListOperations().size(); j++) {
            String stringToSplit = caseTest.getListOperations().get(j);
            String[] tempArray;
            String delimiter = " ";
            tempArray = stringToSplit.split(delimiter);

            //validate type of operatin
            if (UPDATE.equals(tempArray[0])) {

                updateCube(tempArray, cube);

            } else {

                long sum = sumCube(tempArray, cube);
                System.out.println(sum);

            }

        }
    }

    private long sumCube(String[] tempArray, int[][][] cube) {
        int x1, y1, z1, x2, y2, z2;
        long sum = 0;
        
        x1 = Integer.parseInt(tempArray[1]);
        y1 = Integer.parseInt(tempArray[2]);
        z1 = Integer.parseInt(tempArray[3]);
        x2 = Integer.parseInt(tempArray[4]);
        y2 = Integer.parseInt(tempArray[5]);
        z2 = Integer.parseInt(tempArray[6]);
        for (int l = x1; l <= x2; l++) {
            sum = sum + cube[l][l][l];
        }
        
        return sum;
    }

    private void updateCube(String[] tempArray, int[][][] cube) {
        int x, y, z, w;
        x = Integer.parseInt(tempArray[1]);
        y = Integer.parseInt(tempArray[2]);
        z = Integer.parseInt(tempArray[3]);
        w = Integer.parseInt(tempArray[4]);
        cube[x][y][z] = w;
    }
    
}
