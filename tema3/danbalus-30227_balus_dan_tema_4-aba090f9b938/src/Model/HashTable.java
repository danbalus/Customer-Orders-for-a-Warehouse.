package Model;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * @invariant isWellFormed()
 * @author Norby
 */
public class HashTable {

    private ArrayList<Account>[] table;
    private int size;

    public HashTable(int dimension) {
        this.size = dimension;
        table = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new ArrayList<Account>();
        }

    }


    public int getSize() {
        return size;
    }

  
    public void addValue(Account value, int key) {
        assert isWellFormed();
        assert value != null;
        assert key > 0;

        //ArrayList ar =new ArrayList();
        int firstSize = getWholeSize();
        int hash = (key % size);
        if (table[hash] != null) {
            ArrayList ar = getList(hash);
            ar.add(value);
        } else {
            ArrayList ar = new ArrayList();
            setArrayList(ar, hash);
            ar.add(value);
        }


        table[hash].add(value);
        int secondSize = getWholeSize();




        assert secondSize == firstSize + 1;
        assert value == table[hash].get(table[hash].size() - 1);
        assert isWellFormed();
    }


    public void remove(int id) {
        assert isWellFormed();
        assert getWholeSize() > 0;

        int firstSize = getWholeSize();
        int hash = id % size;
        int pos = id / size;
        ArrayList ar = getList(hash);
        for (int i = 0; i < ar.size(); i++) {
            Account ac = (Account) ar.get(i);
            if (ac.getId() == id) {
                ar.remove(i);
            }
        }
        
        int secondSize = getWholeSize();

        assert firstSize == secondSize - 1;
      
        assert isWellFormed();
    }


    public void setArrayList(ArrayList<Account> Arr, int pos) {
        table[pos] = Arr;
    }


    public int getLength(int key) {


        int length = 0;
        Account current;
        if (table[key] == null) {
            return 0;
        } else {
            Iterator<Account> it = table[key].iterator();
            while (it.hasNext()) {
                current = it.next();
                length++;
            }
        }
        return length;
    }
    public int getWholeSize() {
        int wholeSize = 0;
        for (int i = 0; i < size; i++) {
            wholeSize += getLength(i);
        }
        return wholeSize;
    }

   
    public ArrayList<Account> getList(int key) {
        int hash = key % size;
        ArrayList<Account> list = new ArrayList<Account>();
        Iterator<Account> iterator = table[hash].iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

  
    public boolean isWellFormed() {
        int dimension = 0;
        boolean ok = true;
        Account current;
        for (int i = 0; i < size; i++) {
            dimension += table[i].size();
        }
        for (int i = 0; i < size; i++) {
            Iterator<Account> it = table[i].iterator();
            while (it.hasNext()) {
                current = it.next();
                if (current.getId() % size != i) {
                    ok = false;
                }
            }
            if (dimension != getWholeSize()) {
                ok = false;
            }
        }
        return ok;
    }



    public boolean isEmpty() {
        boolean ok = true;
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                ok = false;
            }
        }
        return ok;
    }
}
