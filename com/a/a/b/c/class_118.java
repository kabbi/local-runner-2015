package com.a.a.b.c;

import com.a.a.b.c.class_116;
import com.a.a.b.c.class_119;
import com.codeforces.commons.geometry.Point2D;
import com.codeforces.commons.math.Math;
import com.codeforces.commons.text.StringUtil;

// $FF: renamed from: com.a.a.b.c.d
public class class_118 extends class_116 {
    // $FF: renamed from: a double
    private final double field_479;
    // $FF: renamed from: b double
    private final double field_480;
    // $FF: renamed from: c double
    private final double field_481;
    // $FF: renamed from: d double
    private double field_482;
    // $FF: renamed from: e double
    private double field_483;
    // $FF: renamed from: f java.lang.Double
    private Double field_484;
    // $FF: renamed from: g java.lang.Double
    private Double field_485;

    public class_118(double var1, boolean var3) {
        super(class_119.field_488, var3);
        if(!Double.isNaN(var1) && !Double.isInfinite(var1) && var1 > 0.0D) {
            this.field_479 = var1;
            this.field_480 = var1 / 2.0D;
            this.field_481 = var1 * var1 / 12.0D;
        } else {
            throw new IllegalArgumentException(String.format("Argument \'length\' should be positive finite number but got %s.", new Object[]{Double.valueOf(var1)}));
        }
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double, double) com.codeforces.commons.geometry.Point2D
    public Point2D method_779(Point2D var1, double var2, double var4) {
        this.method_781(var2, var4);
        return new Point2D(var1.getX() - this.field_484, var1.getY() - this.field_485);
    }

    // $FF: renamed from: b (com.codeforces.commons.geometry.Point2D, double, double) com.codeforces.commons.geometry.Point2D
    public Point2D method_780(Point2D var1, double var2, double var4) {
        this.method_781(var2, var4);
        return new Point2D(var1.getX() + this.field_484, var1.getY() + this.field_485);
    }

    // $FF: renamed from: d () double
    public double method_765() {
        return this.field_480;
    }

    // $FF: renamed from: a (com.codeforces.commons.geometry.Point2D, double) com.codeforces.commons.geometry.Point2D
    public Point2D method_766(Point2D var1, double var2) {
        return var1;
    }

    // $FF: renamed from: a (double) double
    public double method_768(double var1) {
        return var1 * this.field_481;
    }

    public String toString() {
        return StringUtil.toString(this, false, "length");
    }

    // $FF: renamed from: b (double, double) void
    private void method_781(double var1, double var3) {
        if(this.field_484 == null || this.field_485 == null || var1 != this.field_482 || var3 != this.field_483) {
            if(!Double.isNaN(var1) && !Double.isInfinite(var1)) {
                if(!Double.isNaN(var3) && !Double.isInfinite(var3) && var3 >= 1.0E-100D && var3 <= 1.0D) {
                    this.field_482 = var1;
                    this.field_483 = var3;
                    if(Math.abs(this.field_479) < var3) {
                        this.field_484 = 0.0D;
                        this.field_485 = 0.0D;
                    } else {
                        if(Math.abs(1.5707963267948966D - Math.abs(var1)) < var3) {
                            this.field_484 = 0.0D;
                        } else {
                            this.field_484 = method_770(Math.cos(var1), var3) * this.field_480;
                        }

                        if(Math.abs(3.141592653589793D - Math.abs(var1)) >= var3 && Math.abs(var1) >= var3) {
                            this.field_485 = method_770(Math.sin(var1), var3) * this.field_480;
                        } else {
                            this.field_485 = 0.0D;
                        }

                    }
                } else {
                    throw new IllegalArgumentException("Argument \'epsilon\' should be between 1.0E-100 and 1.0.");
                }
            } else {
                throw new IllegalArgumentException("Argument \'angle\' is not a finite number.");
            }
        }
    }
}
