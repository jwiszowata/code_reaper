public java.util.Map<String, Region> getFixedRegions() {
    HashMap<String, Region> result = new HashMap<>();
    for (Region r : getRegions()) {
        String n = r.getKey();
        if (n != null)
            result.put(n, r);
    }
    return result;
}