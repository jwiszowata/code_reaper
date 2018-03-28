public static Specification getSpecification(String name) {
    Specification result = specifications.get(name);
    if (result == null) {
        FreeColTcFile.loadTCs();
        try {
            FreeColTcFile tc = FreeColTcFile.getFreeColTcFile(name);
            result = FreeCol.loadSpecification(tc, null, "model.difficulty.medium");
            specifications.put(name, result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    return result;
}