import java.util.stream.StreamSupport;

/** Hash table implementation using open addressing.
 *  @author Koffman and Wolfgang
 */

public class HashtableOpen < K, V >
    implements KWHashMap < K, V > {
  // Data Fields
  private Entry < K, V > [] table;
  private int START_CAPACITY ;
  private double LOAD_THRESHOLD = 0.75;
  private int numKeys;
  private int numDeletes;
  private final Entry < K, V > DELETED = new Entry < K, V > (null, null, -1);

  // Constructor
  public HashtableOpen(int capacity) {
    START_CAPACITY = capacity;
    table = new Entry[START_CAPACITY];
  }

  /** Contains key-value pairs for a hash table. */
  private static class Entry < K, V > {

    /** The key */
    private K key;

    /** The value */
    private V value;

    /** The link to the next colliding elements.*/

    private int next;

    /** Creates a new key-value pair.
        @param key The key
        @param value The value
     */
    public Entry(K key, V value,int next) {
      this.key = key;
      this.value = value;
      this.next = -1;
    }

    /** Retrieves the key.
        @return The key
     */
    public K getKey() {
      return key;
    }

    /** Retrieves the next.
     @return The next
     */
    public int getNext() {
      return next;
    }

    /** Next
     @param next The new next
     @return The old next
     */
    public int setNext(int next) {
      int oldNext = this.next;
      this.next = next;
      return oldNext;
    }

    /** Retrieves the value.
        @return The value
     */
    public V getValue() {
      return value;
    }

    /** Sets the value.
        @param val The new value
        @return The old value
     */
    public V setValue(V val) {
      V oldVal = value;
      value = val;
      return oldVal;
    }
  }

  /** Returns the number of entries in the map */
  public int size() {
    return numKeys;
  }

  /** Returns true if empty */
  public boolean isEmpty() {
    return numKeys == 0;
  }

  /**
   * Double hashing function for detecting index
   * @param key
   * @return returns index
   */
  private int hashFunction(Object key){
    int Hash1;
    int Hash2;
    int primeNumber = table.length-2;
    Hash1 = key.hashCode() % table.length;
    Hash2 = primeNumber - (key.hashCode() % primeNumber);
    return ( Hash1 + Hash2 ) % table.length;
  }
  /** Finds either the target key or the first empty slot in the
      search chain using linear probing.
      pre: The table is not full.
      @param key The key of the target object
      @return The position of the target or the first empty slot if
              the target is not in the table.
   */
  private int find(Object key) {
    // Calculate the starting index.
    int index = hashFunction(key);
    if (index < 0)
      index += table.length; // Make it positive.

      // Increment index until an empty slot is reached
      // or the key is found.
    if(!(key.equals(table[index].key)))
    {
      if (table[index].next != -1){
        index = table[index].next;
        while( table[index] != null && (!key.equals(table[index].key))){
          index = table[index].next;
          if(index == -1)
            break;
        }
      }
      else{
        index = table.length-1;
        while (table[index] != null && (!key.equals(table[index].key))) {
          index--;
        }
      }
    }
    return index;
  }

  /** Method get for class HashtableOpen.
      @param key The key being sought
      @return the value associated with this key if found;
              otherwise, null
   */
  public V get(Object key) {
    // Find the first table element that is empty
    // or the table element that contains the key.
    int index = find(key);

    // If the search is successful, return the value.
    if (index == -1)
      return null;
    else if (table[index] != null)
      return table[index].value;
    else
      return null; // key not found.
  }

  /** Method put for class HashtableOpen.
      post: This key-value pair is inserted in the
            table and numKeys is incremented. If the key is already
            in the table, its value is changed to the argument
            value and numKeys is not changed. If the LOAD_THRESHOLD
            is exceeded, the table is expanded.
      @param key The key of item being inserted
      @param value The value for this key
      @return Old value associated with this key if found;
              otherwise, null
   */
  public V put(K key, V value) {

    int index = hashFunction(key);
    int tempIndex = -1;
    if (table[index] != null && !table[index].key.equals(key)) {
      if(table[index].next != -1)
      {
        index = table[index].next;
        tempIndex = index;
        while(table[index].next != -1 && !table[index].key.equals(key)){
          index = table[index].next;
          tempIndex = index;
        }
      }
      else{
        tempIndex = index;
      }
      for (index = table.length-1;table[index] != null && !table[index].key.equals(key) ;index--);
    }
    // If an empty element was found, insert new entry.
    if (table[index] == null) {
      if (tempIndex != -1)
        table[tempIndex].next = index;
      table[index] = new Entry < K, V > (key, value,-1);
      numKeys++;
      // Check whether rehash is needed.
      double loadFactor = (double) (numKeys + numDeletes) / table.length;
      if (loadFactor > LOAD_THRESHOLD)
        rehash();
      return null;
    }

    // assert: table element that contains the key was found.
    // Replace value for this key.
    V oldVal = table[index].value;
    table[index].value = value;
    return oldVal;
  }

  /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
      post: The size of table is doubled and is an odd integer.
            Each nondeleted entry from the original table is
            reinserted into the expanded table.
            The value of numKeys is reset to the number of items
            actually inserted; numDeletes is reset to 0.
   */
  private void rehash() {
    // Save a reference to oldTable.
    Entry < K, V > [] oldTable = table;
    // Double capacity of this table.
    table = new Entry[2 * oldTable.length + 1];

    // Reinsert all items in oldTable into expanded table.
    numKeys = 0;
    numDeletes = 0;
    for (int i = 0; i < oldTable.length; i++) {
      if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
        // Insert entry in expanded table
        put(oldTable[i].key, oldTable[i].value);
      }
    }
  }

  /**** BEGIN EXERCISE ****/
  /** Remove the item with a given key value
   *  @param key The key to be removed
   *  @return The value associated with this key, or null
   *  if the key is not in the table.
   */
  public V remove(Object key) {
    int index = find(key);
    int tempNext;

    if (table[index] == null)
      return null;
    if (table[index].next != -1){

      tempNext = findNext(key,index);

      table[tempNext].next = table[index].next;
    }

    V oldValue = table[index].value;
    table[index] = DELETED;
    numKeys--;
    return oldValue;
  }

  private int findNext(Object key,int nextIndex){
    // Calculate the starting index.
    int index = hashFunction(key);
    if (index < 0)
      index += table.length; // Make it positive.

        while(nextIndex != table[index].next){
          index = table[index].next;
        }
    return index;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (int i=0; i < table.length;i++){
      if (table[i] != null)
        sb.append(i+".index\n"+"Key:"+table[i].key+"  Value:"+table[i].value+"  Next:"+table[i].next+"\n");
      else
        sb.append(i+".index\n"+"Null\n");

    }

    return sb.toString();
  }
  /**** END EXERCISE ****/
}
