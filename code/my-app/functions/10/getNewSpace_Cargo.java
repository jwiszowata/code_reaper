public int getNewSpace() {
    if (!isValid())
        return 0;
    int ret = 0;
    ret += (getMode().isCollection()) ? getTransportable().getSpaceTaken() : -getTransportable().getSpaceTaken();
    if (hasWrapped()) {
        ret += sum(wrapped, Cargo::getNewSpace);
    }
    return ret;
}