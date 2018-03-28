protected void addButtonComponents(Container container, Object[] buttons, int initialIndex) {
    if (buttons == null)
        return;
    if (0 <= initialIndex && initialIndex < buttons.length) {
        JButton b = newButtons[initialIndex];
        this.initialFocusComponent = b;
        b.addHierarchyListener((HierarchyEvent e) -> {
            if ((e.getChangeFlags() & HierarchyEvent.PARENT_CHANGED) != 0) {
                JButton button = (JButton) e.getComponent();
                JRootPane root = SwingUtilities.getRootPane(button);
                if (root != null)
                    root.setDefaultButton(button);
            }
        });
    }
    if (okIndex >= 0) {
        if (cancelIndex >= 0) {
            container.add(newButtons[cancelIndex], "tag cancel");
        }
        container.add(newButtons[okIndex], "tag ok");
        for (int i = 0; i < buttons.length; i++) {
            if (i == okIndex || i == cancelIndex)
                continue;
            container.add(newButtons[i]);
        }
    } else {
        for (int i = 0; i < buttons.length; i++) {
            if (i == cancelIndex)
                continue;
            container.add(newButtons[i]);
        }
        if (cancelIndex >= 0) {
            container.add(newButtons[cancelIndex], "newline 20, tag cancel");
        }
    }
    Dimension prefer = container.getPreferredSize();
    prefer = new Dimension((int) (prefer.getWidth() + 100), (int) prefer.getHeight());
    container.setMinimumSize(prefer);
    container.setPreferredSize(prefer);
}