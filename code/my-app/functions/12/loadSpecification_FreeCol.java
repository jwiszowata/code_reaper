public static Specification loadSpecification(FreeColTcFile tcf, Advantages advantages, String difficulty) {
    Specification spec = null;
    try {
        if (tcf != null)
            spec = tcf.getSpecification();
    } catch (IOException ioe) {
        System.err.println("Spec read failed in " + tcf.getId() + ": " + ioe.getMessage() + "\n");
    }
    if (spec != null)
        spec.prepare(advantages, difficulty);
    return spec;
}