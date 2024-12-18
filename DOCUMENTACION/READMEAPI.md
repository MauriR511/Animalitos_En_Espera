# API

## ¿En que consiste?
La api es una interfaz de programación de aplicaciones (API o API web) que se ajusta a los límites de la arquitectura REST y permite la interacción con los servicios web de RESTful

## Tecnologias utilizadas
Para poder realizar la api se hico uso de node.js el cual es un entorno en tiempo de ejecución multiplataforma, de código abierto, para la capa del servidor basado en el lenguaje de programación JavaScript; ademas, se utilizo express.js el cual es un marco de desarrollo minimalista para Node.js que permite estructurar una aplicación de una manera ágil, nos proporciona funcionalidades como el enrutamiento, opciones para gestionar sesiones y cookies, etc. De igual forma se utilizo ciertas librerias de node que facilitaron el proceso del desarrollo de la API como "Jason Web Token" el cual ayudo para gestionar la aplicacion en base a tokens y roles

## Funcionamiento de la API

Nuestra Api está configurada de una manera global ¿Que quiere decir esto? Esta puede utilizarse sin necesidad de tener programas abiertos abiertos que la mantengan de una forma local, sino que se encuentra corriendo en un dominio virtual el cual está sostenido por digital ocean,haciendo que esta puede brindarle información a una aplicación en cualquier telefono.

## Estructura de la API

### Modelos
Los modelos se utilizan para definir la estructura que tendran los datos que se consumiran en la aplicaciíon, todo #26 mediante el esquema JSON, nuestros modelos son los siguientes:

    1. Pet
        En este modelo se definen cada uno de los parametros con los que se registraran las mascotas y se guardaran respectivamente en la base de datos.
            -Nombre
            -Edad
            -Personalidad
            -Vacunas
            -Especie
            -Tamaño
            -Peso
            -Fecha de nacimiento
            -Género
            -Historia
            -Requisitos de adopción

    2. Productos
        Modelo en el cual se definen los parametros que deben tener los productos a registrar y que se guardaran en la base de datos.
            -Nombre
            -Descripcion
            -Precio
            -Imagen

    3. Servicio
        Modelo en el que se definen cada uno de los parametros con los que se registraran los servicios y se guardaran respectivamente en la base de datos.
            -Nombre
            -Descripcion
            -Direccion
            -Teléfono 
            -Email
           
    4. Refugio
        Modelo en el que se definen cada uno de los parametros con los que se registraran los refugios y se guardaran respectivamente en la base de datos.
            -Nombre
            -Direccion
            -Teléfono
            -Email
            -Descripcion
            -Página web

    5. Adopción
        Modelo en que se definen los parametros de la creación del formulario de adopción y como se guardara respectivamente en la base de datos.
            -foto trasera del dui
            -foto delantera del dui
            -Direccion
            -foto del hogar
            -Mensaje

    6. Usuario
        Modelo en el que se definen cada uno de los parametros con los que se registraran los usuarios y se guardaran respectivamente en la base de datos.
            -Nombre completo
            -Email
            -Contraseña
            -Teléfono
            -Foto de perfil
            -rol

