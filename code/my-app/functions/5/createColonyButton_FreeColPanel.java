public JButton createColonyButton(Colony colony) {
    JButton button = Utility.getLinkButton(colony.getName(), null, colony.getId());
    button.addActionListener(this);
    return button;
}