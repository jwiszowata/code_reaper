public void update() {
    for (Option o : getOptions()) ((FreeColAction) o).update();
}