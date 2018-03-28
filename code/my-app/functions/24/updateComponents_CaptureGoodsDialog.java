private void updateComponents() {
    int selectedCount = 0;
    for (int i = 0; i < this.goodsList.getModel().getSize(); i++) {
        GoodsItem gi = this.goodsList.getModel().getElementAt(i);
        if (gi.isSelected())
            selectedCount++;
    }
    if (selectedCount >= this.maxCargo) {
        this.allButton.setEnabled(false);
        for (int i = 0; i < this.goodsList.getModel().getSize(); i++) {
            GoodsItem gi = this.goodsList.getModel().getElementAt(i);
            if (!gi.isSelected())
                gi.setEnabled(false);
        }
    } else {
        this.allButton.setEnabled(true);
        for (int i = 0; i < this.goodsList.getModel().getSize(); i++) {
            GoodsItem gi = this.goodsList.getModel().getElementAt(i);
            if (!gi.isSelected())
                gi.setEnabled(true);
        }
    }
    goodsList.repaint();
}