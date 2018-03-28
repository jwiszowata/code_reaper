public void setEnabled(boolean enable) {
    super.setEnabled(enable);
    for (Component child : getComponents()) {
        if (child instanceof CargoLabel)
            child.setEnabled(enable);
    }
}