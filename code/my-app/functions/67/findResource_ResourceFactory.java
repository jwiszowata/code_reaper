private static boolean findResource(URI uri, ResourceSink output) {
    final WeakReference<ColorResource> crwr = colorResources.get(uri);
    if (crwr != null) {
        final ColorResource cr = crwr.get();
        if (cr != null) {
            output.add(cr);
            return true;
        }
    }
    final WeakReference<FontResource> frwr = fontResources.get(uri);
    if (frwr != null) {
        final FontResource fr = frwr.get();
        if (fr != null) {
            output.add(fr);
            return true;
        }
    }
    final WeakReference<StringResource> srwr = stringResources.get(uri);
    if (srwr != null) {
        final StringResource sr = srwr.get();
        if (sr != null) {
            output.add(sr);
            return true;
        }
    }
    final WeakReference<FAFileResource> farwr = fafResources.get(uri);
    if (farwr != null) {
        final FAFileResource far = farwr.get();
        if (far != null) {
            output.add(far);
            return true;
        }
    }
    final WeakReference<SZAResource> szrwr = szaResources.get(uri);
    if (szrwr != null) {
        final SZAResource szr = szrwr.get();
        if (szr != null) {
            output.add(szr);
            return true;
        }
    }
    final WeakReference<AudioResource> arwr = audioResources.get(uri);
    if (arwr != null) {
        final AudioResource ar = arwr.get();
        if (ar != null) {
            output.add(ar);
            return true;
        }
    }
    final WeakReference<VideoResource> vrwr = videoResources.get(uri);
    if (vrwr != null) {
        final VideoResource vr = vrwr.get();
        if (vr != null) {
            output.add(vr);
            return true;
        }
    }
    final WeakReference<ImageResource> irwr = imageResources.get(uri);
    if (irwr != null) {
        final ImageResource ir = irwr.get();
        if (ir != null) {
            output.add(ir);
            return true;
        }
    }
    return false;
}