private void deleteCurrentlySelectedStops() {
    int count = 0;
    int lastIndex = 0;
    for (int index : this.stopList.getSelectedIndices()) {
        this.stopListModel.remove(index - count);
        count++;
        lastIndex = index;
    }
    if (this.stopListModel.getSize() > 0) {
        this.stopList.setSelectedIndex(lastIndex - count + 1);
    }
}