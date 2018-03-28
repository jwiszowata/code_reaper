public static void install(FreeColLookAndFeel fclaf) throws FreeColException {
    try {
        UIManager.setLookAndFeel(fclaf);
        UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
    } catch (UnsupportedLookAndFeelException e) {
        throw new FreeColException("Look and feel install failure", e);
    }
}