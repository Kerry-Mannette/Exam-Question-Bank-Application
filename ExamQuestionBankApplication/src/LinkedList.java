import java.io.FileWriter;
import java.io.IOException;

public class LinkedList {
    Node head;
    int size;


    LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * <h1>The addQuestion method</h1>
     * <h2>Description</h2>
     * <p>Add new questions to the linked list</p>
     * @param question
     */
    void addQuestion(NodeData question) {
        Node newNode = new Node(question);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }


    /**
     * <h1>The shuffleQuestions method</h1>
     * <h2>Description</h2>
     * <p>Shuffles the question so that
     * the user will have new one everytime.</p>
     */
    void shuffleQuestions() {
        Node temp = head;
        while (temp != null) {
            Node randomNode = head;
            int swapCount = (int)(Math.random() * 5); // Simple swap logic
            while (swapCount > 0 && randomNode.next != null) {
                randomNode = randomNode.next;
            }

            // Swap data instead of changing node structure
            String tempText = temp.data.question;
            String[] tempSolutions = temp.data.options;
            String tempAnswer = temp.data.correctAnswer;

            temp.data.question = randomNode.data.question;
            temp.data.options = randomNode.data.options;
            temp.data.correctAnswer = randomNode.data.correctAnswer;

            randomNode.data.question = tempText;
            randomNode.data.options = tempSolutions;
            randomNode.data.correctAnswer = tempAnswer;

            temp = temp.next;
        }
    }

    /**
     * <h1>The saveToFile method</h1>
     * <h2>Description</h2>
     * <p>Save questions to file</p>
     */
    void saveToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            Node temp = head;
            while (temp != null) {
                writer.write(temp.data.question + "\n");
                for (String option : temp.data.options) {
                    writer.write(option + "\n");
                }
                writer.write("Correct: " + temp.data.correctAnswer + "\n\n");
                temp = temp.next;
            }
            System.out.println("Questions saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }


}
