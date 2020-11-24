package assignment4_f20;

import java.util.Arrays;

public class Playground {
  public static void main(String[] args) {
    // Add more tests as methods and call them here!!
    RunMyTests();
    // etc.
  }

  public static void RunMyTests() {
   Cache_LFU lfc = new Cache_LFU(3);
//   
//   lfc.refer("AA8C");
//   lfc.refer("AA8C");
//   lfc.refer("1234");
//   lfc.refer("234A");
//   lfc.refer("ABCD");

//   System.out.println(lfc.getHashMap().get(key))



   
   
   lfc.getHeap().insert(new CacheFrame("a", 6));
   lfc.getHeap().insert(new CacheFrame("b", 8));
   lfc.getHeap().insert(new CacheFrame("c", 9));
   lfc.getHeap().insert(new CacheFrame("d", 9));
   lfc.getHeap().insert(new CacheFrame("e", 8));
   lfc.getHeap().insert(new CacheFrame("f", 5));
   lfc.getHeap().insert(new CacheFrame("g", 2));
////   lfc.getHeap().insert(new CacheFrame("h", 10));
//
//   
////   System.out.println("Before adding h");
////   System.out.println(Arrays.toString(lfc.getHeap().getHeap()));
//
//   
//   lfc.getHeap().delMin();
//   // lfc.getHeap().delMin();
//   
// //   lfc.getHeap().delMin();
//   
//   System.out.println("After adding h");
//
   System.out.println(Arrays.toString(lfc.getHeap().getHeap()));




   

// //  System.out.println(Arrays.toString(lfc.getHeap().getHeap()));
//    lfc.refer("AA8C");		//size: 1; pri: 1	| slot: 1
//    System.out.println("\n");
//    lfc.refer("AA8C");		//incElt: AA8C; pri: 2 | slot: 1
//    System.out.println("\n");
//    lfc.refer("1234");		//size: 2; pri: 1	| slot: 1
//    System.out.println("\n");
//    lfc.refer("234A");		//size: 3; pri: 1	| slot: 1
//    System.out.println("\n");
//    lfc.refer("AA8C");		//incElt: AA8C; pri: 3	| slot: 3
//    System.out.println("\n");
//    lfc.refer("234A");		//incElt; 1234; pri: 2	| slot: 2
//    System.out.println("\n");
//    lfc.refer("5555");
//    lfc.refer("5555");
//    lfc.refer("5555");
//    lfc.refer("5555");
//    lfc.refer("AA8C");		

  //  printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());

    
   //  lfc.getHeap().decElt( (CacheFrame) lfc.getHashMap().get("5555"));   
   //refer("AA8C") x 2 -> refer("1234") x 1 -> refer("234A") x 1 -> refer("ABCD") -> numElts() --> Expected 3, saw 2 expected:<3> but was:<2>
   //Message:refer("AA8C") x 2, refer("1234"), refer("234A"), refer("ABCD") -> get("1234") --> Expected NULL, saw NOT_NULL expected:<N[]ULL> but was:<N[OT_N]ULL>
//   lfc.refer("AA8C");
//   lfc.refer("AA8C");
//   lfc.refer("1234");
//   lfc.refer("234A");
//   lfc.refer("ABCD");
//   System.out.println(lfc.getHashMap().get("234A"));
//   System.out.println(lfc.getHashMap().get("AA8C"));
//   System.out.println(lfc.getHashMap().get("ABCD")); 
   System.out.println("finito");
   
   // expected:<(val: ABCD, pri:[1, slot: 3])> but was:<(val: ABCD, pri:[0, slot: 2])>

    // etc.

  }

  public static void printHeap(CacheFrame[] e,int len) { 
    // this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1; i< len+1; i++) {
      System.out.print("(p."+e[i].value+",f"+e[i].priority+",s"+e[i].getSlot()+")\t");
    }
    System.out.print("\n");
  }

}