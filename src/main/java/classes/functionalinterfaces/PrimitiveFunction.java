package classes.functionalinterfaces;

import static java.lang.System.*;

public class PrimitiveFunction {
    public static void main(String[] args) {
        short[] shortArray = {1, 2, 3, 4, 5};
        byte[] r = new PrimitiveFunction().transformArray(shortArray, (s) -> Byte.parseByte(String.valueOf(s)));
        out.println(r.length);
    }

    public byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }
}
