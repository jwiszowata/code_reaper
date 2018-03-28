public static JTextArea createTextArea(String text) {
    JTextArea textArea = new JTextArea(text);
    textArea.setOpaque(false);
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setFocusable(false);
    return textArea;
}