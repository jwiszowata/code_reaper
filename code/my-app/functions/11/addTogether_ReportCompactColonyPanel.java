private void addTogether(List<? extends JComponent> components) {
    if (components.isEmpty()) {
        reportPanel.add(new JLabel());
        return;
    }
    String layout = (components.size() > 1) ? "split " + components.size() : null;
    for (JComponent jc : components) {
        reportPanel.add(jc, layout);
        layout = null;
    }
}