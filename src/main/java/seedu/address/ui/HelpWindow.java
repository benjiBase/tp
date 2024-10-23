package seedu.address.ui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2425s1-cs2103t-f15-1.github.io/tp/UserGuide.html";
    public static final String HELP_MESSAGE = "Refer to the user guide:";
    private static final String HELP_COMMAND = getPatientCommands() + getTaskCommands() + otherCommands();
    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Label helpMessage;

    @FXML
    private Label helpCommands;

    @FXML
    private Hyperlink userGuideLink;

    /**
     * Creates a new HelpWindow. The HelpWindow will be set at
     * foreground of the MainWindow until closed.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root, Stage mainStage) {
        super(FXML, root);
        root.setAlwaysOnTop(true);

        helpMessage.setText(HELP_MESSAGE);
        helpCommands.setText(HELP_COMMAND);

        userGuideLink.setOnAction(event -> openUserGuide());

        mainStage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (isNowFocused) {
                root.setAlwaysOnTop(true);
            } else {
                root.setAlwaysOnTop(false);
            }
        });
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow(Stage mainStage) {
        this(new Stage(), mainStage);
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Returns the list of patient commands.
     */
    public static String getPatientCommands() {
        return """
                For more information on the commands, please refer to the user guide.
                Alternatively, you can the type commands to view more details and example.

                Here are the list of Patient Commands available:
                1. add (add patient)
                2. delete (delete patient)
                3. emergency (set emergency contact)\s
                4. delemergency (delete emergency contact)
                5. priority (set or edit priority level)
                6. deletelevel (delete priority level)
                7. find (find a person)
                8. list (list all persons)
                9. clear (clear all persons)
                10. sortbypriority (sort Patients by priority level 1 to 3)
                """;
    }

    /**
     * Returns the list of task commands.
     */
    public static String getTaskCommands() {
        return """

                 Here are the list of Patient Commands available:
                1. addtask (add a task)
                2. deletetask (delete task)
                3. findtask (find a task)
                4. listtask (list all tasks)
                5. listincomplete (list incomplete tasks)
                6. marktask (mark a task as complete)
                """;
    }

    /**
     * Returns the list of other commands.
     */
    public static String otherCommands() {
        return """

                 Here are the list of Other Commands available:
                1. help (show help page)
                2. exit (exit the application)
                """;
    }

    /**
     * Opens the user guide in the default browser.
     */
    private void openUserGuide() {
        try {
            Desktop.getDesktop().browse(new URI(USERGUIDE_URL));
        } catch (IOException | URISyntaxException e) {
            logger.warning("Failed to open user guide: " + e.getMessage());
        }
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
