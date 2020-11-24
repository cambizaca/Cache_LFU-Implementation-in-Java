package assignment4_f20;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MinBinHeap implements Heap {
  private CacheFrame[] array; // load this array					//THIS IT PRIVaTEEEEEEEEEE
  private int size;      // how many items currently in the heap
  private int arraySize; // Everything in the array will initially
                         // be null. This is ok! Just build out
                         // from array[1]

  public MinBinHeap(int nelts) {
    this.array = new CacheFrame[nelts+1];  // remember we dont use slot 0
    this.arraySize = nelts+1;
    this.size = 0;
    this.array[0] = new CacheFrame(null, 0); // 0 not used, so this is arbitrary
  }

  // Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public CacheFrame[] getHeap() { return this.array; }
	
	@Override
	public void insert(CacheFrame elt) {
		System.out.println("Inserting new Cache Frame : " + elt.getValue() );
		int curIndex = size + 1;
		if(curIndex < arraySize) {
			if(elt.getPriority() == 0) {
				elt.setPriority(1);
			} else {
				
			}
			array[curIndex] = elt;
			size++;	
		} else {					// hash table, erases the irrelavent Cache frame 
			System.out.println(array[size]);	
			System.out.println("gotta delete stuff from the frame son");

//			if(elt.getPriority() > array[1].getPriority()) {
				this.delMin();			// if it's full
			if(elt.getPriority() == 0) {
					elt.setPriority(1);
//					

			}
//				System.out.println("AJFHJANFKJHNK: " + curIndex);

				curIndex = curIndex- 1;
//				System.out.println("AJFHJANFKJHNK: " + curIndex);
				array[curIndex] = elt;
				size++;
			
			
			
		}
		System.out.println("Size: " + size);
		System.out.println("Current Index: " + curIndex);

		
			while(curIndex >= 1) {
				System.out.println("Aight "+ array[curIndex].getPriority() + " < " + array[(int) Math.floor(curIndex/2)].getPriority());
				if(array[curIndex].getPriority() < array[(int) Math.floor(curIndex/2)].getPriority()) {
					System.out.println("Parent is bigger, bouta switch");
					array[(int) Math.floor(curIndex/2)].setSlot(curIndex);
					CacheFrame tempCac = array[(int) Math.floor(curIndex/2)];
					array[curIndex].setSlot((int) Math.floor(curIndex/2));
					array[(int) Math.floor(curIndex/2)] = array[curIndex];
					array[curIndex] = tempCac;
					curIndex = (int) Math.floor(curIndex/2);
					continue;
				} 		
				elt.setSlot(curIndex);
				System.out.println("Finished storing heap; final array slot for : " + elt.getValue() + " is " + elt.getSlot() + " with a priority of  " + elt.getPriority());
				return;
			}
//		// TODO Auto-generated method stub
//		// System.out.println("Finished storing heap; final array slot for : " + elt.getValue() + " is " + elt.getSlot() + " with a priority of  " + elt.getPriority());
//			System.out.println("Finished storing heap; final array slot for : " + elt.getValue() + " is " + elt.getSlot() + " with a priority of  " + elt.getPriority());
//			return;
	}
	
	@Override
	public void delMin() {
		// TODO Auto-generated method stub
	//	System.out.println("gonna delete shit");
		if(size == 1) {
			array[1]= null;
			size--;
			return;
		}
		
		if(size > 1) {
			array[1]= null;
			System.out.println(array[1] == null);
			array[1] = array[size];
			array[size] = null;
			array[1].setSlot(1);
			size--;
//			System.out.println("Size AFTER: " + size);
			System.out.println(Arrays.toString(array));
			Boolean traverseLeft = false;
			Boolean traverseRight = false;
			int curIndex = 1;
			
			while(curIndex <= size) {	
				//traverse roots
				 if(curIndex * 2 <= size) {
					 System.out.println("Current index: " + curIndex );
					 System.out.println("Left: " + array[curIndex * 2] );
					 System.out.println("Right: " + array[curIndex * 2 + 1] );
					 if(size <= 2) {
						 if(array[curIndex].getPriority() > array[curIndex*2].getPriority()) {
							 CacheFrame tempCac = array[curIndex];
								array[curIndex] = array[curIndex * 2];					// array[curIndex] is  now element that is not null
								array[curIndex * 2] = tempCac;
								 for(int i = 1 ; i <= size; i++) {
										if(array[i] != null) {
											if(array[i].getSlot() != i) {
												array[i].setSlot(i);
											}
										}
								}
								return;
						 } else {
							 return;
						 }
						 
						 
					 } else if(array[curIndex * 2].getPriority() > array[curIndex * 2 + 1].getPriority() ) {
						 traverseRight = true;
					 } else {
						 traverseLeft = true;
					 } 
					if(traverseLeft) {		// new priority compare to left tree
						CacheFrame tempCac = array[curIndex];
						array[curIndex] = array[curIndex * 2];					// array[curIndex] is  now element that is not null
						array[curIndex * 2] = tempCac;
						curIndex = curIndex * 2;
						 System.out.println(Arrays.toString(array));
						 if(curIndex * 2 <= size || curIndex * 2+1 <= size) {
							 if(array[curIndex * 2] == null || array[curIndex * 2+1] == null) {
								 for(int i = 1 ; i <= size; i++) {
										if(array[i] != null) {
											if(array[i].getSlot() != i) {
												array[i].setSlot(i);
											}
										}
									}
								 return;
							 }
						 }
						 traverseLeft = false;
						 traverseRight = false;
						 
						continue;					
					}
				} if(traverseRight) {
					if (array[curIndex * 2 + 1].getPriority() < array[curIndex].getPriority()) {	//new priority compare to right tree
						CacheFrame tempCac = array[curIndex];
						array[curIndex] = array[curIndex * 2 + 1];					// array[curIndex] is  now element that is not null
						array[curIndex * 2 + 1] = tempCac;			
						curIndex = curIndex * 2 + 1;
						 System.out.println(Arrays.toString(array));
						 if(curIndex * 2 <= size || curIndex * 2+1 <= size) {
							 if(array[curIndex * 2] == null || array[curIndex * 2+1] == null) {
								 for(int i = 1 ; i <= size; i++) {
										if(array[i] != null) {
											if(array[i].getSlot() != i) {
												array[i].setSlot(i);
											}
										}
									}
								 return;
							 }
						 }
						 traverseLeft = false;
						 traverseRight = false;
						continue;
					}
				}
					for(int i = 1 ; i <= size; i++) {
						if(array[i] != null) {
							if(array[i].getSlot() != i) {
								array[i].setSlot(i);
							}
						}
					}
					return;
			}
		}
	}
	
	@Override
	public CacheFrame getMin() {
		return array[1];
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void incElt(CacheFrame elt) {

		int newPriori = elt.getPriority() + 1;
		System.out.println("Setting new pri of Elt " +elt.getValue()+ " to : " + newPriori );
		elt.setPriority(newPriori);	
		int curIndex = elt.getSlot();
		array[curIndex] = elt;
		while(curIndex <= size) {													//traverse roots
			 if(curIndex * 2 <= size) {
				System.out.println("Left : " +array[curIndex * 2].getPriority() + " < " + newPriori);
				if(array[curIndex * 2].getPriority() < array[curIndex].getPriority()) {		// new priority compare to left tree
					CacheFrame tempCac = array[curIndex];
					array[curIndex] = array[curIndex * 2];					// array[curIndex] is  now element that is not null
					array[curIndex * 2] = tempCac;
					curIndex = curIndex * 2;
					continue;					
				}
			} if(curIndex * 2 + 1 <= size ) {
					System.out.println("Right: " + array[curIndex * 2 + 1].getPriority() + " < " + newPriori);
				if (array[curIndex * 2 + 1].getPriority() < array[curIndex].getPriority()) {	//new priority compare to right tree
					CacheFrame tempCac = array[curIndex];
					array[curIndex] = array[curIndex * 2 + 1];					// array[curIndex] is  now element that is not null
					array[curIndex * 2 + 1] = tempCac;			
					curIndex = curIndex * 2 + 1;
					continue;
				}
			}
				for(int i = 1 ; i <= size; i++) {
					if(array[i] != null) {
						if(array[i].getSlot() != i) {
							array[i].setSlot(i);
						}
					}
				}
				return;
		}
	}
	
	@Override
	public void decElt(CacheFrame elt) {
		int newPriori = elt.getPriority();
		if(newPriori > 1) {
			newPriori = elt.getPriority() - 1;
			elt.setPriority(newPriori);	
			int curIndex = elt.getSlot();
			while(curIndex >= 1) {
				if(array[curIndex].getPriority() < array[(int) Math.floor(curIndex/2)].getPriority()) {
					System.out.println("Parent is bigger, bouta switch");
					array[(int) Math.floor(curIndex/2)].setSlot(curIndex);
					CacheFrame tempCac = array[(int) Math.floor(curIndex/2)];
					array[curIndex].setSlot((int) Math.floor(curIndex/2));
					array[(int) Math.floor(curIndex/2)] = array[curIndex];
					array[curIndex] = tempCac;
					curIndex = (int) Math.floor(curIndex/2);
					continue;
				} 		
				elt.setSlot(curIndex);
				return;
			}
		}	
		return;
	}

  //===============================================================
  //
  // here down you implement the ops in the interface
  //
  //===============================================================

}