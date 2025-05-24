public class NodeData {
    String question;
    String[] options;
    String correctAnswer;

    /**
     * <h1></h1>
     * @param question
     * @param options
     * @param correctAnswer
     */
    NodeData(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }


}
