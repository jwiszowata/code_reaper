public static Video getVideo(final String key) {
    final VideoResource r = getVideoResource(key);
    return (r != null) ? r.getVideo() : null;
}