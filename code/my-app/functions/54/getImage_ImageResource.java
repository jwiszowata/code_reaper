public BufferedImage getImage(Dimension d) {
    BufferedImage im = getImage();
    if (im == null)
        return null;
    int wNew = d.width;
    int hNew = d.height;
    if (wNew < 0 && hNew < 0)
        return im;
    int w = im.getWidth();
    int h = im.getHeight();
    if (wNew < 0 || (!(hNew < 0) && wNew * h > w * hNew)) {
        wNew = (2 * w * hNew + (h + 1)) / (2 * h);
    } else if (hNew < 0 || wNew * h < w * hNew) {
        hNew = (2 * h * wNew + (w + 1)) / (2 * w);
    }
    if (wNew == w && hNew == h)
        return im;
    final BufferedImage cached = scaledImages.get(d);
    if (cached != null)
        return cached;
    final int fwNew = wNew, fhNew = hNew;
    final Predicate<BufferedImage> sizePred = img -> img.getWidth() >= fwNew && img.getHeight() >= fhNew;
    BufferedImage oim = find(loadedImages, sizePred);
    im = (oim != null) ? oim : loadedImages.get(loadedImages.size() - 1);
    w = im.getWidth();
    h = im.getHeight();
    if (wNew * h > w * hNew) {
        wNew = (2 * w * hNew + (h + 1)) / (2 * h);
    } else if (wNew * h < w * hNew) {
        hNew = (2 * h * wNew + (w + 1)) / (2 * w);
    }
    if (wNew == w && hNew == h)
        return im;
    while (wNew * 2 <= w && hNew * 2 <= h) {
        w = (w + 1) / 2;
        h = (h + 1) / 2;
        BufferedImage halved = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = halved.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(im, 0, 0, w, h, null);
        g.dispose();
        im = halved;
    }
    if (wNew != w || hNew != h) {
        BufferedImage scaled = new BufferedImage(wNew, hNew, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaled.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.drawImage(im, 0, 0, wNew, hNew, null);
        g.dispose();
        im = scaled;
    }
    scaledImages.put(d, im);
    return im;
}