private static void requireRumourNothingKeys() {
    synchronized (rumourNothingLock) {
        if (rumourNothingKeys == null) {
            rumourNothingKeys = new ArrayList<>();
            collectKeys("model.lostCityRumour.nothing.", rumourNothingKeys, Messages.DESCRIPTION_SUFFIX);
        }
    }
}