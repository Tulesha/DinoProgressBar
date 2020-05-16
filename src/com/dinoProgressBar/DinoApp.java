package com.dinoProgressBar;

import com.intellij.openapi.components.BaseComponent;
import kotlin.jvm.internal.Intrinsics;

import javax.swing.*;
import java.util.Map;

public class DinoApp implements BaseComponent {

    @Override
    public void initComponent() {
        updateProgressBarUi();
    }

    private void updateProgressBarUi() {
        UIManager.put("ProgressBarUI", DinoProgressBarUiConnector.class.getName());
        UIDefaults var10000 = UIManager.getDefaults();
        Intrinsics.checkExpressionValueIsNotNull(var10000, "UIManager.getDefaults()");
        ((Map)var10000).put(DinoProgressBarUiConnector.class.getName(), DinoProgressBarUiConnector.class);
    }
}
