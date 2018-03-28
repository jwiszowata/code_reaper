public void itemStateChanged(ItemEvent event) {
    if (event.getSource() == this.compactBox) {
        updateDetailView();
        updateCompact(this.compactBox.isSelected());
    } else if (event.getSource() == this.showAllBox) {
        updateAllLists();
        updateLists(this.showAllBox.isSelected());
    }
}