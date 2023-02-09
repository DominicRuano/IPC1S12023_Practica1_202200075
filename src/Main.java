import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public  static Scanner in = new Scanner(System.in).useDelimiter("\n");
    public static  String user = "cajero_202200075", password = "ipc_202200075", nombre, contra,nProducto1,cDescuento1,nombreCliente,nitCliente,
            cupon,parametro,val1;
    public static  String[] nProducto = new String[10], cDescuento = new String[10],copiaNReporte = new String[10];
    public static  int  w = 0,v = 0, seleccion,h = 0,r = 0,t = 0, l = 1,f;
    public static  boolean val = true,val4,val5,val6;
    public static double[] pDescuento = new double[10],pProducto = new double[10],carrito = new double[10],
            copiaReporte = new double[10],copiaReporte1 = new double[10];
    public static double pDescuento1,subtotal,descuento,total1,cantidadCarrito1,pProducto1;


    // validar que la contraseña y el usuario sean correctos.
    public static void credenciales() {
        System.out.print("\n\nIngrese su usuario: ");
        nombre = in.next();

        System.out.print("Ingrese su contraseña: ");
        contra = in.next();
    }

    //menu de opciones para ingresar lo que sea necesario.
    public static void menu() {
        System.out.println("\n***********************************************");
        System.out.println(" ¡Bienvenido al sistema de ventas de SUPER-25!");
        System.out.println("***********************************************\n");
        System.out.println("    1. Agregar nuevos productos \n    2. Agregar nuevos cupones.");
        System.out.println("    3. Realizar ventas. \n    4. Realizar reporte. \n    5. Salir.\n");
        System.out.print("Por favor selecciona una de las opciones para continuar: ");
        parametro = in.next(); // ingreso de variable para Switch#1
    }

    //verifica que el nombre no esté repetido en el array.
    public static void validarNombre() {
        //for para verificar el nombre
        for (int i = 0; i <= w; i++) {
            if (nProducto1.equals(nProducto[i])) {
                val4 = true;
                break;
            }
        }
    }

    //menu para agregar nuevos productos
    public static void agregarProducto() {
        val4 = false;
        System.out.println("\nAgregar un nuevo producto por favor ingrese los siguientes datos: ");
        System.out.print("Ingresa el nombre del producto: ");
        nProducto1 = in.next();//ingreso de nombre en variable temporal para verificar que no este repetido
        System.out.print("Ingresa el precio del producto: ");
        pProducto1 = in.nextDouble();// ingreso de precio en una variable temporal para verificar que sea mayor a 0
        validarNombre();//validacion de nombre
        if (val4){// si esta repetido imprimir esto
            System.out.print("El articulo ya esta en la lista, y no puede ser agregado 2 veces ");
        }else if (pProducto1 < 0){//si el precio es menor a 0 imprimir esto
            System.out.print("El articulo no puede tener un precio menos a 0.");
        }else {//si nada falla imprimir esto
            System.out.println("\nEl nombre del producto es: " + nProducto1);
            System.out.println("El precio es de: Q" + String.format("%.2f",pProducto1) + "\n");
            System.out.print("Ingrese 1 para guardar y salir, 2 para guardar y agregar otro producto o 3 para borrar el producto actual:");
            val1 = in.next();//decicion

            if (val1.equals("1")){
                try {
                    //guardado de las caracteristicas del producto en variables finales
                    pProducto[w] = pProducto1;
                    nProducto[w] = nProducto1;
                    w ++;
                }catch (Exception e){
                    System.out.println("Memoria llena");
                }
                System.out.println("Se ha guardado el articulo.");
            } else if (val1.equals("2")) {
                //se guardan las variables si le elige otra opcion pero esta tiene recursividad
                validarNombre();
                if (!val4){
                    pProducto[w] = pProducto1;
                    nProducto[w] = nProducto1;
                    w ++;
                    //se llama la misma funcion dentro de ella para agregar mas productos
                    agregarProducto();
                }
            } else {//si se quiere borrar se imprime esto y no se guardan los atributos del producto
                System.out.println("Se ha borrado el articulo.");
            }
        }

    }

    //verifica que el cupon no esté repetido en el array.
    public static void validarCupon() {
        //iguala a validar nombre, pero esté válida el codigo del cupon
        for (int i = 0; i <= v; i++) {
            if (cDescuento1.equals(cDescuento[i])) {
                val5 = true;
                break;
            }
        }
    }

    //menu para agregar nuevos cupones.
    public static void agregarCupon() {
        val5 = false;
        System.out.println("Por favor ingrese los siguientes datos que se le solicitan.");
        //ingreso en una variable temporal para verificar la longitud igual a 4
        System.out.print("Ingrese el codigo de descuento:");
        cDescuento1 = in.next();
        //ingreso en una var temporal pra verificar que esté entre 1 y 99
        System.out.print("Ingrese el % de descuento (1-99):");
        pDescuento1 = in.nextDouble();
        //válida que el cupon no esté repetido
        validarCupon();

        if (val5){//si esta repetido imprimir esto
            System.out.print("El cupon ya esta en la lista, y no puede ser agregado 2 veces ");
            //si el descuento no es válido imprimir esto
        }else if (1 > pDescuento1 & pDescuento1 < 99){
            System.out.print("El descuento debe estar entre 1 y 99.");
            //si el codigo no tiene exactamente 4 digitos imprimir esto
        } else if (cDescuento1.length() != 4) {
            System.out.println("El codigo del cupon debe tener 4 caracteres.");
        } else {
            //de lo contrario imprimir esto
            System.out.println("\nEl codigo del cupon es: " + cDescuento1);
            System.out.println("El descuento es de: " + pDescuento1 + "%\n");
            System.out.print("Ingrese 1 para guardar, 2 para agregar otro o 3 para borrar:");
            //decicion
            seleccion = in.nextInt();

            //guardado
            if (seleccion == 1){
                cDescuento[v] = cDescuento1;
                pDescuento[v] = pDescuento1/100;
                v ++;
                System.out.println("Se ha guardado el articulo.");
            } else if (seleccion == 2) {
                //guardado y agregar otro cupon

                validarCupon();
                if (!val5){
                    cDescuento[v] = cDescuento1;
                    pDescuento[v] = pDescuento1;
                    v ++;
                    //la funcion se llama a si misma para agregar mas cupones
                    agregarCupon();
                }
            } else {
                //no se guarda el cupon y se regresa al menu
                System.out.println("Se ha borrado el cupon.");
            }
        }
    }

    //menu interno para realizar compras (compra de productos, cupones, factura).
    public static void comprar() {
        System.out.println("Realizar venta. \n");
        for (int i = 0; i < 10 && nProducto[i] != null; i++){
            i++;// aumento temporal solo para imprimir el numero
            System.out.print(i);
            i--;
            System.out.printf("%-15s",". " + nProducto[i]);
            System.out.println("valor: " + String.format("%.2f",pProducto[i]) );
        }

        System.out.print("\npor favor selecciones el producto que quiere comprar:");
        f = in.nextInt();//seleccion del producto
        f--;
        while (true){
            System.out.print("ingrese la cantidad que desea comprar de este producto:");
            cantidadCarrito1 = in.nextInt();//ingreso en una variable temporal para verificar que sea mayo a 0
            if (cantidadCarrito1 > 0){//si es mayor a 0 hacer esto
                carrito[f] = carrito[f] + cantidadCarrito1;
                System.out.println("se agrego " + String.format("%.0f",cantidadCarrito1) + " de " + nProducto[f] + " a la lista.");
                break;
            }else {//si es menor a 0 imprimir esto
                System.out.println("solo cantidades que sean mayores a cero");
            }
        }

        System.out.print("Para finalizar la compra ingrese 1, para seguir comprando ingrese 2: ");
        seleccion = in.nextInt();//decicion
        //for que calcula el valor total de la compra
        if (seleccion == 1){
            for (int i = 0;i < nProducto.length; i++){
                total1 = total1 + carrito[i] * pProducto[i];
            }
            System.out.println("su total es de: Q" + total1);
            System.out.print("si tiene un codigo de descuento ingrese 1, 2 para proceder con la factura: ");
            h = in.nextInt();//decicion
            while (true){
                if (h == 1){//ingreso de información para descuento
                    System.out.print("Ingrese el codigo de descuento: ");
                    cupon = in.next();
                    val6 = true;
                    for (int i = 0; i < cDescuento.length; i++ ){
                        if (cupon.equals(cDescuento[i])) {
                            val6 = false;
                            r = i;
                            break;
                        }
                    }
                    if (!val6){
                        subtotal = total1 - total1 * pDescuento[r];//aplicacion de descuento en valor total
                        break;
                    }else {//si se ingresa mal el codigo de descuento imprimir esto
                        System.out.println("El codigo no existe.");
                    }
                }else {//terminar el while
                    break;
                }
            }
            //print de la factura
            descuento = pDescuento[r] * total1;
            System.out.println("\nEmpresa:                Super 25");
            System.out.println("Cajero que atendió:     Dominic Ruano    ");
            System.out.println("Nombre del cliente:     "+nombreCliente);
            System.out.println("NIT:                    "+nitCliente);
            System.out.println("Emisión de la factura:  "+ LocalDate.now());
            System.out.println("Listado de productos:");
            l = 1;
            //print de los productos comprados
            for (int i = 0 ; i < nProducto.length && nProducto[i] != null; i++){
                if (carrito[i] != 0){
                    System.out.print(l + ". ");
                    l ++;
                    System.out.printf("%-12s",nProducto[i]);
                    System.out.println("valor unitario: " + pProducto[i]);
                    System.out.printf("%15s","Cantidad: " +String.format("%.0f",carrito[i]));
                    System.out.println("             Total: " + String.format("%.2f",pProducto[i] * carrito[i]));
                }
            }
            System.out.println("                Subtotal:  " + String.format("%.2f",total1));
            System.out.println("                Descuento: -" + String.format("%.2f",descuento) );
            System.out.println("                Total:     " + String.format("%.2f",total1 - descuento));
            //reinicio de algunas variables
            l = 0;
            descuento = 0;
            //for que copia array para reporte
            for (int i = 0; i < nProducto.length ; i++){
                if (carrito[i] > 0 && nProducto[i] != null){
                    copiaReporte[i] = copiaReporte[i] + carrito[i];
                    copiaReporte1[i] = copiaReporte[i];

                    copiaNReporte[i] = nProducto[i];
                    carrito[i] = 0;//borrado de carrito para proximas compras
                }
            }
            total1 = 1;
        } else{
            //se llama a si misma
            comprar();
        }
    }

    //menu externo para realizar compras (ingreso de nombre de cliente y/o nit, iteraciones varias para el reporte).
    public static void realizarCompra() {
        System.out.println("Por favor ingrese los siguientes datos:");
        System.out.print("Ingrese su nombre:");
        nombreCliente = in.next();//ingreso de nombre del cliente
        System.out.println("Ingrese 1 si tiene NIT o 2 para C/F");
        t = in.nextInt();//decicion
        if (t == 1){//esto si se tiene nit
            System.out.print("Digite su NIT: ");
            nitCliente = in.next();
        }else {//esto si C/f
            nitCliente = "C/F";
        }
        //llama a la funcion comprar
        comprar();
    }

    //menu reporte de productos más vendidos.
    public static void reporte( ) {
        //copia sin esto no funcion no se porque
        double[] ayuda;
        String[] ayudaN;
        ayuda = copiaReporte1.clone();
        ayudaN = copiaNReporte.clone();

        //ordenar los articulos
        for (int i = 0;i<copiaNReporte.length - 1; i++){
            for (int j = 0;j<copiaNReporte.length - i - 1; j++){
                if(ayuda[j] < ayuda[j+1]){
                    double temp = ayuda[j];
                    ayuda[j] = ayuda[j+1];
                    ayuda[j+1] = temp;

                    String temp1 = ayudaN[j];
                    ayudaN[j] = ayudaN[j+1];
                    ayudaN[j+1] = temp1;
                }
            }
        }
        System.out.println("\nEstos son los productos mas vendidos:");
        System.out.println("No.             Nombre:             Cantidad vendida:");
        for (int i = 0; i < ayudaN.length && ayudaN[i] != null; i++){
            i++;
            System.out.printf("%-16s","NO. "+i);
            i--;
            System.out.printf("%-20s", ayudaN[i]);
            System.out.printf("%-17s %n", ayuda[i]);
        }
    }
    public static void main(String[] args) {
        while (val){
            credenciales();
            while (val){
                if (user.equals(nombre) && password.equals(contra)){
                    menu();
                    switch (parametro){         //switch #1
                        case "1":
                            agregarProducto();
                            break;
                        case "2":
                            agregarCupon();
                            break;
                        case "3":
                            realizarCompra();
                            break;
                        case "4":
                            reporte();
                            break;
                        case "5":
                            val = false;
                            break;
                        default:
                            System.out.println("Opcion no valida o no ingreso un numero entero. ");
                    }
                }else {
                    System.out.println("¡El nombre de usuario o contraseña son incorrectos! \n");
                    break;
                }
            }
        }
    }
}