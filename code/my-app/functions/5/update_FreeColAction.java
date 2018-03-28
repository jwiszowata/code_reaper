public void update() {
    boolean b = shouldBeEnabled();
    if (isEnabled() != b)
        setEnabled(b);
}