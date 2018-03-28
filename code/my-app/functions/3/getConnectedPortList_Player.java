public List<Colony> getConnectedPortList() {
    return (!isEuropean()) ? Collections.<Colony>emptyList() : transform(getColonies(), Colony::isConnectedPort);
}