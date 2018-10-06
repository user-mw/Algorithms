package com.workout.algorithms.data_structures;

import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private int mSize;
    private BinaryTreeNode<T> mRoot;

    public void add(T item) {
        if(mRoot == null) {
            mRoot = new BinaryTreeNode<>(item);
        } else {
            addTo(mRoot, item);
        }

        mSize++;
    }

    public boolean contains(T item) {
        return findInTree(item) != null;
    }

    public BinaryTreeNode<T> findInTree(T item) {
        BinaryTreeNode<T> current = mRoot;

        while(current != null) {
            int result = current.compareTo(item);

            if(result > 0) {
                current = current.getLeft();
            } else if(result < 0) {
                current = current.getRight();
            } else {
                break;
            }
        }

        return current;
    }

    public boolean delete(T itemToDelete) {
        BinaryTreeNode<T> current = mRoot;
        BinaryTreeNode<T> parent = null;
        boolean isLeftChild = false;

        while(current != null) {
            int result = current.compareTo(itemToDelete);

            if(result > 0) {
                parent = current;
                current = current.getLeft();
                isLeftChild = true;
            } else if(result < 0) {
                parent = current;
                current = current.getRight();
                isLeftChild = false;
            } else {
                break;
            }
        }

        if(current == null) {
            return false;
        }

        mSize--;

        if(current.getLeft() == null && current.getRight() == null) {
            if(parent == null) {
                mRoot = null;
            } else if(isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        } else if(current.getRight() == null) {
            if(parent == null) {
                mRoot = current.getLeft();
            } else if(isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if(current.getLeft() == null) {
            if(parent == null) {
                mRoot = current.getRight();
            } else if(isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        } else {
            BinaryTreeNode<T> leftMost = getLeftMost(current);

            if(parent == null) {
                mRoot = leftMost;
            } else if(isLeftChild) {
                parent.setLeft(leftMost);
            } else {
                parent.setRight(leftMost);
            }
            leftMost.setLeft(current.getLeft());
        }

        return true;
    }

    public void clear() {
        mRoot = null;
        mSize = 0;
    }

    public void preOrderTraversal() {
        BinaryTreeNode<T> node = mRoot;

        if(node == null) {
            return;
        }

        Stack<BinaryTreeNode<T>> nodeStack = new Stack<>();
        nodeStack.push(node);

        while(nodeStack.size() > 0) {
            node = nodeStack.pop();
            System.out.print(node.getValue() + " ");

            if(node.getRight() != null) {
                nodeStack.push(node.getRight());
            }
            if(node.getLeft() != null) {
                nodeStack.push(node.getLeft());
            }
        }
    }

    public void inOrderTraversal() {
        BinaryTreeNode<T> node = mRoot;
        Stack<BinaryTreeNode<T>> nodeStack = new Stack<>();

        while(nodeStack.size() > 0 || node != null) {
            if(node != null) {
                nodeStack.push(node);
                node = node.getLeft();
            } else {
                node = nodeStack.pop();
                System.out.print(node.getValue() + " ");
                node = node.getRight();
            }
        }
    }

    public void postOrderTraversal() {
        BinaryTreeNode<T> node = mRoot;
        BinaryTreeNode<T> lastVisitedNode = null;
        Stack<BinaryTreeNode<T>> nodeStack = new Stack<>();

        while(nodeStack.size() > 0 || node != null) {
            if(node != null) {
                nodeStack.push(node);
                node = node.getLeft();
            } else {
                BinaryTreeNode<T> peekNode = nodeStack.peek();

                if(peekNode.getRight() != null && lastVisitedNode != peekNode.getRight()) {
                    node = peekNode.getRight();
                } else {
                    System.out.print(peekNode.getValue() + " ");
                    lastVisitedNode = nodeStack.pop();
                }
            }
        }
    }

    public int getSize() {
        return mSize;
    }

    public BinaryTreeNode<T> getRoot() {
        return mRoot;
    }

    private void addTo(BinaryTreeNode<T> node, T item) {
        if(item.compareTo(node.getValue()) < 0) {
            if(node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(item));
            } else {
                addTo(node.getLeft(), item);
            }
        } else {
            if(node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(item));
            } else {
                addTo(node.getRight(), item);
            }
        }
    }

    private BinaryTreeNode<T> getLeftMost(BinaryTreeNode<T> nodeToDelete) {
        BinaryTreeNode<T> leftMost = nodeToDelete;
        BinaryTreeNode<T> leftMostParent = nodeToDelete;
        BinaryTreeNode<T> current = nodeToDelete.getRight();

        while(current != null) {
            leftMostParent = leftMost;
            leftMost = current;
            current = current.getLeft();
        }

        if(!leftMost.equals(nodeToDelete.getRight())) {
            leftMostParent.setLeft(leftMost.getRight());
            leftMost.setRight(nodeToDelete.getRight());
        }

        return leftMost;
    }
}
