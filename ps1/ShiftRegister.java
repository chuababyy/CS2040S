///////////////////////////////////
// This is the main shift register class.
// Notice that it implements the ILFShiftRegister interface.
// You will need to fill in the functionality.
///////////////////////////////////

import java.util.Arrays;

/**
 * class ShiftRegister
 * @author
 * Description: implements the ILFShiftRegister interface.
 */
public class ShiftRegister implements ILFShiftRegister {
    ///////////////////////////////////
    // Create your class variables here
    ///////////////////////////////////
    // TODO:
    int[] register;
    int size1;
    int tap1;
    ///////////////////////////////////
    // Create your constructor here:
    ///////////////////////////////////
    ShiftRegister(int size, int tap) {
        // TODO:
        if (tap >= size) {
            System.out.println("Error: Tap cannot be larger than size");

        }
        if (tap < 0 || size < 0) {
            System.out.println("Error: Tap or size cannot be negative");
        }
        size1 = size;
        tap1 = tap;

    }

    ///////////////////////////////////
    // Create your class methods here:
    ///////////////////////////////////
    /**
     * setSeed
     * @param seed
     * Description:
     */
    @Override
    public void setSeed(int[] seed) {
        // TODO:
        register = seed;
        boolean truth = true;
        for (int i = 0; i < seed.length; i++) {
           if (truth = false) {
               System.out.println("Error: seed contains value other than 0 or 1");
           } else {
               int bit = seed[i];
               if (bit != 0 || bit != 1) {
                   truth = false;
               }
           }
        }
        System.out.println(register);
    }

    /**
     * shift
     * @return
     * Description:
     */
    @Override
    public int shift() {
        // TODO:
        int mostsigbit = register[size1 - 1];
        int tapbit = register[tap1];
        int feedbackbit = mostsigbit ^ tapbit;
        for (int i = size1 - 2; i >= 0; i--) {
            register[i + 1] = register[i];
        }
        register[0] = feedbackbit;
        return register[0];
    }

    /**
     * generate
     * @param k
     * @return
     * Description:
     */
    @Override
    public int generate(int k) {
        // TODO:
        int[] store = new int[k];
        for (int i = 0; i < k; i++) {
            store[i] = shift();
        }
        int gen = 0;
        for (int i = 0; i < k; i++) {
            gen = (int)(gen + Math.pow(2, i) * store[k - 1 - i]);
//            System.out.println(gen);
        }
        return gen;
    }

    /**
     * Returns the integer representation for a binary int array.
     * @param array
     * @return
     */
    private int toDecimal(int[] array) {
        // TODO:
        return 0;
    }
}
