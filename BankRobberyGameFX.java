package WinterProject;

//javaFX library
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankRobberyGameFX extends Application {

  private TextArea narrativeArea;
  private VBox choiceBox;

  public static void main(String[] args) {
      launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
      primaryStage.setTitle("Bank Robbery Simulator"); //beggining of game

      //main narrative display area
      narrativeArea = new TextArea();
      narrativeArea.setWrapText(true);
      narrativeArea.setEditable(false);
      narrativeArea.setText("Welcome to the Bank Robbery Simulator!\nYour heist begins now.");

      //choice box where buttons for options will appear
      choiceBox = new VBox(10);

      VBox root = new VBox(10, narrativeArea, choiceBox);
      Scene scene = new Scene(root, 600, 400);

      primaryStage.setScene(scene);
      primaryStage.show();

      //first scenario
      presentChoicesForEntry();
  }

  private void presentChoicesForEntry() {
      updateNarrative("You arrive at the bank. How will you break in?\n1. Use a crowbar\n2. Pick the lock");

      Button crowbarButton = new Button("Use a crowbar");
      crowbarButton.setOnAction(event -> handleCrowbarChoice());

      Button pickLockButton = new Button("Pick the lock");
      pickLockButton.setOnAction(event -> handlePickLockChoice());

      updateChoices(crowbarButton, pickLockButton);
  }

  private void handleCrowbarChoice() {
      updateNarrative("You use a crowbar and force the door open. The alarm goes off!\nWhat will you do next?\n1. Run inside and grab the money\n2. Try to disable the alarm");

      Button grabMoneyButton = new Button("Run inside and grab the money");
      grabMoneyButton.setOnAction(event -> handleGrabMoneyChoice());

      Button disableAlarmButton = new Button("Try to disable the alarm");
      disableAlarmButton.setOnAction(event -> handleDisableAlarmChoice());

      updateChoices(grabMoneyButton, disableAlarmButton);
  }

  private void handlePickLockChoice() {
      updateNarrative("You successfully pick the lock and sneak inside.\nYou see a guard approaching. What will you do?\n1. Hide\n2. Confront the guard");

      Button hideButton = new Button("Hide");
      hideButton.setOnAction(event -> handleHideChoice());

      Button confrontGuardButton = new Button("Confront the guard");
      confrontGuardButton.setOnAction(event -> handleConfrontGuardChoice());

      updateChoices(hideButton, confrontGuardButton);
  }

  private void handleGrabMoneyChoice() {
      updateNarrative("You grab the money, but the police arrive outside.\nYou are arrested. Game over.");
      clearChoices();
  }

  private void handleDisableAlarmChoice() {
      updateNarrative("You disable the alarm successfully and escape with the money.\nCongratulations! You win!");
      clearChoices();
  }

  private void handleHideChoice() {
      updateNarrative("You hide behind a desk, and the guard walks past you.\nYou proceed to the vault. What will you do?\n1. Crack the vault\n2. Use explosives");

      Button crackVaultButton = new Button("Crack the vault");
      crackVaultButton.setOnAction(event -> handleCrackVaultChoice());

      Button useExplosivesButton = new Button("Use explosives");
      useExplosivesButton.setOnAction(event -> handleExplosivesChoice());

      updateChoices(crackVaultButton, useExplosivesButton);
  }

  private void handleConfrontGuardChoice() {
      updateNarrative("You confront the guard, but he sounds the alarm.\nThe police arrive and arrest you. Game over.");
      clearChoices();
  }

  private void handleCrackVaultChoice() {
      updateNarrative("You crack the vault and escape with the money.\nCongratulations! You win!");
      clearChoices();
  }

  private void handleExplosivesChoice() {
      updateNarrative("You use explosives, but the noise alerts the police.\nYou are arrested. Game over.");
      clearChoices();
  }

  private void updateNarrative(String text) {
      narrativeArea.setText(text);
  }

  private void updateChoices(Button... buttons) {
      choiceBox.getChildren().clear();
      choiceBox.getChildren().addAll(buttons);
  }

  private void clearChoices() {
      choiceBox.getChildren().clear();
  }
}

