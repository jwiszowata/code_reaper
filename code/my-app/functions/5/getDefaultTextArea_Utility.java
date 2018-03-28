public static JTextArea getDefaultTextArea(String text, Dimension size) {
    JTextArea textArea = createTextArea(text);
    textArea.setPreferredSize(size);
    return textArea;
}