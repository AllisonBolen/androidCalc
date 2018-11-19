package com.example.allisonbolen.calculatorandroid.dummy;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class HistoryContent {
    public static final List<HistoryItem> ITEMS = new ArrayList<HistoryItem>();

    public static void addItem(HistoryItem item) {
        ITEMS.add(item);
    }
    static {
        DateTime now = DateTime.now();
        addItem(new HistoryItem(2.0, 1.829, "Length", "Yards", "Meters", now.minusDays(1)));
        addItem(new HistoryItem(1.0, 3.785, "Volume", "Gallons", "Liters", now.minusDays(1)));
        addItem(new HistoryItem(2.0, 1.829, "Length", "Yards", "Meters", now.plusDays(1)));
        addItem(new HistoryItem(1.0, 3.785, "Volume", "Gallons", "Liters", now.plusDays(1)));
    }



    public static class HistoryItem {
        public final Double fromVal;
        public final Double toVal;
        public final String mode;
        public final String fromUnits;
        public final String toUnits;
        public final String Key;
        public final String timestamp;

        public HistoryItem(){
            this.fromVal = 5.5;
            this.toVal = 0.0034175405;
            this.mode = "Length";
            this.fromUnits = "Meters";
            this.toUnits = "Miles";
            this.Key = "0";
            this.timestamp = DateTime.now().toString();
        }
        public HistoryItem(Double fromVal, Double toVal, String mode,
                           String fromUnits, String toUnits, DateTime timestamp) {
           // DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
            this.fromVal = fromVal;
            this.toVal = toVal;
            this.mode = mode;
            this.fromUnits = fromUnits;
            this.toUnits = toUnits;
            this.timestamp = timestamp.toString();
            this.Key = "1";
        }

        @Override
        public String toString() {
            return this.fromVal + " " + this.fromUnits + " = " + this.toVal + " " + this.toUnits;
        }
    }
}
