/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author raviteja
 */
public class BinarySearchTree {
    public static MyNode root;

    public BinarySearchTree() {
        this.root=null;
    }
    public void insert(int value){
        MyNode node = new MyNode(value);        
        if(root==null) {
            root=node;
            return;
        }
        
        MyNode temp = root;
        MyNode previous = null;
        
        while(true){
            previous = temp;
            if(value>=temp.getData()) {
                temp = temp.getLeft();
                if(temp==null){
                    previous.setLeft(node);
                    return;
                }
            } else{
                temp = temp.getRight();
                if(temp==null){
                    previous.setRight(node);
                    return;
                }
            }
            
        }
        
    }
    public boolean search(int value){
        if(isEmpty()){
            System.out.println("Tree is Empty");
            return false;
        }
        MyNode temp = root;
        while(temp!=null){
            if(value==temp.getData()){
                return true;
            } else if(value < temp.getData()){
                temp=temp.getLeft();
            } else if(value>temp.getData()){
                temp=temp.getRight();
            }
        }
        return false;
    }
    
    public void delete(int value){
        if(!isEmpty()){
            MyNode parent = root;
            MyNode current = root;
            boolean isLeftChild = false;
            while(current.getData()!=value){
                    parent = current;
                    if(current.getData()>value){
                            isLeftChild = true;
                            current = current.getLeft();
                    }else{
                            isLeftChild = false;
                            current = current.getRight();
                    }
                    if(current ==null){
                            return ;
                    }
            }
            //if i am here that means we have found the node
            //Case 1: if node to be deleted has no children
            if(current.getLeft()==null && current.getRight()==null){
                    if(current==root){
                            root = null;
                    }
                    if(isLeftChild ==true){
                            parent.setLeft(null);
                    }else{
                            parent.setRight(null);
                    }
            }
            //Case 2 : if node to be deleted has only one child
            else if(current.getRight()==null){
                    if(current==root){
                            root = current.getLeft();
                    }else if(isLeftChild){
                            parent.setLeft(current.getLeft());
                    }else{
                            parent.setRight(current.getLeft());
                    }
            }
            else if(current.getLeft()==null){
                    if(current==root){
                            root = current.getRight();
                    }else if(isLeftChild){
                            parent.setLeft(current.getRight());
                    }else{
                            parent.setRight(current.getRight());
                    }
            }else if(current.getLeft()!=null && current.getRight()!=null){

                    //now we have found the minimum element in the right sub tree
                    MyNode successor = getSuccessor(current);
                    if(current==root){
                            root = successor;
                    }else if(isLeftChild){
                            parent.setLeft(successor);
                    }else{
                            parent.setRight(successor);
                    }			
                    successor.setLeft(current.getLeft());
            }
        } else {
            System.out.println("Tree is Empty. Cant delete the given element");
        }
}
	
	public MyNode getSuccessor(MyNode deleleNode){
		MyNode successsor =null;
		MyNode successsorParent =null;
		MyNode current = deleleNode.getRight();
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.getLeft();
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.getRight()){
			successsorParent.setLeft(successsor.getRight());
			successsor.setRight(deleleNode.getRight());
		}
		return successsor;
}
        
        
    
    public boolean isEmpty(){
        return (root == null);        
    }
}

