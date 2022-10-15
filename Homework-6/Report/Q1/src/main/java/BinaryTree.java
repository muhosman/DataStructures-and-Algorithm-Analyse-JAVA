import java.io.*;

/** Class for a binary tree that stores type E objects.
*   @author Koffman and Wolfgang
* */

public class BinaryTree < K,V > implements Serializable {

  /** Class to encapsulate a tree node. */
  protected static class Node < K,V >
      implements Serializable {
    // Data Fields
    /** The information stored in this node. */
    protected V value;
    protected K key;

    /** Reference to the left child. */
    protected Node < K,V > left;

    /** Reference to the right child. */
    protected Node < K,V > right;

    // Constructors
    /** Construct a node with given data and no children.
        @param key
        @param value
     */
    public Node(K key,V value) {
      this.key = key;
      this.value = value;
      left = null;
      right = null;
    }

    // Methods
    /** Return a string representation of the node.
        @return A string representation of the data fields
     */
    public String toString() {
      return key.toString()+","+value.toString();
    }
  }

  // Data Field
  /** The root of the binary tree */
  protected Node < K,V > root;

  public BinaryTree() {
    root = null;
  }

  protected BinaryTree(Node < K,V > root) {
    this.root = root;
  }

  /** Constructs a new binary tree with data in its root,leftTree
      as its left subtree and rightTree as its right subtree.
   */
  public BinaryTree(V value,K key, BinaryTree < K,V > leftTree,
                    BinaryTree < K,V > rightTree) {
    root = new Node < K,V > (key,value);
    if (leftTree != null) {
      root.left = leftTree.root;
    }
    else {
      root.left = null;
    }
    if (rightTree != null) {
      root.right = rightTree.root;
    }
    else {
      root.right = null;
    }
  }

  /** Return the left subtree.
      @return The left subtree or null if either the root or
      the left subtree is null
   */
  public BinaryTree < K,V > getLeftSubtree() {
    if (root != null && root.left != null) {
      return new BinaryTree < K,V > (root.left);
    }
    else {
      return null;
    }
  }

  /** Return the right sub-tree
        @return the right sub-tree or
        null if either the root or the
        right subtree is null.
    */
    public BinaryTree<K,V> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<K,V>(root.right);
        } else {
            return null;
        }
    }


  /**** BEGIN EXERCISE ****/
  /** Return the data field of the root
        @return the data field of the root
        or null if the root is null
    */
    public V getData() {
        if (root != null) {
            return root.value;
        } else {
            return null;
        }
    }
  /**** END EXERCISE ****/

  /** Determine whether this tree is a leaf.
      @return true if the root has no children
   */
  public boolean isLeaf() {
    return (root.left == null && root.right == null);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrderTraverse(root, 1, sb);
    return sb.toString();
  }

  /** Perform a preorder traversal.
      @param node The local root
      @param depth The depth
      @param sb The string buffer to save the output
   */
  private void preOrderTraverse(Node < K,V > node, int depth, StringBuilder sb) {
    for (int i = 1; i < depth; i++) {
      sb.append("  ");
    }
    if (node == null) {
      sb.append("null\n");
    }
    else {
      sb.append(node.toString());
      sb.append("\n");
      preOrderTraverse(node.left, depth + 1, sb);
      preOrderTraverse(node.right, depth + 1, sb);
    }
  }
}
