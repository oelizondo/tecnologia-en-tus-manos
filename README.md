## Tecnología en tus manos

### Demo

### Instalación
- ```git clone git@github.com:oelizondo/tecnologia-en-tus-manos.git```
- ```psql -U -a -f setup.sql```

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
La base de datos está hecha en Postgres, y el comando te mete a la consola de determinada base de datos.

Prender, apagar y reiniciar:
```console
./cli up
./cli down
./cli reset
```

Compilacion
```console
./cli compile
```
compila:
 - Controladores
 - Entidades
 - Interfaces
A WEB-INF. Cada vez que se haga un cambio tenemos que reiniciar la aplicación.
