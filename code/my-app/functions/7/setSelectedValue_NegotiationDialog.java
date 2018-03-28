private void setSelectedValue(Stance stance) {
    for (int i = 0; i < stanceBox.getItemCount(); i++) {
        if (stanceBox.getItemAt(i) == stance) {
            stanceBox.setSelectedItem(i);
        }
    }
}