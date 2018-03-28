public void initialize(Game game, boolean admin, Nation nation) {
    if (nation == null)
        throw new RuntimeException("Null nation");
    this.initialize(game);
    this.name = nation.getRulerName();
    this.admin = admin;
    this.nationId = nation.getId();
    this.immigration = 0;
    if (nation.isUnknownEnemy()) {
        this.nationType = null;
        this.playerType = PlayerType.COLONIAL;
        this.europe = null;
        this.monarch = null;
        this.gold = 0;
        this.setAI(true);
        this.setReady(true);
    } else if (nation.getType() != null) {
        this.nationType = nation.getType();
        try {
            addFeatures(nationType);
        } catch (Throwable error) {
            error.printStackTrace();
        }
        if (nationType.isEuropean()) {
            this.playerType = (nationType.isREF()) ? PlayerType.ROYAL : PlayerType.COLONIAL;
            this.europe = new ServerEurope(game, this);
            initializeHighSeas();
            if (this.playerType == PlayerType.COLONIAL) {
                this.monarch = new Monarch(game, this);
                final Specification spec = game.getSpecification();
                this.immigration = spec.getInteger(GameOptions.PLAYER_IMMIGRATION_BONUS);
            }
            this.gold = 0;
        } else {
            this.playerType = PlayerType.NATIVE;
            this.gold = Player.GOLD_NOT_ACCOUNTED;
        }
    } else {
        throw new RuntimeException("Bogus nation: " + nation);
    }
    this.market = new Market(getGame(), this);
    this.liberty = 0;
    this.currentFather = null;
}