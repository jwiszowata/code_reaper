public boolean rearrangeColony(Colony colony, List<Unit> workers, Colony scratch) {
    RearrangeColonyMessage message = new RearrangeColonyMessage(colony, workers, scratch);
    return (message.isEmpty()) ? true : ask(colony.getGame(), message);
}