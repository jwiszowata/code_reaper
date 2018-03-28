public SimpleZippedAnimation getSimpleZippedAnimation(float scale) {
    final SimpleZippedAnimation sza = getSimpleZippedAnimation();
    if (scale == 1.0f) {
        return sza;
    }
    final SimpleZippedAnimation cachedScaledVersion = scaledSzAnimations.get(scale);
    if (cachedScaledVersion != null) {
        return cachedScaledVersion;
    }
    final SimpleZippedAnimation scaledVersion = sza.createScaledVersion(scale);
    scaledSzAnimations.put(scale, scaledVersion);
    return scaledVersion;
}