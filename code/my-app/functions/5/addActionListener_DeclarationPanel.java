public void addActionListener(ActionListener al) {
    if (!actionListeners.contains(al)) {
        actionListeners.add(al);
    }
}