private static Specification getTCSpecification() {
    Specification spec = loadSpecification(getTCFile(), getAdvantages(), getDifficulty());
    if (spec == null) {
        fatal(StringTemplate.template("cli.error.badTC").addName("%tc%", getTC()));
    }
    return spec;
}