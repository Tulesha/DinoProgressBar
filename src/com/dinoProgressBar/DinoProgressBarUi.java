package com.dinoProgressBar;

import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class DinoProgressBarUi extends BasicProgressBarUI {
    private int dinoX = 0;
    private int velocity = 1;
    private final DinoIcons dinoIcons = new DinoIcons();


    private void updateX(int maxX) {
        dinoX += velocity;
        if (dinoX <= 0) {
            dinoX = 0;
            velocity = 1;
        } else if (dinoX >= maxX - dinoIcons.getWidth()) {
            dinoX = maxX - dinoIcons.getWidth();
            velocity = -1;
        }
    }

    private void drawIcon(Graphics2D graphics2D, JComponent component) {
        if (velocity > 0) {
            var scaledIcon = dinoIcons.getRightDino();
            scaledIcon.paintIcon(component, graphics2D, dinoX, -JBUI.scale(6));
        } else if (velocity < 0) {
            var scaledIcon = dinoIcons.getLeftDino();
            scaledIcon.paintIcon(component, graphics2D, dinoX, -JBUI.scale(6));
        }
    }

    private void drawBackGround(Graphics2D graphics2D, JComponent component) {
        var r = new Rectangle(progressBar.getSize());
        graphics2D.setPaint(dinoIcons.getDinoColor());
        graphics2D.fill(new RoundRectangle2D.Float(0f, 0f, r.width, r.height, 0f, 0f));
    }

    @Override
    public Dimension getPreferredSize(JComponent component) {
        return new Dimension(super.getPreferredSize(component).width, JBUI.scale(20));
    }

    @Override
    public void paint(Graphics graphics, JComponent component) {
        var graphics2D = (Graphics2D) graphics.create();
        updateX(component.getWidth());
        drawBackGround(graphics2D, component);
        drawIcon(graphics2D, component);
    }
}
