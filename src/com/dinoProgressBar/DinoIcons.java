package com.dinoProgressBar;

import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;

public class DinoIcons {
    private final Icon rightDino;
    private final Icon leftDino;

    public DinoIcons() {
        rightDino = createImageIcon("/dinoRight.png");
        leftDino = createImageIcon("/dinoLeft.png");
    }

    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public Icon getRightDino() {
        return rightDino;
    }

    public Icon getLeftDino() {
        return leftDino;
    }

    public int getWidth() {
        return JBUI.scale(32);
    }

    public Color getDinoColor() {
        return new Color(0x66823c);
    }
}
