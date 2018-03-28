public void updateButtons() {
    this.addStopButton.setEnabled(this.stopListModel.getSize() < this.destinationSelector.getItemCount() - 1);
    this.removeStopButton.setEnabled(this.stopList.getSelectedIndices().length > 0);
}