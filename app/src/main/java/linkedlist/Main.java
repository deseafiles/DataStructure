import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new Stack<>();
        Stack<Character> stackChar = new Stack<>();
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        int choice, index1, index2;
        Integer intValue;
        Character charValue;

        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Push Integer to Stack");
            System.out.println("2. Push Character to Stack");
            System.out.println("3. Pop from Stack");
            System.out.println("4. Swap elements in Stack");
            System.out.println("5. Peek to Stack");
            System.out.println("6. Enqueue to Queue");
            System.out.println("7. Dequeue from Queue");
            System.out.println("8. Display Stack");
            System.out.println("9. Display Queue");
            System.out.println("10. Swap elements in Queue");
            System.out.println("11. Peek to Queue");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Integer value to push to stack: ");
                    intValue = scanner.nextInt();
                    stackInt.push(intValue);
                    break;
                case 2:
                    System.out.print("Enter Character value to push to stack: ");
                    charValue = scanner.next().charAt(0);
                    stackChar.push(charValue);
                    break;
                case 3:
                    System.out.println("Pop from which stack? (1 for Integer, 2 for Character): ");
                    int stackChoice = scanner.nextInt();
                    if (stackChoice == 1) {
                        try {
                            intValue = stackInt.pop();
                            System.out.println("Popped value from stack (Integer): " + intValue);
                        } catch (EmptyStackException e) {
                            System.out.println("Stack is empty");
                        }
                    } else if (stackChoice == 2) {
                        try {
                            charValue = stackChar.pop();
                            System.out.println("Popped value from stack (Character): " + charValue);
                        } catch (EmptyStackException e) {
                            System.out.println("Stack is empty");
                        }
                    } else {
                        System.out.println("Invalid stack choice");
                    }
                    break;
                case 4:
                    System.out.print("Enter first index to swap in stack: ");
                    index1 = scanner.nextInt();
                    System.out.print("Enter second index to swap in stack: ");
                    index2 = scanner.nextInt();
                    try {
                        if (stackInt.size() > 0) {
                            stackInt.swap(index1, index2);
                            System.out.println("After swap: " + stackInt);
                        } else {
                            stackChar.swap(index1, index2);
                            System.out.println("After swap: " + stackChar);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Exception during swap: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Peek from which stack? (1 for Integer, 2 for Character): ");
                    int stackPeekChoice = scanner.nextInt();
                    if (stackPeekChoice == 1) {
                        try {
                            intValue = stackInt.peek();
                            System.out.println("Top value in stack (Integer): " + intValue);
                        } catch (EmptyStackException e) {
                            System.out.println("Stack is empty");
                        }
                    } else if (stackPeekChoice == 2) {
                        try {
                            charValue = stackChar.peek();
                            System.out.println("Top value in stack (Character): " + charValue);
                        } catch (EmptyStackException e) {
                            System.out.println("Stack is empty");
                        }
                    } else {
                        System.out.println("Invalid stack choice");
                    }
                    break;
                case 6:
                    System.out.print("Enter value to enqueue to queue: ");
                    charValue = scanner.next().charAt(0);
                    queue.enqueue(charValue);
                    break;
                case 7:
                    try {
                        charValue = queue.dequeue();
                        System.out.println("Dequeued value from queue: " + charValue);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 8:
                    System.out.println("Stack (Integer): " + stackInt);
                    System.out.println("Stack (Character): " + stackChar);
                    break;
                case 9:
                    System.out.println("Queue: " + queue);
                    break;
                case 10:
                    System.out.print("Enter first index to swap in queue: ");
                    index1 = scanner.nextInt();
                    System.out.print("Enter second index to swap in queue: ");
                    index2 = scanner.nextInt();
                    try {
                        queue.swap(index1, index2);
                        System.out.println("After swap: " + queue);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Exception during swap: " + e.getMessage());
                    }
                    break;
                case 11:
                    System.out.println("Peek from which queue? (1 for Front, 2 for Rear): ");
                    int queuePeekChoice = scanner.nextInt();
                    if (queuePeekChoice == 1) {
                        try {
                            charValue = queue.peekFront();
                            System.out.println("Front value in queue: " + charValue);
                        } catch (NoSuchElementException e) {
                            System.out.println("Queue is empty");
                        }
                    } else if (queuePeekChoice == 2) {
                        try {
                            charValue = queue.peekRear();
                            System.out.println("Rear value in queue: " + charValue);
                        } catch (NoSuchElementException e) {
                            System.out.println("Queue is empty");
                        }
                    } else {
                        System.out.println("Invalid queue choice");
                    }
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
