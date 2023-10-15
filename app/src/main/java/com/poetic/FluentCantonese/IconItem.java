package com.poetic.FluentCantonese;

import androidx.annotation.Nullable;

public class IconItem {
    private int iconResId;
    private String name;

    private int numLesson;

    public IconItem(int iconResId, int numLesson) {
        this.iconResId = iconResId;
        this.name = "Lesson " + numLesson;
        this.numLesson = numLesson;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getName() {
        return name;
    }

    public int getNumLesson() {
        return numLesson;
    }
}
