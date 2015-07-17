public class Obj {
  private int length;
  private int [] array;

public Obj(int length) {
	this.array = new int [length];
}

public Obj iter(int times) {
     Obj currentObject = new Obj(this.length); 
     Obj newObject = null;    // the key 1 of iterato, declare it first 
         currentObject = this;
		 for (int count = 0; count < times; count++) {
         newObject = new Obj(this.length);
         newObject.array[0] = currentObject.array[0] * 2;
         newObject.array[1] = currentObject.array[1] + 2;
         currentObject = newObject; 
	}
	return newObject;
}

public static void main(String[] args) {
	Obj object1 = new Obj(6);
	object1.array[0] = 1;
	object1.array[1] = 2;
	Obj object2 = object1.iter(3);
	System.out.println(object2);
}
}