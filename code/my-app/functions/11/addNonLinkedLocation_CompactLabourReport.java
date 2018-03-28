private int addNonLinkedLocation(LabourData.LocationData data, String messageKey, int row) {
    int rows = data.getRowCount();
    if (rows > 0) {
        JLabel label = Utility.localizedLabel(messageKey);
        label.setBorder(Utility.LEFTCELLBORDER);
        label.setForeground(Color.GRAY);
        reportPanel.add(label, "cell " + COLONY_COLUMN + " " + row + " 1 " + rows);
        return addLocationData(data, null, row);
    }
    return row;
}