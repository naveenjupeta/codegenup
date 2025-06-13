public static int[] getProductsOfAllIntsExceptAtIndex(int[] list) {
    int[] products = new int[list.length];
    int product = 1;

    for (int i = 0; i < list.length; i++) {
        products[i] = product;
        product *= list[i];
    }

    product = 1;
    for (int i = list.length - 1; i >= 0; i--) {
        products[i] *= product;
        product *= list[i];
    }

    return products;