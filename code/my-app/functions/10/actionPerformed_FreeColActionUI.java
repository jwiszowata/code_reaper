public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == recordButton) {
        bl.startBlinking();
        bl.requestFocus();
    } else if (ae.getSource() == removeButton) {
        bl.stopBlinking();
        bl.setText(" ");
        keyStroke = null;
    }
}