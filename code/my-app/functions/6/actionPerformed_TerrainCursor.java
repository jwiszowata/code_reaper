public void actionPerformed(ActionEvent ae) {
    active = !active;
    int eventId = active ? ON : OFF;
    ActionEvent blinkEvent = new ActionEvent(this, eventId, "blink");
    fireActionEvent(blinkEvent);
}