# Magic-Pabs-App
 Magic Pabs App es una aplicación para gestionar espectaculos de magia de la forma mas comoda posible
 
 # Proximamente...
 La aplicación cuenta con una pequeña app para dispositivos android que colgare aquí cuando me sea posible. La app esta terminada pero falta configurarla para que pueda estar disponible para todo el mundo aquí en GitHub.
 ## ¿Quieres ayudar a que Magic Pabs App crezca?
 La idea es que esta aplicación crezca, empezando por centralizarla en una app web y gestionarla con usuarios.
 Si te gusta esta idea y te gustaría participar en el desarrollo no dudes en contactar conmigo.

# Instalación de Magic Pabs App
Lo primero que tendremos que hacer es crear la base de datos en nuestro servidor/equipo(esto último si lo queremos hacer en local) con el fichero Magic Pabs App.sql.
Una vez este la base de datos creada tendremos que configurar y hacer deploy de la API REST
## Configuración y deploy de la API REST
Necesitaremos tener instalado wildfly en nuestro equipo o servidor. Para esto, solamente tendremos que configurar el usuario y la contraseña del SQL en el archivo persistance.xml.
Una vez instalada la API REST toca configurar nuestra aplicación de escritorio.
## Configuración de la aplicación de escritorio
Solamente necesitamos configurar 2 cosas de la aplicación de escirtorio.
La primera será la dirección de la API, si estamos en local no hara falta tocar nada, en el caso que este en un servidor tendremos que modificar el archivo ServicioAPI.cs y cambiar este valor por el endpoint de nuestra API
```c#
public readonly static string endpoint = "http://localhost:8081/apirestmagicpabs/api/";
```
El proyecto usa la libreria Syncfusion, la cual es de pago, si se dispone de una licencia se tendrá que poner en el archivo App.xaml.cs
```c#
Syncfusion.Licensing.SyncfusionLicenseProvider.RegisterLicense("IntroducirAquiLaLicencia");
```
## Prueba el rendimiento de la aplicación
Por último comentar que en este repositorio se encuentra un test de rendimiento para la aplicación, para su uso modificar el test en JMeter y cambiar la URL de la API REST a donde la tengamos (por defecto esta configurado para que funcione en local). Para la ejecucion del test solamente hay que activar el test que deseemos y ejecutarlo. Importante, el test de estres carga 2500 hilos haciendo peticiones sin parar durante un minuto, si el servidor no tiene capacidad para soportar esa cantidad de peticiones se recomienda no ejecutar este test.
