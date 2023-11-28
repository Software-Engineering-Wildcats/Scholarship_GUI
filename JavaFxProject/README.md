## Getting Started

Welcome to the frontend prototype of the UASAMS.

## VSCode Structure

You must have installed JavaFX. Check out https://openjfx.io/
You must add a settings in your `.vscode/launch.json` to run the project outside of the jar file.

Click on "Run" at the top bar of your VS Code and select "Add Configuration."

Add `,"vmArgs": "--module-path \"<path/to/local/path/of/JAVAFX/lib\" --add-modules javafx.controls,javafx.fxml"` after the "projectName" field.

## JAR Execution

The JAR file can only be ran if the batch file is ran. In your file explorer with the folder to this project open, doouble click on the `JarExe.bat` and the JAR file should open.
