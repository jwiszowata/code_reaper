public int getNumberOfPorts() {
    return (!isEuropean()) ? 0 : count(getColonies(), Colony::isConnectedPort);
}