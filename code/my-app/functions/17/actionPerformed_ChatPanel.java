public void actionPerformed(ActionEvent ae) {
    final String command = ae.getActionCommand();
    try {
        switch(Integer.parseInt(command)) {
            case CHAT:
                String message = getChatText();
                igc().sendChat(message);
                getGUI().displayChatMessage(getMyPlayer(), message, false);
                getGUI().removeFromCanvas(this);
                break;
            default:
                super.actionPerformed(ae);
        }
    } catch (NumberFormatException e) {
        logger.warning("Invalid ActionEvent, not a number: " + command);
    }
}