public static void createResource(URI uri, ResourceSink output) {
    if (findResource(uri, output))
        return;
    try {
        if ("urn".equals(uri.getScheme())) {
            if (uri.getSchemeSpecificPart().startsWith(ColorResource.SCHEME)) {
                ColorResource cr = new ColorResource(uri);
                output.add(cr);
                colorResources.put(uri, new WeakReference<>(cr));
            } else if (uri.getSchemeSpecificPart().startsWith(FontResource.SCHEME)) {
                FontResource fr = new FontResource(uri);
                output.add(fr);
                fontResources.put(uri, new WeakReference<>(fr));
            }
        } else if (uri.getPath().endsWith("\"") && uri.getPath().lastIndexOf('"', uri.getPath().length() - 1) >= 0) {
            StringResource sr = new StringResource(uri);
            output.add(sr);
            stringResources.put(uri, new WeakReference<>(sr));
        } else if (uri.getPath().endsWith(".faf")) {
            FAFileResource far = new FAFileResource(uri);
            output.add(far);
            fafResources.put(uri, new WeakReference<>(far));
        } else if (uri.getPath().endsWith(".sza")) {
            SZAResource szr = new SZAResource(uri);
            output.add(szr);
            szaResources.put(uri, new WeakReference<>(szr));
        } else if (uri.getPath().endsWith(".ttf")) {
            FontResource fr = new FontResource(uri);
            output.add(fr);
            fontResources.put(uri, new WeakReference<>(fr));
        } else if (uri.getPath().endsWith(".wav")) {
            AudioResource ar = new AudioResource(uri);
            output.add(ar);
            audioResources.put(uri, new WeakReference<>(ar));
        } else if (uri.getPath().endsWith(".ogg")) {
            if (uri.getPath().endsWith(".video.ogg")) {
                VideoResource vr = new VideoResource(uri);
                output.add(vr);
                videoResources.put(uri, new WeakReference<>(vr));
            } else {
                AudioResource ar = new AudioResource(uri);
                output.add(ar);
                audioResources.put(uri, new WeakReference<>(ar));
            }
        } else {
            ImageResource ir = new ImageResource(uri);
            output.add(ir);
            imageResources.put(uri, new WeakReference<>(ir));
        }
    } catch (Exception e) {
        logger.log(Level.WARNING, "Failed to create resource with URI: " + uri, e);
    }
}