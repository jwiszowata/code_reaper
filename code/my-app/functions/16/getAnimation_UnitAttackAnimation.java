private SimpleZippedAnimation getAnimation(String startStr, float scale, Direction direction) {
    SimpleZippedAnimation sza;
    String specialId = startStr + direction.toString().toLowerCase();
    sza = ResourceManager.getSimpleZippedAnimation(specialId, scale);
    if (sza != null) {
        mirror = false;
        return sza;
    }
    specialId = startStr + direction.getEWMirroredDirection().toString().toLowerCase();
    sza = ResourceManager.getSimpleZippedAnimation(specialId, scale);
    if (sza != null) {
        mirror = true;
        return sza;
    }
    return null;
}