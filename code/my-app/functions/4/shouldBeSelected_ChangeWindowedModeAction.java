public boolean shouldBeSelected() {
    final GUI gui = getGUI();
    return super.shouldBeSelected() && !(gui == null || gui.isWindowed());
}