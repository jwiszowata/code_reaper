public void preload() {
    synchronized (loadingLock) {
        if (image == null) {
            BufferedImage baseImage = loadImage(getResourceLocator());
            loadedImages = transform(alternativeLocators, alwaysTrue(), uri -> loadImage(uri), toListNoNulls());
            if (baseImage != null)
                loadedImages.add(baseImage);
            loadedImages.sort(biComp);
            image = (baseImage != null) ? baseImage : first(loadedImages);
        }
    }
}