import java.util.*;

/** Hash table implementation using chaining.
*   @author Koffman and Wolfgang
* */

public class HashtableChain < K extends Comparable<K>, V extends Comparable<V>> implements KWHashMap < K, V > {
  /** The table */
  private BinarySearchTree <K,V> [] table;

  /** The number of keys */
  private int numKeys;

  /** The capacity */
  private int CAPACITY;

  /** The maximum load factor */
  private static final double LOAD_THRESHOLD = 3.0;

  /** Contains key-value pairs for a hash table. */

  // Constructor
  public HashtableChain(int capacity) {
    CAPACITY = capacity;
    table = new BinarySearchTree[CAPACITY];
  }

  /** Method get for class HashtableChain.
      @param key The key being sought
      @return The value associated with this key if found;
              otherwise, null
   */
  public V get(Object key) {
    int index = key.hashCode() % table.length;
    if (index < 0)
      index += table.length;
    if (table[index] == null)
      return null; // key is not in the table.

    // Search the list at table[index] to find the key.
    V temp = table[index].find((K) key);
    if(temp != null)
      return temp;
    // assert: key is not in the table.
    return null;
  }

  /** Method put for class HashtableChain.
      post: This key-value pair is inserted in the
            table and numKeys is incremented. If the key is already
            in the table, its value is changed to the argument
            value and numKeys is not changed.
      @param key The key of item being inserted
      @param value The value for this key
      @return The old value associated with this key if
              found; otherwise, null
   */
  public V put(K key, V value) {
    int index = key.hashCode() % table.length;
    if (index < 0)
      index += table.length;
    if (table[index] == null) {
      // Create a new linked list at table[index].
      table[index] = new BinarySearchTree<K,V>();
    }

    if(true == table[index].add(key,value))
    {
      numKeys++;
      if (numKeys > (LOAD_THRESHOLD * table.length))
        rehash();
    }
    return null;
  }

  /** Returns the number of entries in the map */
  public int size() {
    return numKeys;
  }

  /** Returns true if empty */
  public boolean isEmpty() {
    return numKeys == 0;
  }

  /**** BEGIN EXERCISE ****/
  public V remove(Object key) {
    int index = key.hashCode() % table.length;
    if (index < 0)
      index += table.length;
    if (table[index] == null)
      return null; // Key not in table

    V temp = table[index].delete((K) key);

    if(temp == null)
      return null; // Key not in table
    return temp;
  }

  /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
      post: the size of table is doubled and is an
      odd integer. Each non-deleted entry from the original
      table is reinserted into the expanded table.
      The value of numKeys is reset to the number of items
      actually inserted; numDeletes is reset to 0.
   */
  public void rehash() {
    // Save a reference to oldTable
    BinarySearchTree [] oldTable = table;
    // Double capacity of this table
    table = new BinarySearchTree[2 * oldTable.length + 1];


    // Reinsert all items in oldTable into expanded table.
    numKeys = 0;
    for (int i = 0; i < oldTable.length; i++) {
      if (oldTable[i] != null) {
        putTraverse(oldTable[i].root);
      }
    }
  }

  public void putTraverse(BinaryTree.Node< K,V > node){
    if (node != null){
      put(node.key, node.value);
      putTraverse(node.left);
      putTraverse(node.right);
    }
  }

  @Override
  public String toString() {

    StringBuilder sb = new StringBuilder();

    for (int i=0; i < table.length;i++){
      if (table[i] != null)
        sb.append(i+".index\n"+table[i].toString());
      else
        sb.append(i+".index\n"+"Null\n");

    }

    return sb.toString();
  }

  /**** END EXERCISE ****/
}
