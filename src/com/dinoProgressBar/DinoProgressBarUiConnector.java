package com.dinoProgressBar;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;

public class DinoProgressBarUiConnector {
    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent component) {
        return new DinoProgressBarUi();
    }
}
