public boolean duplicateResource(String key, String keyNew) {
    ColorResource cr = colorResources.get(key);
    if (cr != null) {
        return add(keyNew, cr);
    }
    FontResource fr = fontResources.get(key);
    if (fr != null) {
        return add(keyNew, fr);
    }
    StringResource sr = stringResources.get(key);
    if (sr != null) {
        return add(keyNew, sr);
    }
    FAFileResource far = fafResources.get(key);
    if (far != null) {
        return add(keyNew, far);
    }
    SZAResource szr = szaResources.get(key);
    if (szr != null) {
        return add(keyNew, szr);
    }
    AudioResource ar = audioResources.get(key);
    if (ar != null) {
        return add(keyNew, ar);
    }
    VideoResource vr = videoResources.get(key);
    if (vr != null) {
        return add(keyNew, vr);
    }
    ImageResource ir = imageResources.get(key);
    if (ir != null) {
        return add(keyNew, ir);
    }
    return false;
}