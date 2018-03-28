public void requestFocus() {
    if (this.pane != null && this.pane.getUI() instanceof FreeColOptionPaneUI) {
        Component c = ((FreeColOptionPaneUI) this.pane.getUI()).getInitialFocusComponent();
        if (c != null) {
            c.requestFocus();
        }
    }
}