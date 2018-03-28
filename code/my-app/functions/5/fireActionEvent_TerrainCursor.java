public void fireActionEvent(ActionEvent ae) {
    for (ActionListener al : listenerList.getListeners(ActionListener.class)) {
        al.actionPerformed(ae);
    }
}