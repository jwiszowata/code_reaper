public void setMapEditorMenuBar() {
    setJMenuBar(new MapEditorMenuBar(freeColClient, new MenuMouseMotionListener(freeColClient, canvas)));
}