# CASO FINAL 5

Analizaremos en detalle las funcionalidades de la clase **MAIN**, la cual representa una aplicación GUI basada en Java Swing. La aplicación ofrece un menú con diferentes funcionalidades relacionadas con análisis genómico, organización de datos, y entretenimiento.

## Funciones Principales:

### 1. setNimbusLookAndFeel (También es una Funcionalidad Extra)
- **Propósito**: Configura el "Look and Feel" de Nimbus para la interfaz de usuario. Nimbus es un tema para interfaces gráficas de Java que proporciona una apariencia moderna y estilizada.
- **Cómo Funciona**: Itera sobre los Look and Feels disponibles en la plataforma y establece Nimbus si se encuentra disponible.

### 2. actionPerformed
- **Propósito**: Gestiona las acciones producidas por los botones en la interfaz. Dependiendo del botón presionado, se ejecuta una funcionalidad específica.
- **Cómo Funciona**: Utiliza un switch para identificar el comando de acción asociado con cada botón y llama al método correspondiente.

### 3. ConteoDeGenes, CombinacionesGeneticas, GestionFechas, BusquedaBinaria, Listadodenumerosenunrango, SumatoriaDeNumerosNaturales, OptimizedQuicksort, OrdenarLineas, MaximoPosicion
- **Propósito**: Estas funciones realizan las operaciones específicas indicadas por sus nombres, como el conteo de genes en una secuencia de ADN, cálculo de combinaciones genéticas, y más.
- **Cómo Funcionan**: Cada función implementa una lógica específica para su propósito. Por ejemplo, `ConteoDeGenes` podría analizar una cadena de ADN para contar los genes, mientras que `GestionFechas` maneja la entrada de fechas y las ordena.

## Funciones Adicionales

### 1. abrirJuegoTicTacToe
- **Propósito**: Abre una nueva ventana con un juego básico de Tic-Tac-Toe.
- **Cómo Funciona**: Crea una ventana con un grid de 3x3 usando `JButton` para cada celda del juego. Los jugadores alternan marcando las celdas con "X" o "O". La lógica para determinar el ganador debe ser implementada adicionalmente.

### 2. abrirAsistenteVirtual
- **Propósito**: Inicia una interacción simple con un asistente virtual mediante cuadros de diálogo.
- **Cómo Funciona**: Muestra un cuadro de diálogo que invita al usuario a ingresar una pregunta, y luego responde con un mensaje predeterminado. Este método es una base para implementaciones más complejas de un asistente virtual.
