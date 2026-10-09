# ✈️ Simulación de Torre de Control y Aterrizaje de Aviones (POO en Java)

Este proyecto es una aplicación en Java que modela la coordinación del tráfico aéreo entre aviones y una torre de control. Demuestra cómo gestionar recursos compartidos (una pista de aterrizaje), controlar el estado de los objetos y coordinar la comunicación bidireccional en memoria.

---

## 🧩 Clases y Estructura del Sistema

El dominio del problema está organizado en 3 clases principales:

*   **`Avion`**: Modela una aeronave que solicita autorización de aterrizaje.
    *   **Atributos:** `codigoVuelo`, `aerolinea` y `estadoVuelo`.
    *   **Métodos principales:**
        *   `cambiarEstadoVuelo(String nuevoEstado)`: Modifica el atributo de estado del avión e imprime la actualización por consola.
        *   `solicitarAterrizaje(TorreControl torre)`: Inicia el proceso de aterrizaje enviando su propia referencia (`this`) a la torre de control.
*   **`TorreControl`**: Representa el centro de mando y gestión de la pista.
    *   **Atributos de Estado:** `pistaLibre` (bandera booleana que indica la disponibilidad de la pista).
    *   **Métodos:** `autorizarAterrizaje(Avion avion)`, evalúa la disponibilidad de la pista. Si está libre, bloquea temporalmente el recurso (`pistaLibre = false`), cambia secuencialmente el estado del avión y finalmente libera la pista (`pistaLibre = true`).
*   **`Main`**: Instancia la torre de control y tres aviones de distintas aerolíneas, ejecutando de forma secuencial las solicitudes de aterrizaje.

---

## ⚙️ Reglas de Negocio y Control de Recursos Compartidos

El sistema aplica las siguientes reglas y flujos de control en tiempo de ejecución:

1. **Auto-referencia (`this`):** La clase `Avion` pasa su propia instancia a la `TorreControl` mediante `torre.autorizarAterrizaje(this)`, permitiendo que la torre manipule directamente sus métodos y estado.
2. **Exclusión Mutua / Control de Pista:** Antes de autorizar un aterrizaje, la torre verifica la bandera `pistaLibre`.
3. **Transición Secuencial de Estados:** Al autorizar el aterrizaje, la torre hace que el avión pase de `"Aterrizando"` a `"En tierra"`.
4. **Liberación del Recurso:** Una vez completada la maniobra, se reestablece `pistaLibre = true` para permitir solicitudes posteriores.

---

## 💻 Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente desglose por pantalla:

```text
Torre de control: solicitud recibida del vuelo AR101
Aterrizaje autorizado para AR101
Vuelo AR101 estado cambiado a Aterrizando
Vuelo AR101 estado cambiado a En tierra

Torre de control: solicitud recibida del vuelo LA202
Aterrizaje autorizado para LA202
Vuelo LA202 estado cambiado a Aterrizando
Vuelo LA202 estado cambiado a En tierra

Torre de control: solicitud recibida del vuelo IB303
Aterrizaje autorizado para IB303
Vuelo IB303 estado cambiado a Aterrizando
Vuelo IB303 estado cambiado a En tierra
