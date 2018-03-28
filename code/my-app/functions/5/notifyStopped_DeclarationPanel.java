private void notifyStopped() {
    for (ActionListener actionListener : actionListeners) {
        actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ANIMATION_STOPPED));
    }
}