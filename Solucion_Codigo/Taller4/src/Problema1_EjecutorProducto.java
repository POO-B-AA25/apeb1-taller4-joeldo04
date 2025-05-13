public class Problema1_EjecutorProducto {

    public static Producto p1;
    public static Producto p2;

    public static void main(String[] args) {
        
        p1 = new Producto(1001, 11);
        p1.calcularDescuento(p1.precioProducto, p1.cantidadProducto);
        p1.calcularPrecioFinal();
        System.out.println(p1);
        
        p2 = new Producto();
        p2.setPrecioP(1200.4);
        p2.setCantidadP(8);
        p2.calcularDescuento(p2.precioProducto, p2.cantidadProducto);
        p2.calcularPrecioFinal();
        System.out.println(p2);
    }
}

class Producto {

    public double precioProducto;
    public int cantidadProducto;
    public double descuento;
    public double precioFinal;

    public Producto() {
    }

    public Producto(double precioP, int cantidadP) {
        this.precioProducto = precioP;
        this.cantidadProducto = cantidadP;
    }

    public void setPrecioP(double precioP) {
        this.precioProducto = precioP;
    }

    public void setCantidadP(int cantidadP) {
        this.cantidadProducto = cantidadP;
    }

    public double calcularDescuento(double precioP, int cantidadP) {
        if (precioP >= 1000 && cantidadP >= 10) {
            this.descuento = 10;
        } else if (precioP < 1000) {
            this.descuento = 5;
        } else {
            this.descuento = 0;
        }
        return this.descuento;
    }

    public double calcularPrecioFinal() {
                this.precioFinal = (this.cantidadProducto * this.precioProducto) - 
                (this.cantidadProducto * this.precioProducto * (this.descuento / 100));
        return this.precioFinal;
    }

    @Override
    public String toString() {
        return "\nProducto" + "\nprecioProducto = " + precioProducto + "\ncantidadProducto = " + 
                cantidadProducto + "\ndescuento = " + descuento + "\nprecioFinal = " + 
                precioFinal;
    }

}
