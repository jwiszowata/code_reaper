public boolean shouldBeEnabled() {
    final GUI gui = getGUI();
    return super.shouldBeEnabled() && !(gui == null || gui.isShowingSubPanel());
}