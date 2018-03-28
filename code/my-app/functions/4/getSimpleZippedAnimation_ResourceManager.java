public static SimpleZippedAnimation getSimpleZippedAnimation(final String key, final float scale) {
    final SZAResource r = getSZAResource(key);
    return (r != null) ? r.getSimpleZippedAnimation(scale) : null;
}