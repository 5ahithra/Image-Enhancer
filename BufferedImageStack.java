import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.Arrays;

//import java.awt.image.BufferedImage;
import java.util.EmptyStackException;

// Chi-Chi Nwosu & Sahithra 4th Period
// BufferedImageStack.java
// Purpose: Create a stack of BufferedImage objects using an array.

/* Create a new class, in a separate file named BufferedImageStack.java. This class
must implement a stack of BufferedImage objects, and you must not import the
built-in Stack class, but rather you will utilize an array to hold the elements of your
buffered image stack. When a new instance of your BufferedImageStack class is
created, the array should be given a size of 2.*/


public class BufferedImageStack {
	private BufferedImage[] intArr; // Array to hold BufferedImage objects
	private int size; // Number of elements currently in the stack

	public BufferedImageStack() {
		intArr = new BufferedImage[2]; // Initialize the array with a size of 2
		size = 0; // Initialize the size to 0
	}

	/*push(BufferedImage someBufferedImage): enters the buffered image onto
	the stack and returns nothing. If this would exceed the capacity of the array,
	then a new array should be allocated having double the size of the old array,
	and the old array's elements copied to the new array.*/
	
	public void push(BufferedImage x) {
		// Check if the array is full
		if (size == intArr.length) {
			// Create a new array with double the size of the old one
			BufferedImage[] newIntArr = new BufferedImage[intArr.length * 2];
			// Copy the elements from the old array to the new one
			for (int i = 0; i < size; i++) {
				newIntArr[i] = intArr[i];
			}
			// Update the reference to the new array
			intArr = newIntArr;
		}
		// Add the new BufferedImage to the stack
		intArr[size] = x;
		size++;
	}

	
	public BufferedImage pop() {
		// Check if the stack is empty
		if (isEmpty()) {
			throw new EmptyStackException(); // Throw an exception if it's empty
		}
		size--;
		return intArr[size]; // Return and remove the top element
	}

	


		/*throws an exception if the stack is empty; otherwise returns the top
buffered image, removing it from the stack. The exception should be an
instance of java.util.EmptyStackException. In this assignment, you are not
required to ever replace a large array by a smaller array when the number of
stack elements decreases because of pop operations.*/
		
		
		
	//isEmpty(): returns true if there are no items in the stack; false otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	
	/*get(int index): returns the buffered image at the position given by the index.
	(This is not commonly available in a stack, but it facilitates the testing by our
	autograder.) If the index is out of range, the method should throw an
	IndexOutOfBounds exception. (Note: get(0) gets the bottom element of the
	stack -- the one that was pushed in first, but not yet popped out.)*/
	public BufferedImage get(int index) {
		// Check if the index is out of bounds
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index Out Of Bounds");
		}
		return intArr[index];
	}


	
	//getSize(): returns the number elements currently in the stack.
	public int getSize() {
		return size;
	}
	

	
	/*getArraySize(): returns the current size of the array being used to hold the
	stack elements. Like the get operation, this is not a normal stack operation,
	but may be used by the grading software to assure compliance with the
	specifications.*/
	public int getArraySize() {
		return intArr.length;

	}
	
}
