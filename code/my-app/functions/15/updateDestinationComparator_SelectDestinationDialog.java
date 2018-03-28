private void updateDestinationComparator() {
    final Player player = getMyPlayer();
    switch(this.comparatorBox.getSelectedIndex()) {
        case 1:
            this.destinationComparator = new NameComparator(player);
            break;
        case 2:
            this.destinationComparator = new DistanceComparator(player);
            break;
        case 0:
        default:
            this.destinationComparator = new DestinationComparator(player);
            break;
    }
}