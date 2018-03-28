private void addTileItem(final Tile tile) {
    if (tile != null) {
        JMenuItem menuItem = new JMenuItem(Messages.getName(tile));
        menuItem.addActionListener((ActionEvent ae) -> {
            gui.showTilePanel(tile);
        });
        this.add(menuItem);
    }
}