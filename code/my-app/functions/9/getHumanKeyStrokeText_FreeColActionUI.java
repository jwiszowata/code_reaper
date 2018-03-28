public static String getHumanKeyStrokeText(KeyStroke keyStroke) {
    if (keyStroke == null) {
        return " ";
    }
    String s = KeyEvent.getKeyModifiersText(keyStroke.getModifiers());
    if (!s.isEmpty())
        s += "+";
    return s + KeyEvent.getKeyText(keyStroke.getKeyCode());
}