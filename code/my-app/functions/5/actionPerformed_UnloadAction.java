public void actionPerformed(ActionEvent ae) {
    Unit carrier = getUnit();
    if (carrier != null)
        igc().unload(carrier);
}