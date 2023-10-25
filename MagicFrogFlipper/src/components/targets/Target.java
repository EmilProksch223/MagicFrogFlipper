package components.targets;

import visitors.FlipperTargetVisitor;

public class Target extends FlipperTarget {

    private static int pointValue = 100;
    @Override
    public void accept(FlipperTargetVisitor flipperTargetVisitor) {
        flipperTargetVisitor.visit(this);
    }

    @Override
    public int getPointValue() {
        return pointValue;
    }

    @Override
    public void playEvent() {}

    public static void setPointValue(double multiplier) {
        pointValue = (int)(pointValue * multiplier);
    }
}