private void addResetAction(JButton button) {
    button.addActionListener((ActionEvent ae) -> {
        getOptionUI().reset();
    });
}