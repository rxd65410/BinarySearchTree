/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raviteja
 */
public class MyNode {
    private int data;
    private MyNode left;
    private MyNode right;

    public MyNode(int val) {
        this.data=val;
        this.left=null;
        this.right=null;
    }
    
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }
}

