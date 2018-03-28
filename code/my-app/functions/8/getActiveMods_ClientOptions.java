public List<FreeColModFile> getActiveMods() {
    ModListOption mlo = (ModListOption) getOption(ClientOptions.USER_MODS);
    if (mlo == null)
        return Collections.<FreeColModFile>emptyList();
    final Predicate<FreeColModFile> validModPred = m -> m != null && m.getId() != null;
    final Function<FreeColModFile, FreeColModFile> modFileMapper = m -> FreeColModFile.getFreeColModFile(m.getId());
    return transform(mlo.getOptionValues(), validModPred, modFileMapper, toListNoNulls());
}