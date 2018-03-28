public boolean isValid() {
    return super.isValid() && destination != null && destination.canAdd(getUnit());
}