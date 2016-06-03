public class newHashMap 
{
    private Node[] index;
    private Node first;
    private final int size;
    private final int MOD = 32;
    
    private class Node 
    {
        private String x;
        private Object y;
        private Node next;
        
        public Node(String x, Object y)
        {
            this.x = x;
            this.y = y;
        }
        
        public Node()
        {
            x = null;
            y = null;
        }
    }
    
    private int hash(String x)
    {
        if (x.hashCode() % MOD < 0)
            return x.hashCode() % MOD + MOD;
        else return x.hashCode() % MOD;
    }
    
// return an instance of the class with preallocated
// space for the given number of objects
    public newHashMap(int size)
    {
        this.size = size;
        
        index = new Node[MOD];
        
        int i = 0;
        for (i = 0; i < size; i++)
        {
            Node temp = new Node();
            temp.next = first;
            first = temp;
        }
        
    }
    
// stores the given x,y pair in hash map
    public Boolean set(String x, Object y)
    {
        if (x == null) 
            return false;
        
        int hash = hash(x);
        
        if (first == null) return false;
        else
            first = new Node(x, y);
        
        if (index[hash] == null) index[hash] = first;
        else
            index[hash].next = first;
        
        first.next = first;
        return true;
        
        
    }
    
// return value associated with the given key
// return null if key has no value
    public Object get(String x)
    {
        if (x == null) throw new java.lang.NullPointerException();
        int hash = hash(x);
        
        if (index[hash] == null) return null;
        else
        {
            Node search = index[hash];
            while (search != null)
            {
                if (search.x == x) return search.y;
                search.next = search;
            }
            return null;
        }
    }
    
// delete the value associated with the given key
// returning the value on success or null
    public Boolean delete(String x)
    {
        if (x == null) return false;
        
        int hash = hash(x);
        
        if (index[hash] == null) return false;
        else
        {
            Node search = index[hash];
            Node previous;
            
            while (search != null)
            {
                if (index[hash].x == x) 
                {
                    index[hash] = index[hash].next;
                    return true;
                }
                else if (search.x == x)
                {
                    previous = search;
                    previous.next = search.next;
                    return true;
                }
                search = search.next;
            }
            return false;
        }
        
    }
    
// return a float value representing load factor
// items in hash map / size of hash map
    public float load()
    {
        int count = 0;
        while (first.next != null)
        {
            first = first.next;
            count++;
        }
        return (float) count / size;
    }
    
    public void hashPrint()
    {
        int i = 0;
        for (i = 0; i < MOD; i++)
        {
            System.out.print("Index " + i + ": ");
            first = index[i];
            while (first != null)
            {
                if (first.x != null || first.y != null)
                {
                    System.out.print(first.x + ", " + first.y + " || ");
                }
                first.next = first;
            }
            System.out.println();
        }
        
    }
    
    public static void main(String args[])
    {
        //scan = new Scanner(new File("test.txt"));
        
        //while(scan.hasNext())
        
        //   String current = scan.next();
        
        newHashMap test = new newHashMap(1);
        test.set("abbadb", 1);
        //test.set("badsfa", 7);
        test.hashPrint();
    }
}