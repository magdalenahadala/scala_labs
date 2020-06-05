package converter

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.control.Button
import scalafx.scene.control.Label
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.text.Text
import javafx.event.EventHandler
import javafx.event.ActionEvent

object converter extends JFXApp {
  
  val Data: TextField = new TextField() {
    style = "-fx-font: 12 ariel;"
    layoutX = 20;
    layoutY = 20;
  }

  val Result: Label = new Label() {
    style = "-fx-font: 12 ariel;"
    layoutX = 20
    layoutY = 140
  }

  val CelsiusButton: Button = new Button("Convert to Celsius") {
    style = "-fx-font: 12 ariel;"
    layoutX = 20
    layoutY = 60
    onAction = new EventHandler[ActionEvent] {
      override def handle(event: ActionEvent) {
        val output = Data.text.value
        Result.text = ((output.toDouble - 32.0) *5.0 / 9.0).toString;
      }
    }
  }

  val FahrenheitButton: Button = new Button("Convert to Fahrenheits") {
    style = "-fx-font: 12 ariel;"
    layoutX = 20
    layoutY = 100
    onAction = new EventHandler[ActionEvent] {
      override def handle(event: ActionEvent) {
        val output = Data.text.value
        Result.text = (output.toDouble *9.0 / 5.0 + 32).toString;
      }
    }
  }

  stage = new JFXApp.PrimaryStage {
    title.value = "Degree Converter"
    scene = new Scene(270, 180) {
      fill = LightGreen
      content = List(Data,Result,CelsiusButton,FahrenheitButton)
    }
  }
}