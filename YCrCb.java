class YCrCb {
    double Y = 0.0;
    double Cr = 0.0;
    double Cb = 0.0;
    
    public static YCrCb RGB2YCbCr(double R, double G, double B) {
        YCrCb result = new YCrCb();
        result.Y  = (0.257*R) + (0.504*G) + (0.098*B) + 16; 
        result.Cr = (0.439*R) - (0.368*G) - (0.071*B) + 128;
        result.Cb = -(0.148*R)- (0.291*G) + (0.439*B) + 128;
        return result;
    }
}

// Like in RGB case, let's get out of the function as
// fast as possible to avoid unnecessary multiplications. 
public static boolean isSkinYCbCr(double r, double g, double b) {
    YCrCb result = YCrCb.RGB2YCbCr(r, g, b);
    double cr = result.Cr;
    double cb = result.Cb;
    if (cr >= ((1.5862*cb) + 20)) {
        return false;
    }
    if (cr <= ((0.3448*cb) + 76.2069)) {
        return false;
    }
    if (cr <= ((-4.5652*cb) + 234.5652)) {
        return false;
    }
    if (cr >= ((-1.15*cb) + 301.75)) {
        return false;
    }
    if (cr >= ((-2.2857*cb) + 432.85)) {
        return false;
    }
    // all comparisons passed
    return true;
}
