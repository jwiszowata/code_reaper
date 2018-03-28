public int getTransportPriority() {
    return (hasMission()) ? super.getTransportPriority() : 0;
}