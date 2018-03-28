private JButton makeButton(String direction, String arrow) {
    JButton button = new JButton(am.getFreeColAction("moveAction." + direction));
    button.setFont(arrowFont);
    button.setText(arrow);
    return button;
}