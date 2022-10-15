import java.io.*;

/** A class to represent a binary search tree.
 *  @author Koffman and Wolfgang
 */

public class BinarySearchTree < K extends Comparable < K >,V extends Comparable<V> > extends BinaryTree < K,V > {
  // Data Fields
  /** Return value from the public add method. */
  protected boolean addReturn;

  /** Return value from the public delete method. */
  protected V deleteReturn;

  //Methods
  /** Starter method find.
      pre: The target object must implement
           the Comparable interface.
      @param key The Comparable object being sought
      @return The object, if found, otherwise null
   */
  public V find(K key) {
    return find(root, key);
  }

  /** Recursive find method.
      @param localRoot The local subtree�s root
      @param key The object being sought
      @return The object, if found, otherwise null
   */
  private V find(Node < K,V > localRoot, K key) {
    if (localRoot == null)
      return null;

    // Compare the target with the data field at the root.
    int compResult = key.compareTo(localRoot.key);
    if (compResult == 0)
      return localRoot.value;
    else if (compResult < 0)
      return find(localRoot.left, key);
    else
      return find(localRoot.right, key);
  }

  /** Starter method add.
     pre: The object to insert must implement the
          Comparable interface.
   @param key
   @param value
   @return true if the object is inserted, false
             if the object already exists in the tree
   */
  public boolean add(K key,V value) {
    root = add(root, key,value);
    return addReturn;
  }

  /** Recursive add method.
      post: The data field addReturn is set true if the item is added to
            the tree, false if the item is already in the tree.
      @param localRoot The local root of the subtree
      @param key
      @param value
      @return The new local root that now contains the
              inserted item
   */
  private Node < K,V > add(Node < K,V > localRoot, K key,V value) {
    if (localRoot == null) {
      // item is not in the tree � insert it.
      addReturn = true;
      return new Node < K,V > (key,value);
    }
    else if (key.compareTo(localRoot.key) == 0 && value.compareTo(localRoot.value) == 0) {
      // item is equal to localRoot.data
      addReturn = false;
      return localRoot;
    }
    else if (key.compareTo(localRoot.key) == 0) {
      // item is equal to localRoot.data
      addReturn = true;
      localRoot.value = value;
      return localRoot;
    }
    else if (key.compareTo(localRoot.key) < 0) {
      // item is less than localRoot.data
      localRoot.left = add(localRoot.left, key,value);
      return localRoot;
    }
    else {
      // item is greater than localRoot.data
      localRoot.right = add(localRoot.right, key,value);
      return localRoot;
    }
  }

  /** Starter method delete.
      post: The object is not in the tree.
      @param key The object to be deleted
      @return The object deleted from the tree
              or null if the object was not in the tree
      @throws ClassCastException if target does not implement
              Comparable
   */
  public V delete(K key) {
    root = delete(root, key);
    return deleteReturn;
  }

  /** Recursive delete method.
      post: The item is not in the tree;
            deleteReturn is equal to the deleted item
            as it was stored in the tree or null
            if the item was not found.
      @param localRoot The root of the current subtree
      @param key The item to be deleted
      @return The modified local root that does not contain
              the item
   */
  private Node < K,V > delete(Node < K,V > localRoot, K key) {
    if (localRoot == null) {
      // item is not in the tree.
      deleteReturn = null;
      return localRoot;
    }

    // Search for item to delete.
    int compResult = key.compareTo(localRoot.key);
    if (compResult < 0) {
      // item is smaller than localRoot.data.
      localRoot.left = delete(localRoot.left, key);
      return localRoot;
    }
    else if (compResult > 0) {
      // item is larger than localRoot.data.
      localRoot.right = delete(localRoot.right, key);
      return localRoot;
    }
    else {
      // item is at local root.
      deleteReturn = localRoot.value;
      if (localRoot.left == null) {
        // If there is no left child, return right child
        // which can also be null.
        return localRoot.right;
      }
      else if (localRoot.right == null) {
        // If there is no right child, return left child.
        return localRoot.left;
      }
      else {
        // Node being deleted has 2 children, replace the data
        // with inorder predecessor.
        if (localRoot.left.right == null) {
          // The left child has no right child.
          // Replace the data with the data in the
          // left child.
          localRoot.key = localRoot.left.key;
          // Replace the left child with its left child.
          localRoot.left = localRoot.left.left;
          return localRoot;
        }
        else {
          // Search for the inorder predecessor (ip) and
          // replace deleted node�s data with ip.
          localRoot.key = findLargestChild(localRoot.left);
          return localRoot;
        }
      }
    }
  }

  /**** BEGIN EXERCISE ****/
  /** Removes target from tree.
       @param key Item to be removed
       @return true if the object was in the tree, false otherwise
       @post target is not in the tree
       @throws ClassCastException if target is not Comparable
   */
  public boolean remove(K key) {
    return delete(key) != null;
  }

  /** Determine if an item is in the tree
      @param key Item being sought in tree
      @return true If the item is in the tree, false otherwise
      @throws ClassCastException if target is not Comparable
   */
  public boolean contains(K key) {
    return find(key) != null;
  }

  /**** END EXERCISE ****/

  /** Find the node that is the
      inorder predecessor and replace it
      with its left child (if any).
      post: The inorder predecessor is removed from the tree.
      @param parent The parent of possible inorder
                    predecessor (ip)
      @return The data in the ip
   */
  private K findLargestChild(Node < K,V > parent) {
    // If the right child has no right child, it is
    // the inorder predecessor.
    if (parent.right.right == null) {
      K returnValue = parent.right.key;
      parent.right = parent.right.left;
      return returnValue;
    }
    else {
      return findLargestChild(parent.right);
    }
  }

}
