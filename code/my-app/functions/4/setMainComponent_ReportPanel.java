protected void setMainComponent(Component main) {
    remove(scrollPane);
    add(main, SCROLL_PANE_SIZE);
}