public void initializeActions(InGameController inGameController, ConnectController connectController) {
    add(new AboutAction(freeColClient));
    add(new AssignTradeRouteAction(freeColClient));
    add(new BuildColonyAction(freeColClient));
    add(new CenterAction(freeColClient));
    add(new ChangeAction(freeColClient));
    add(new ChangeWindowedModeAction(freeColClient));
    add(new ChatAction(freeColClient));
    add(new ClearOrdersAction(freeColClient));
    for (PanelType panelType : PanelType.values()) {
        add(new ColopediaAction(freeColClient, panelType));
    }
    add(new ContinueAction(freeColClient));
    add(new DebugAction(freeColClient));
    add(new DeclareIndependenceAction(freeColClient));
    add(new DetermineHighSeasAction(freeColClient));
    add(new DisbandUnitAction(freeColClient));
    add(new DisplayBordersAction(freeColClient));
    add(new DisplayGridAction(freeColClient));
    for (DisplayText type : DisplayText.values()) {
        add(new DisplayTileTextAction(freeColClient, type));
    }
    add(new EndTurnAction(freeColClient));
    add(new EuropeAction(freeColClient));
    add(new ExecuteGotoOrdersAction(freeColClient));
    add(new FindSettlementAction(freeColClient));
    add(new FortifyAction(freeColClient));
    add(new GotoAction(freeColClient));
    add(new GotoTileAction(freeColClient));
    add(new LoadAction(freeColClient));
    add(new MapControlsAction(freeColClient));
    add(new MapEditorAction(freeColClient));
    add(new MiniMapToggleViewAction(freeColClient));
    add(new MiniMapToggleViewAction(freeColClient, true));
    add(new MiniMapToggleFogOfWarAction(freeColClient));
    add(new MiniMapToggleFogOfWarAction(freeColClient, true));
    add(new MiniMapZoomInAction(freeColClient));
    add(new MiniMapZoomInAction(freeColClient, true));
    add(new MiniMapZoomOutAction(freeColClient));
    add(new MiniMapZoomOutAction(freeColClient, true));
    for (Direction d : Direction.values()) {
        add(new MoveAction(freeColClient, d));
        add(new MoveAction(freeColClient, d, true));
    }
    add(new NewAction(freeColClient));
    add(new NewEmptyMapAction(freeColClient));
    add(new OpenAction(freeColClient));
    add(new PreferencesAction(freeColClient));
    add(new SaveAndQuitAction(freeColClient));
    add(new QuitAction(freeColClient));
    add(new ReconnectAction(freeColClient));
    add(new RenameAction(freeColClient));
    add(new ReportCargoAction(freeColClient));
    add(new ReportContinentalCongressAction(freeColClient));
    add(new ReportColonyAction(freeColClient));
    add(new ReportEducationAction(freeColClient));
    add(new ReportExplorationAction(freeColClient));
    add(new ReportForeignAction(freeColClient));
    add(new ReportHighScoresAction(freeColClient));
    add(new ReportHistoryAction(freeColClient));
    add(new ReportIndianAction(freeColClient));
    add(new ReportLabourAction(freeColClient));
    add(new ReportMilitaryAction(freeColClient));
    add(new ReportNavalAction(freeColClient));
    add(new ReportProductionAction(freeColClient));
    add(new ReportReligionAction(freeColClient));
    add(new ReportRequirementsAction(freeColClient));
    add(new ReportTradeAction(freeColClient));
    add(new ReportTurnAction(freeColClient));
    add(new RetireAction(freeColClient));
    add(new SaveAction(freeColClient));
    add(new ScaleMapAction(freeColClient));
    add(new SentryAction(freeColClient));
    add(new ShowDifficultyAction(freeColClient));
    add(new ShowGameOptionsAction(freeColClient));
    add(new ShowMainAction(freeColClient));
    add(new ShowMapGeneratorOptionsAction(freeColClient));
    add(new SkipUnitAction(freeColClient));
    add(new StartMapAction(freeColClient));
    add(new TilePopupAction(freeColClient));
    add(new ToggleViewModeAction(freeColClient));
    add(new TradeRouteAction(freeColClient));
    add(new UnloadAction(freeColClient));
    add(new WaitAction(freeColClient));
    add(new ZoomInAction(freeColClient));
    add(new ZoomOutAction(freeColClient));
}