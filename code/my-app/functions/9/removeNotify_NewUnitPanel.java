public void removeNotify() {
    super.removeNotify();
    removeAll();
    for (JButton jb : buttons) {
        if (jb != null)
            jb.setLayout(null);
    }
    buttons.clear();
}