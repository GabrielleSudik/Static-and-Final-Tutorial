class Thing {

	// compare fields with static and without:
	public String name;
	public static String description;

	// compare methods with static and without:
	public void showName() {
		System.out.println(name);
		System.out.println("Printing class variable description: " + description);
		// that last line is an example of the instance method
		// using a class variable
		// the opposite cannot happen
		System.out.println("Object id: " + idNumber);
	}

	public static void showInfo() {
		System.out.println("Printing generic info.");
		// if you tried to output an instance variable, like name,
		// you'll get an error

		// on the other hand, instance methods can access class data/methods

	}
	
	//let's make a constant:
	public final static int LUCKY_NUMBER = 13;
	//"final" is java's version of "const" -- you can't reassign it
	//final fields always need values when they are created
	
	//here we'll make an int field to count number of created objects
	//(Normally this would be private and would generate via a get...
	//but this way keeps it simple)
	public static int count = 0;
	
	//we'll create ID numbers for each object
	public int idNumber;
	//remember uninitialized variables are assigned "0"
	
	public Thing() {
		//here's a constructor
		//it will run every time you run Thing
		count++;
		//every time you create a new Thing, count will increase by one
		
		//here we set ID equal to the object's count
		idNumber = count;
		//count will remain linked to the class itself (because it's static)
		//while idNumber will link to each object, because it's an instance variable
	}
}

public class Application {

	public static void main(String[] args) {

		System.out.println("Before creating objects: " +Thing.count);
		
		Thing thing1 = new Thing();
		Thing thing2 = new Thing();
	
		thing1.name = "Bob";
		thing2.name = "Sue";

		System.out.println(thing1.name);
		System.out.println(thing2.name);
		
		System.out.println("Number of objects so far: " +Thing.count);

		Thing.description = "I am a thing.";
		System.out.println(Thing.description);

		// so what's up with static?
		// it makes something an CLASS variable
		// that is, everything in the class will use the same variable
		// the variable with out static (ie, name)
		// are INSTANCE variables, because they change for each instance of the class

		// you can change the class variable, but watch what happens:
		thing1.description = "bear";
		thing2.description = "cat";

		System.out.println(thing1.description);
		System.out.println(thing2.description);
		// it only printed the last description. skipped "bear"

		// you can do something similar with class methods and static
		thing1.showName();
		thing2.showName();

		Thing.showInfo();
		// see how you called that method with the name of the class, not the instance?

		// let's try an example, using the Math class (which is a standard java library)
		System.out.println(Math.PI);

		// what if we want to create our own constant?
		// note in java, constant variable names are traditionally all uppercase
		// see above for the creation of a constant

		System.out.println(Thing.LUCKY_NUMBER);
		
		//another good use of static is counting the number of objects that get created.
		
		Thing thing3 = new Thing();
		Thing thing4 = new Thing();
		
		thing3.name = "Mick";
		thing4.name = "Sandy";
		
		System.out.println(thing3.name);
		System.out.println(thing4.name);
		
		System.out.println("Number of objects so far: " +Thing.count);
		
		thing2.showName();
	}
}
