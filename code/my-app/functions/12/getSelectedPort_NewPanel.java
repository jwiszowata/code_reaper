private int getSelectedPort(JTextField field) {
    int port;
    try {
        port = Integer.parseInt(field.getText());
    } catch (NumberFormatException e) {
        port = -1;
    }
    if (0 < port && port < 0x10000)
        return port;
    field.setForeground(Color.red);
    return -1;
}