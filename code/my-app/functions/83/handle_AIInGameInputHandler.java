public synchronized Element handle(Connection connection, Element element) {
    if (element == null)
        return null;
    final Game game = getGame();
    final String tag = element.getTagName();
    try {
        switch(tag) {
            case ChooseFoundingFatherMessage.TAG:
                chooseFoundingFather(new ChooseFoundingFatherMessage(game, element));
                break;
            case DiplomacyMessage.TAG:
                diplomacy(new DiplomacyMessage(game, element));
                break;
            case FirstContactMessage.TAG:
                firstContact(new FirstContactMessage(game, element));
                break;
            case FountainOfYouthMessage.TAG:
                fountainOfYouth(new FountainOfYouthMessage(game, element));
                break;
            case IndianDemandMessage.TAG:
                indianDemand(new IndianDemandMessage(game, element));
                break;
            case LootCargoMessage.TAG:
                lootCargo(new LootCargoMessage(game, element));
                break;
            case MonarchActionMessage.TAG:
                monarchAction(new MonarchActionMessage(game, element));
                break;
            case MultipleMessage.TAG:
                multiple(connection, element);
                break;
            case NationSummaryMessage.TAG:
                nationSummary(new NationSummaryMessage(game, element));
                break;
            case NativeTradeMessage.TAG:
                nativeTrade(new NativeTradeMessage(game, element));
                break;
            case NewLandNameMessage.TAG:
                newLandName(new NewLandNameMessage(game, element));
                break;
            case NewRegionNameMessage.TAG:
                newRegionName(new NewRegionNameMessage(game, element));
                break;
            case TrivialMessage.RECONNECT_TAG:
                logger.info("Reconnect on illegal operation.");
                break;
            case SetAIMessage.TAG:
                setAI(new SetAIMessage(game, element));
                break;
            case SetCurrentPlayerMessage.TAG:
                setCurrentPlayer(new SetCurrentPlayerMessage(game, element));
                break;
            case AddPlayerMessage.TAG:
            case AnimateAttackMessage.TAG:
            case AnimateMoveMessage.TAG:
            case AssignTradeRouteMessage.TAG:
            case ChatMessage.TAG:
            case TrivialMessage.CLOSE_MENUS_TAG:
            case DeleteTradeRouteMessage.TAG:
            case TrivialMessage.DISCONNECT_TAG:
            case ErrorMessage.TAG:
            case FeatureChangeMessage.TAG:
            case GameEndedMessage.TAG:
            case LogoutMessage.TAG:
            case NativeGiftMessage.TAG:
            case NewTurnMessage.TAG:
            case NewTradeRouteMessage.TAG:
            case RemoveMessage.TAG:
            case ScoutSpeakToChiefMessage.TAG:
            case SetDeadMessage.TAG:
            case SetStanceMessage.TAG:
            case TrivialMessage.START_GAME_TAG:
            case UpdateMessage.TAG:
                break;
            default:
                logger.warning("Unknown message type: " + tag);
                break;
        }
    } catch (Exception e) {
        logger.log(Level.WARNING, "AI input handler for " + getMyPlayer() + " caught error handling " + tag, e);
    }
    return null;
}