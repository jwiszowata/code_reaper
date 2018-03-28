public void installLookAndFeel(String fontName) throws FreeColException {
    FreeColLookAndFeel fclaf = new FreeColLookAndFeel();
    FreeColLookAndFeel.install(fclaf);
    Font font = FontLibrary.createMainFont(fontName, imageLibrary.getScaleFactor());
    FreeColLookAndFeel.installFont(font);
    Utility.initStyleContext(font);
}