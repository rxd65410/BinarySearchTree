/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author raviteja
 */
public class BSTMain {
    BinarySearchTree bst = new BinarySearchTree();
    public int getUserInput(){
        Scanner scan = new Scanner(System.in);        
        System.out.println("Binary Search Tree Operations");
        System.out.println("1. Insert ");
        System.out.println("2. Delete");
        System.out.println("3. Search");
        System.out.println("4. Display Tree");
        System.out.println("5. Exit");
        System.out.println("Please enter your Choice : ");
        int choice = scan.nextInt(); 
        switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert : ");
                bst.insert(scan.nextInt());                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to delete : ");
                bst.delete( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to search : ");
                System.out.println("Search result : "+ bst.search( scan.nextInt() ));
                break; 
            case 4 :
                break;
            case 5 : 
                return 5;
            default : 
                System.out.println("Wrong Entry");
                break;   
            }//changes in master after changes in branch1
        BTreePrinter.printNode(BinarySearchTree.root);
        return 1;
    }
    
    /**
     * @param args the command line arguments//
     */
    public static void main(String[] args) {
       BSTMain bmain = new BSTMain();
       
       while(true){
           int ans = bmain.getUserInput();
           if(ans==5) break;
       }
    }
}

