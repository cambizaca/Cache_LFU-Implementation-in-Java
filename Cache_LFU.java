package assignment4_f20;

import java.util.HashMap;

public class Cache_LFU implements Cache {
  
  HashMap<String, CacheFrame> map; 
    // allocate from java collections lib
    // do it this way so we all start with default size and 
    // default lambda and default hash function for string keys
    MinBinHeap heap; // your own heap code above
    int limit;       // max num elts the cache can hold
    int size;        // current number elts in the cache
  
    Cache_LFU (int maxElts) {
      this.map = new HashMap<String, CacheFrame>();
      this.heap = new MinBinHeap(maxElts);
      this.limit = maxElts;
      this.size = 0;
      System.out.println("LIMIT : " + this.limit);
    }
  
    // dont change this we need it for grading
    public MinBinHeap getHeap() { return this.heap; }
    public HashMap getHashMap() { return this.map; }

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.limit;
	}
	
	@Override
	public int numElts() {
		// TODO Auto-generated method stub
		return heap.size();
	}
	
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return this.limit == heap.size();
	}
	
	public boolean refer(String address) {
		
		if(map.containsKey(address)) {
			System.out.println("bouta incElt");
			//increase priority by 1 in heap
			heap.incElt(map.get(address));			//refers to cache frame with corresponding
			//System.out.println("yoooo");
			//update in Hashtable..?
			
//		CacheFrame updateInMap = map.get(address);
//			updateInMap.setSlot(map.get(address).getSlot() + 1);
//			map.put(address, updateInMap);						//inserts CacheFrame into map

			System.out.println("already in Cache, working with : " +  address + " ; new priority val is : " + map.get(address).getPriority() + " at slot " + map.get(address).getSlot());
			return true;							//address and returns true
		} 
		if(this.isFull()) {
			map.remove(heap.getMin().getValue(), heap.getMin());	
		}
		CacheFrame newy = new CacheFrame(address , 0);
		heap.insert(newy);							//inserts CacheFrane into heap 
		map.put(address, newy);						//inserts CacheFrame into map
		System.out.println("Placed in HashMap");
		

		return false;								//return false since it was address
													//not originally in Cache LFU
	}
  
  // =========================================================
  //
  // you fill in code for the other ops in the interface
  //
  //==========================================================
  
}
