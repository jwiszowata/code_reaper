public static JTextArea getDefaultTextArea(String text, int columns) {
    JTextArea textArea = createTextArea(text);
    textArea.setColumns(columns);
    textArea.setSize(textArea.getPreferredSize());
    return textArea;
}