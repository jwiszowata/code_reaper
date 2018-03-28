public boolean isValid() {
    return super.isValid() && improvement != null && improvement.isWorkerAllowed(getUnit());
}