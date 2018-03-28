public boolean isDirectlyHighSeasConnected() {
    return (moveToEurope != null) ? moveToEurope : (type == null) ? false : type.isDirectlyHighSeasConnected();
}