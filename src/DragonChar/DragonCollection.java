package DragonChar;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class DragonCollection {

    Hashtable<Integer, Dragon > DragonCollectionTable ;
    private java.util.Date creationDate;
    int size;

    public Dragon getDragon(int num){

        return DragonCollectionTable.get(num);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getSize() {
        size = this.DragonCollectionTable.size();
        return size;
    }

    public DragonCollection(){
        this.creationDate = new Date();
        this.DragonCollectionTable = new Hashtable<Integer, Dragon>();
    }
    public void putDragonToCollection(Dragon dragon){
        this.DragonCollectionTable.put((this.DragonCollectionTable.size()+1), dragon);
    }
    public void putDragonToCollectionWithKey(Dragon dragon,int key){
        this.DragonCollectionTable.put(key, dragon);
    }

    public void remove(int key) {
        this.DragonCollectionTable.remove(key);
    }

    public void clear() {
        this.DragonCollectionTable.clear();
    }
    public Enumeration<Integer> Enumeration (){
        return this.DragonCollectionTable.keys();
    }
}
