private void addTile(final Tile tile) {
    JMenuItem menuItem = new JMenuItem(Messages.getName(tile));
    menuItem.addActionListener((ActionEvent ae) -> {
        gui.showTilePanel(tile);
    });
    add(menuItem);
}