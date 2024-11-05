**Descripcion**:

Este aplicativo Java permite realizar conversiones de monedas entre distintas monedas usando tasas de cambio actualizadas en tiempo real proporcionadas por **ExchangeRate-API**. 
El aplicativo consulta la API, realiza el cálculo correspondiente y muestra el resultado al usuario.

Además de realizar conversiones, el aplicativo es capaz de generar un **reporte de conversiones**. 
Cada vez que se lleva a cabo una conversión, los detalles (como las monedas involucradas, el monto convertido y la fecha) se guardan en un archivo llamado `historial.json`. 
Este archivo permite al usuario revisar un registro detallado de todas las conversiones realizadas, ofreciendo una visión clara y organizada de su historial de conversiones.
