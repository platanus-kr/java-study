package org.platanus.generics;

public class GenericPrinterTest {
    public static void main(String[] args) {
        GenericPrinter<ABS> absPrinter = new GenericPrinter<>();

        absPrinter.setMaterial(new ABS());
        ABS abs = absPrinter.getMaterial();
        System.out.println(absPrinter);

        GenericPrinter<PBT> pbtPrinter = new GenericPrinter<>();

        pbtPrinter.setMaterial(new PBT());
        PBT pbt = pbtPrinter.getMaterial();
        System.out.println(pbtPrinter);
    }
}
