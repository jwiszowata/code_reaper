public WorkLocation getWorkLocation() {
    return (isInColony()) ? (WorkLocation) getLocation() : null;
}