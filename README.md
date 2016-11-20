## Tecnología en tus manos

### Demo

### ¿Qué necesito para correr la aplicación?
- Postgres
- Git
- Tomcat
- Java

### Instalación
Navegar a la carpeta /usr/local/tomcat/webapps y clonar el repositorio:

- ```git clone git@github.com:oelizondo/tecnologia-en-tus-manos.git```

Después, ejecutar el _dump_ de SQL, es decir, crear la base de datos:

- ```psql -U -a -f setup.sql```

La base de datos inicialmente está vacía entonces tienes que meter tus datos manualmente.

### Usando la CLI para manejar tomcat
Tomcat es una porquería, por eso escribí una pequeña aplicación que maneja:
- compilaciones
- prender la aplicación
- apagar la aplicación
- reiniciar la aplicación
- Manejar el CLASSPATH de java
- manejar la base de datos

Para manejar el CLASSPATH:
```console
./cli classpath
```
Para utilizar la base de datos:
```console
./cli managedb
```

La base de datos está hecha en Postgres, y el comando te mete a la consola de determinada base de datos. Para hacer queries solamente los hacemos clásicamente:

```console
tetem=# SELECT * FROM Lectura;
```

Manejando Tomcat:

Prender, apagar y reiniciar:
```console
./cli up
./cli down
./cli reset
```

Compilacion de archivos:

```console
./cli compile
```
compila:
 - Controladores
 - Entidades
 - Interfaces

A la carpeta WEB-INF. Cada vez que se haga un cambio tenemos que reiniciar la aplicación.
