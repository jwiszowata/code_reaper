public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() != 2)
        return;
    Destination d = destinationList.getSelectedValue();
    if (d != null)
        setValue(first(options));
}