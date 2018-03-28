public void divertModelMessages(FreeColGameObject source, FreeColGameObject newSource) {
    final Predicate<ModelMessage> sourcePred = m -> Utils.equals(m.getSourceId(), source.getId());
    synchronized (this.modelMessages) {
        if (newSource == null) {
            removeInPlace(this.modelMessages, sourcePred);
        } else {
            for (ModelMessage m : transform(this.modelMessages, sourcePred)) {
                m.divert(newSource);
            }
        }
    }
}