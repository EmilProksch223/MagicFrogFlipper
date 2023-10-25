package components.targets;

import visitors.FlipperTargetVisitor;

public class Ramp extends FlipperTarget {
  
    private int pointValue = 140;

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
}