public void addAll(ResourceMapping rc) {
    if (rc != null) {
        colorResources.putAll(rc.colorResources);
        fontResources.putAll(rc.fontResources);
        stringResources.putAll(rc.stringResources);
        fafResources.putAll(rc.fafResources);
        szaResources.putAll(rc.szaResources);
        audioResources.putAll(rc.audioResources);
        videoResources.putAll(rc.videoResources);
        imageResources.putAll(rc.imageResources);
    }
}