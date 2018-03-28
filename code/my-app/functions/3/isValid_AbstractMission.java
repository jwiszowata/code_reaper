public boolean isValid() {
    return unit != null && !unit.isDisposed() && repeatCount > 0;
}